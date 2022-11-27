/*
 * Copyright 2019-2022 Pranav Pandey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pranavpandey.android.dynamic.theme.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.InvertedLuminanceSource;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.pranavpandey.android.dynamic.theme.AppTheme;
import com.pranavpandey.android.dynamic.theme.Theme;
import com.pranavpandey.android.dynamic.theme.base.CodeTheme;
import com.pranavpandey.android.dynamic.theme.base.CornerTheme;
import com.pranavpandey.android.dynamic.theme.base.StrokeTheme;
import com.pranavpandey.android.dynamic.theme.base.TranslucentTheme;
import com.pranavpandey.android.dynamic.util.DynamicBitmapUtils;
import com.pranavpandey.android.dynamic.util.DynamicColorUtils;
import com.pranavpandey.android.dynamic.util.DynamicDrawableUtils;
import com.pranavpandey.android.dynamic.util.DynamicUnitUtils;

import java.util.EnumMap;
import java.util.Map;

/**
 * Helper class to perform theme code operations.
 */
public class DynamicCodeUtils {

    /**
     * Constant for the line break.
     */
    public static final String PATTERN_LINE_BREAK = "[\\r|\\n]";

    /**
     * Pattern to replace extra quotes.
     */
    public static final String PATTERN_QUOTES = "[\"\\\"][\\s+][\\\"\"]";

    /**
     * Pattern to replace white space.
     */
    public static final String PATTERN_SPACE = "[\\s+]";

    /**
     * Constant to render line break.
     */
    public static final String LINE_BREAK = "\\\\n";

    /**
     * Format data to suitable for the code.
     * 
     * @param data The data to be formatted.
     * 
     * @return The formatted data suitable for the code.
     */
    public static @Nullable String format(@Nullable String data) {
        if (data == null) {
            return null;
        }

        return data.replaceAll(PATTERN_LINE_BREAK, LINE_BREAK);
    }

    /**
     * Returns the error correction level according to the supplied content.
     *
     * @param content The content to be used.
     *
     * @return The error correction level according to the supplied content.
     */
    public static @NonNull ErrorCorrectionLevel getErrorCorrectionLevel(@Nullable String content) {
        if (content == null) {
            return ErrorCorrectionLevel.L;
        }

        return content.length() <= Theme.Code.Correction.HIGH
                ? ErrorCorrectionLevel.H : content.length() <= Theme.Code.Correction.MEDIUM
                ? ErrorCorrectionLevel.M : ErrorCorrectionLevel.L;
    }

    /**
     * Returns the paint according to the supplied code style.
     *
     * @param style The code style to be used.
     *
     * @return The paint according to the supplied code style.
     */
    public static @NonNull Paint getPaint(@Theme.Code.Style int style) {
        final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint.setStrokeCap(style == Theme.Code.Style.OVAL
                ? Paint.Cap.ROUND : style == Theme.Code.Style.ROUND
                ? Paint.Cap.BUTT : Paint.Cap.SQUARE);

        return paint;
    }

    /**
     * Returns a corner drawable according to the supplied parameters.
     *
     * @param width The width in dip for the drawable.
     * @param height The height in dip for the drawable.
     * @param cornerRadius The corner size in dip for the drawable.
     * @param color The color for the drawable.
     * @param topOnly {@code true} to round the top corners only.
     *
     * @return The corner drawable according to the supplied parameters.
     */
    public static @NonNull Drawable getCornerDrawable(int width, int height,
            float cornerRadius, @ColorInt int color, boolean topOnly) {
        float adjustedCornerRadius = cornerRadius;

        if (!topOnly) {
            return DynamicDrawableUtils.getCornerDrawable(
                    width, height, adjustedCornerRadius, color);
        } else {
            adjustedCornerRadius = Math.max(0,
                    cornerRadius - Theme.Corner.FACTOR_CORNER);
            adjustedCornerRadius = DynamicUnitUtils.convertDpToPixels(adjustedCornerRadius);
            GradientDrawable drawable = new GradientDrawable();
            drawable.setCornerRadii(new float[] {
                    adjustedCornerRadius, adjustedCornerRadius,
                    adjustedCornerRadius, adjustedCornerRadius,
                    0, 0, 0, 0 });

            return DynamicDrawableUtils.getCornerDrawable(width, height, drawable, color);
        }
    }

    /**
     * Returns a corner drawable according to the supplied parameters.
     *
     * @param cornerRadius The corner size in dip for the drawable.
     * @param color The color for the drawable.
     * @param topOnly {@code true} to round the top corners only.
     *
     * @return The corner drawable according to the supplied parameters.
     */
    public static @NonNull Drawable getCornerDrawable(float cornerRadius,
            @ColorInt int color, boolean topOnly) {
        return getCornerDrawable(0, 0, cornerRadius, color, topOnly);
    }

    /**
     * Returns a corner drawable according to the supplied parameters.
     *
     * @param width The width in dip for the drawable.
     * @param height The height in dip for the drawable.
     * @param cornerRadius The corner size in dip for the drawable.
     * @param color The color for the drawable.
     * @param topOnly {@code true} to round the top corners only.
     * @param strokeSize The size {@code greater than 0} in dip to enable the stroke.
     * @param strokeColor The color for the stroke.
     *
     * @return The corner drawable according to the supplied parameters.
     */
    public static @NonNull Drawable getCornerDrawableWithStroke(int width, int height,
            float cornerRadius, @ColorInt int color, boolean topOnly,
            float strokeSize, @ColorInt int strokeColor) {
        Drawable drawable = getCornerDrawable(width, height, cornerRadius, color, topOnly);

        if (strokeSize > 0 && Color.alpha(strokeColor) > 0
                && drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setStroke(
                    DynamicUnitUtils.convertDpToPixels(strokeSize), strokeColor);
        }

        return drawable;
    }

    /**
     * Returns a corner drawable according to the supplied parameters.
     *
     * @param width The width in dip for the drawable.
     * @param height The height in dip for the drawable.
     * @param cornerRadius The corner size in dip for the drawable.
     * @param color The color for the drawable.
     * @param topOnly {@code true} to round the top corners only.
     * @param strokeColor The color for the stroke.
     *
     * @return The corner drawable according to the supplied parameters.
     */
    public static @NonNull Drawable getCornerDrawableWithStroke(int width, int height,
            float cornerRadius, @ColorInt int color, boolean topOnly, @ColorInt int strokeColor) {
        return getCornerDrawableWithStroke(width, height, cornerRadius, color,
                topOnly, Theme.Size.STROKE, strokeColor);
    }

    /**
     * Returns a corner drawable according to the supplied parameters.
     *
     * @param width The width in dip for the drawable.
     * @param height The height in dip for the drawable.
     * @param cornerRadius The corner size in dip for the drawable.
     * @param color The color for the drawable.
     * @param topOnly {@code true} to round the top corners only.
     *
     * @return The corner drawable according to the supplied parameters.
     */
    public static @NonNull Drawable getCornerDrawableWithStroke(int width, int height,
            float cornerRadius, @ColorInt int color, boolean topOnly) {
        return getCornerDrawableWithStroke(width, height, cornerRadius,
                color, topOnly, Theme.Size.STROKE, DynamicColorUtils.setAlpha(
                        DynamicColorUtils.getTintColor(color), Theme.Opacity.STROKE));
    }

    /**
     * Returns a corner drawable according to the supplied parameters.

     * @param cornerRadius The corner size in dip for the drawable.
     * @param color The color for the drawable.
     * @param topOnly {@code true} to round the top corners only.
     * @param strokeSize The size {@code greater than 0} in dip to enable the stroke.
     * @param strokeColor The color for the stroke.
     *
     * @return The corner drawable according to the supplied parameters.
     */
    public static @NonNull Drawable getCornerDrawableWithStroke(float cornerRadius,
            @ColorInt int color, boolean topOnly, float strokeSize, @ColorInt int strokeColor) {
        return getCornerDrawableWithStroke(0, 0,
                cornerRadius, color, topOnly, strokeSize, strokeColor);
    }

    /**
     * Returns a corner drawable according to the supplied parameters.

     * @param cornerRadius The corner size in dip for the drawable.
     * @param color The color for the drawable.
     * @param topOnly {@code true} to round the top corners only.
     *
     * @return The corner drawable according to the supplied parameters.
     */
    public static @NonNull Drawable getCornerDrawableWithStroke(
            float cornerRadius, @ColorInt int color, boolean topOnly) {
        return getCornerDrawableWithStroke(0, 0, cornerRadius, color, topOnly);
    }

    /**
     * Generates a QR Code from the dynamic theme.
     *
     * @param theme The theme to generate the QR Code.
     * @param data The data for the QR Code.
     * @param overlay The optional QR Code overlay.
     *
     * @return The generated QR Code from the dynamic theme.
     */
    public static @Nullable Bitmap generateCode(@Nullable CodeTheme<?> theme,
            @Nullable String data, @Nullable Drawable overlay) {
        if (theme == null || data == null) {
            return null;
        }

        Bitmap bitmap = null;
        Bitmap bitmapCode;
        @ColorInt int backgroundColor =
                DynamicColorUtils.removeAlpha(theme.getCodeBackgroundColor());
        @ColorInt int dataColor = DynamicColorUtils.removeAlpha(
                DynamicColorUtils.getContrastColor(theme.getCodeDataColor(),
                        backgroundColor, theme.getCodeContrastRatio()));
        @ColorInt int finderExternalColor = dataColor;
        @ColorInt int finderInternalColor = DynamicColorUtils.removeAlpha(
                DynamicColorUtils.getContrastColor(theme.getCodeFinderColor(),
                        backgroundColor, theme.getCodeContrastRatio()));
        @Theme.Code.Style int style = theme.getCodeStyle();

        @ColorInt int overlayColor = Theme.Color.UNKNOWN;
        if (theme.getCodeOverlayColor() != Theme.Color.UNKNOWN) {
            overlayColor = DynamicColorUtils.removeAlpha(DynamicColorUtils.getContrastColor(
                    theme.getCodeOverlayColor(), backgroundColor, theme.getCodeContrastRatio()));
        }

        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, Theme.CHARACTER_SET);

        try {
            ByteMatrix byteMatrix = Encoder.encode(data,
                    getErrorCorrectionLevel(data), hints).getMatrix();
            int quietZone = Theme.Size.QUIET_ZONE;
            int inputWidth = byteMatrix.getWidth();
            int inputHeight = byteMatrix.getHeight();
            int codeWidth = inputWidth + (quietZone * 2);
            int codeHeight = inputHeight + (quietZone * 2);
            int outputWidth = Math.max(Theme.Size.DEFAULT, codeWidth);
            int outputHeight = Math.max(Theme.Size.DEFAULT, codeHeight);
            int multiple = Math.min(outputWidth / codeWidth, outputHeight / codeHeight);

            final int FINDER_SIZE = 7;
            final float OVERLAY_FACTOR = Theme.Size.FACTOR_OVERLAY;
            final float PADDING_FACTOR = style == Theme.Code.Style.OVAL ? 1.85f : 2f;
            final int OVERLAY_SIZE = overlay != null ? (int) (Math.min(
                    inputWidth, inputHeight) * OVERLAY_FACTOR) : 0;
            final int OVERLAY_SIZE_CENTER = OVERLAY_SIZE / 2;
            final float SCALE_DOWN_FACTOR = (style == Theme.Code.Style.ROUND
                    || style == Theme.Code.Style.OVAL ? 21f / 30f : 1f);

            int overlaySize = (int) (multiple * (OVERLAY_SIZE
                    - (Theme.Size.FACTOR_OVERLAY_PADDING * OVERLAY_SIZE)));
            float corner = Theme.Corner.MIN;
            int cornerDp = Theme.Corner.MIN;

            if (theme instanceof CornerTheme) {
                corner = ((CornerTheme<?>) theme).getCornerRadius();
                cornerDp = ((CornerTheme<?>) theme).getCornerSize();

                final int startWidth = (outputWidth - codeWidth * multiple) / 2;
                final int startHeight = (outputHeight - codeHeight * multiple) / 2;

                if (corner > Math.min(startWidth, startHeight)) {
                    final int factor = (int) (corner - Math.min(startWidth, startHeight));
                    outputWidth = outputWidth + factor;
                    outputHeight = outputHeight + factor;
                }
            }

            int inputCenterX = inputWidth / 2;
            int inputCenterY = inputHeight / 2;
            int outputCenterX = outputWidth / 2;
            int outputCenterY = outputHeight / 2;
            int leftPadding = (int) ((outputWidth - (inputWidth * multiple)) / PADDING_FACTOR);
            int topPadding = (int) ((outputHeight - (inputHeight * multiple)) / PADDING_FACTOR);
            int dataSize = (int) (multiple * SCALE_DOWN_FACTOR);
            int dataRadius = dataSize / 2;
            int finderDiameter = multiple * FINDER_SIZE;
            float cornerData = Theme.Corner.MIN;

            if (theme instanceof CornerTheme) {
                cornerData = style == Theme.Code.Style.ROUND
                        ? Math.min(((CornerTheme<?>) theme).getCornerRadius(), finderDiameter / 2)
                        : Theme.Corner.MIN;
            }

            bitmap = Bitmap.createBitmap(outputWidth, outputHeight, Bitmap.Config.ARGB_8888);
            bitmapCode = Bitmap.createBitmap(outputWidth, outputHeight, Bitmap.Config.ARGB_8888);
            final Canvas canvas = new Canvas(bitmap);
            final Canvas canvasCode = new Canvas(bitmapCode);
            final Paint paint = getPaint(style);

            if (theme instanceof StrokeTheme) {
                final Drawable background;
                if (((StrokeTheme<?>) theme).isStroke()) {
                    background = DynamicCodeUtils.getCornerDrawableWithStroke(
                            outputWidth, outputHeight, cornerDp, backgroundColor,
                            false, theme.getCodeStrokeColor());
                } else {
                    background = DynamicCodeUtils.getCornerDrawable(outputWidth,
                            outputHeight, cornerDp, backgroundColor, false);
                }

                if (theme instanceof TranslucentTheme) {
                    background.setAlpha(((TranslucentTheme<?>) theme).getOpacity());
                }

                background.setBounds(0, 0, outputWidth, outputHeight);
                background.draw(canvas);
            } else {
                paint.setColor(backgroundColor);
                canvas.drawPaint(paint);
            }

            for (int inputY = 0, outputY = topPadding; inputY < inputHeight;
                 inputY++, outputY += multiple) {
                for (int inputX = 0, outputX = leftPadding; inputX < inputWidth;
                     inputX++, outputX += multiple) {
                    if (byteMatrix.get(inputX, inputY) == 1) {
                        if (!(inputX <= FINDER_SIZE && inputY <= FINDER_SIZE
                                || inputX >= inputWidth - FINDER_SIZE
                                && inputY <= FINDER_SIZE
                                || inputX <= FINDER_SIZE
                                && inputY >= inputHeight - FINDER_SIZE
                                || inputX >= inputCenterX - OVERLAY_SIZE_CENTER
                                && inputX <= inputCenterX + OVERLAY_SIZE_CENTER
                                && inputY >= inputCenterY - OVERLAY_SIZE_CENTER
                                && inputY <= inputCenterY + OVERLAY_SIZE_CENTER)) {
                            paint.setColor(dataColor);

                            if (style == Theme.Code.Style.OVAL) {
                                canvasCode.drawCircle(outputX, outputY, dataRadius, paint);
                            } else {
                                canvasCode.drawRect(new Rect(outputX, outputY,
                                        outputX + dataSize, outputY + dataSize), paint);
                            }
                        }
                    }
                }
            }

            drawCodeFinder(canvasCode, leftPadding, topPadding, finderDiameter, paint,
                    finderExternalColor, finderInternalColor, cornerData, style);
            drawCodeFinder(canvasCode, leftPadding + (inputWidth - FINDER_SIZE) * multiple,
                    topPadding, finderDiameter, paint, finderExternalColor,
                    finderInternalColor, cornerData, style);
            drawCodeFinder(canvasCode, leftPadding, topPadding + (inputHeight - FINDER_SIZE)
                            * multiple, finderDiameter, paint, finderExternalColor,
                    finderInternalColor, cornerData, style);

            canvas.drawBitmap(bitmapCode, 0, 0, null);
            bitmapCode.recycle();

            if (overlay != null) {
                Bitmap overlayBitmap = DynamicBitmapUtils.getBitmap(
                        overlay, overlaySize, overlaySize);

                if (overlayColor != Theme.Color.UNKNOWN) {
                    paint.setColorFilter(new PorterDuffColorFilter(
                            overlayColor, PorterDuff.Mode.SRC_ATOP));
                } else {
                    paint.setColorFilter(null);
                }

                if (overlayBitmap != null) {
                    canvas.drawBitmap(overlayBitmap, outputCenterX - overlaySize / 2f,
                            outputCenterY - overlaySize / 2f, paint);
                }
            }
        } catch (Exception ignored) {
        }

        return bitmap;
    }

    /**
     * Draws the finder for the QR Code according to the supplied parameters.
     *
     * @param canvas The canvas to be used.
     * @param x The x-axis start location.
     * @param y The y-axis start location.
     * @param diameter The diameter to be used.
     * @param paint The paint to be used.
     * @param parent The parent color to be set.
     * @param child The child color to be set.
     * @param corner The corner radius to be set.
     * @param style The style to be used.
     */
    private static void drawCodeFinder(@Nullable Canvas canvas, int x, int y,
            int diameter, @Nullable Paint paint, @ColorInt int parent, @ColorInt int child,
            float corner, @Theme.Code.Style int style) {
        if (canvas == null || paint == null) {
            return;
        }

        final int PARENT_SIZE = diameter * 5 / 7;
        final int PARENT_OFFSET = diameter / 7;
        final int CHILD_SIZE = diameter * 3 / 7;
        final int CHILD_OFFSET = diameter * 2 / 7;
        final Paint clear = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        clear.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));

        if (style == Theme.Code.Style.OVAL) {
            paint.setColor(parent);
            canvas.drawCircle(x + PARENT_OFFSET + CHILD_OFFSET,
                    y + PARENT_OFFSET + CHILD_OFFSET, diameter / 2f, paint);
            canvas.drawCircle(x + PARENT_OFFSET + CHILD_OFFSET,
                    y + PARENT_OFFSET + CHILD_OFFSET, PARENT_SIZE / 2f, clear);
            paint.setColor(child);
            canvas.drawCircle(x + PARENT_OFFSET + CHILD_OFFSET,
                    y + PARENT_OFFSET + CHILD_OFFSET, CHILD_SIZE / 2f, paint);
        } else if (style == Theme.Code.Style.ROUND) {
            paint.setColor(parent);
            canvas.drawRoundRect(new RectF(x, y, x + diameter,
                    y + diameter), corner, corner, paint);
            canvas.drawRoundRect(new RectF(x + PARENT_OFFSET, y + PARENT_OFFSET,
                    x + diameter - PARENT_OFFSET, y + diameter - PARENT_OFFSET),
                    corner, corner, clear);
            paint.setColor(child);
            canvas.drawRoundRect(new RectF(x + CHILD_OFFSET, y + CHILD_OFFSET,
                    x + diameter - CHILD_OFFSET, y + diameter - CHILD_OFFSET),
                    corner, corner, paint);
        } else {
            paint.setColor(parent);
            canvas.drawRect(new Rect(x, y, x + diameter, y + diameter), paint);
            canvas.drawRect(x + PARENT_OFFSET, y + PARENT_OFFSET,
                    x + diameter - PARENT_OFFSET, y + diameter - PARENT_OFFSET, clear);
            paint.setColor(child);
            canvas.drawRect(x + CHILD_OFFSET, y + CHILD_OFFSET,
                    x + diameter - CHILD_OFFSET, y + diameter - CHILD_OFFSET, paint);
        }
    }

    /**
     * Generates a QR Code from the dynamic theme.
     *
     * @param theme The theme to generate the QR Code.
     * @param overlay The optional QR Code overlay.
     *
     * @return The generated QR Code from the dynamic theme.
     *
     * @see #generateCode(CodeTheme, String, Drawable)
     */
    public static @Nullable Bitmap generateCode(
            @Nullable CodeTheme<?> theme, @Nullable Drawable overlay) {
        if (theme == null) {
            return null;
        }

        return generateCode(theme, theme.getCodeData(), overlay);
    }

    /**
     * Generates a QR Code for the dynamic theme data.
     *
     * @param theme The theme to generate the QR Code.
     * @param overlay The optional QR Code overlay.
     *
     * @return The generated QR Code for the dynamic theme data.
     *
     * @see #generateCode(CodeTheme, String, Drawable)
     */
    public static @Nullable Bitmap generateThemeCode(
            @Nullable AppTheme<?> theme, @Nullable Drawable overlay) {
        if (theme == null) {
            return null;
        }

        return generateCode(theme, theme.getThemeData(), overlay);
    }

    /**
     * Scans the code for the result.
     *
     * @param bitmap The bitmap to be scanned.
     *
     * @return The result from the code.
     */
    public static @Nullable Result scanCode(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }

        Bitmap resized;
        if (bitmap.getWidth() > Theme.Size.DEFAULT || bitmap.getHeight() > Theme.Size.DEFAULT) {
            resized = DynamicBitmapUtils.resizeBitmap(bitmap, bitmap.getWidth(),
                    bitmap.getHeight(), Theme.Size.DEFAULT, Theme.Size.DEFAULT);
        } else {
            resized = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        }

        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }

        if (resized == null) {
            return null;
        }

        Result result = null;
        int[] pixels = new int[resized.getWidth() * resized.getHeight()];
        resized.getPixels(pixels, 0, resized.getWidth(),
                0, 0, resized.getWidth(), resized.getHeight());

        LuminanceSource source = new RGBLuminanceSource(
                resized.getWidth(), resized.getHeight(), pixels);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new MultiFormatReader();
        Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.CHARACTER_SET, Theme.CHARACTER_SET);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);

        try {
            result = reader.decode(binaryBitmap, hints);
        } catch (Exception again) {
            binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(source));

            try {
                result = reader.decode(binaryBitmap, hints);
            } catch (Exception tryAgain1) {
                source = new InvertedLuminanceSource(source);
                binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = reader.decode(binaryBitmap, hints);
                } catch (Exception tryOnceMore) {
                    binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(source));

                    try {
                        result = reader.decode(binaryBitmap, hints);
                    } catch (Exception ignored) {
                    }
                }
            }
        } finally {
            resized.recycle();
            reader.reset();
        }

        return result;
    }

    /**
     * Scans the dynamic theme QR Code.
     *
     * @param bitmap The bitmap to be scanned.
     *
     * @return The dynamic theme string from the QR Code bitmap.
     */
    public static @Nullable String getTheme(@Nullable Bitmap bitmap) {
        final Result result;
        if ((result = scanCode(bitmap)) != null) {
            return result.getText();
        }

        return null;
    }
}
