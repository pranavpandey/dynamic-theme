/*
 * Copyright 2019-2021 Pranav Pandey
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

package com.pranavpandey.android.dynamic.theme.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.InvertedLuminanceSource;
import com.google.zxing.LuminanceSource;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.common.GlobalHistogramBinarizer;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.pranavpandey.android.dynamic.theme.Theme;
import com.pranavpandey.android.dynamic.theme.ThemeContract;
import com.pranavpandey.android.dynamic.theme.base.AccentTheme;
import com.pranavpandey.android.dynamic.theme.base.BackgroundTheme;
import com.pranavpandey.android.dynamic.theme.base.CodeTheme;
import com.pranavpandey.android.dynamic.theme.base.CornerTheme;
import com.pranavpandey.android.dynamic.theme.base.PrimaryTheme;
import com.pranavpandey.android.dynamic.theme.base.StringTheme;
import com.pranavpandey.android.dynamic.utils.DynamicBitmapUtils;
import com.pranavpandey.android.dynamic.utils.DynamicColorUtils;
import com.pranavpandey.android.dynamic.utils.DynamicDeviceUtils;
import com.pranavpandey.android.dynamic.utils.DynamicFileUtils;
import com.pranavpandey.android.dynamic.utils.DynamicIntentUtils;
import com.pranavpandey.android.dynamic.utils.DynamicUnitUtils;

import org.json.JSONObject;

import java.io.File;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Helper class to perform theme operations.
 */
public class DynamicThemeUtils {

    /**
     * Pattern to replace the next line.
     */
    public static final String PATTERN_LINE = "\n";

    /**
     * Pattern to replace extra quotes.
     */
    public static final String PATTERN_QUOTES = "[\"\\\"][\\s+][\\\"\"]";

    /**
     * Pattern to replace white space.
     */
    public static final String PATTERN_SPACE = "[\\s+]";

    /**
     * Returns the key-value map to encode the theme string.
     *
     * @return The key-value map to encode the theme string.
     */
    public static @NonNull HashMap<String, String> getThemeMap() {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put(Theme.Key.BRACKETS, Theme.Key.Short.BRACKETS);
        map.put(Theme.Key.QUOTE, Theme.Key.Short.QUOTE);
        map.put(Theme.Value.SPLIT, Theme.Value.Short.SPLIT);
        map.put(Theme.Value.HASH, Theme.Value.Short.HASH);
        map.put(Theme.Key.SPLIT, Theme.Key.Short.SPLIT);
        map.put(Theme.Key.DARK, Theme.Key.Short.DARK);
        map.put(Theme.Key.INVERSE, Theme.Key.Short.INVERSE);
        map.put(Theme.Key.BACKGROUND, Theme.Key.Short.BACKGROUND);
        map.put(Theme.Key.TINT_BACKGROUND, Theme.Key.Short.TINT_BACKGROUND);
        map.put(Theme.Key.SURFACE, Theme.Key.Short.SURFACE);
        map.put(Theme.Key.TINT_SURFACE, Theme.Key.Short.TINT_SURFACE);
        map.put(Theme.Key.PRIMARY, Theme.Key.Short.PRIMARY);
        map.put(Theme.Key.TINT_PRIMARY, Theme.Key.Short.TINT_PRIMARY);
        map.put(Theme.Key.PRIMARY_DARK, Theme.Key.Short.PRIMARY_DARK);
        map.put(Theme.Key.TINT_PRIMARY_DARK, Theme.Key.Short.TINT_PRIMARY_DARK);
        map.put(Theme.Key.ACCENT, Theme.Key.Short.ACCENT);
        map.put(Theme.Key.TINT_ACCENT, Theme.Key.Short.TINT_ACCENT);
        map.put(Theme.Key.ACCENT_DARK, Theme.Key.Short.ACCENT_DARK);
        map.put(Theme.Key.TINT_ACCENT_DARK, Theme.Key.Short.TINT_ACCENT_DARK);
        map.put(Theme.Key.ERROR, Theme.Key.Short.ERROR);
        map.put(Theme.Key.TINT_ERROR, Theme.Key.Short.TINT_ERROR);
        map.put(Theme.Key.TEXT_PRIMARY, Theme.Key.Short.TEXT_PRIMARY);
        map.put(Theme.Key.TEXT_PRIMARY_INVERSE, Theme.Key.Short.TEXT_PRIMARY_INVERSE);
        map.put(Theme.Key.TEXT_SECONDARY, Theme.Key.Short.TEXT_SECONDARY);
        map.put(Theme.Key.TEXT_SECONDARY_INVERSE, Theme.Key.Short.TEXT_SECONDARY_INVERSE);
        map.put(Theme.Key.FONT_SCALE, Theme.Key.Short.FONT_SCALE);
        map.put(Theme.Key.CORNER_RADIUS, Theme.Key.Short.CORNER_RADIUS);
        map.put(Theme.Key.BACKGROUND_AWARE, Theme.Key.Short.BACKGROUND_AWARE);
        map.put(Theme.Key.STYLE, Theme.Key.Short.STYLE);
        map.put(Theme.Key.TYPE, Theme.Key.Short.TYPE);
        map.put(Theme.Key.HEADER, Theme.Key.Short.HEADER);
        map.put(Theme.Key.OPACITY, Theme.Key.Short.OPACITY);
        map.put(Theme.Key.CONTRAST, Theme.Key.Short.CONTRAST);
        map.put(Theme.Value.AUTO, Theme.Value.Short.AUTO);
        map.put(Theme.Value.APP, Theme.Value.Short.APP);
        map.put(Theme.Value.DAY, Theme.Value.Short.DAY);
        map.put(Theme.Value.NIGHT, Theme.Value.Short.NIGHT);
        map.put(Theme.Value.CUSTOM, Theme.Value.Short.CUSTOM);
        map.put(Theme.Value.DISABLE, Theme.Value.Short.DISABLE);
        map.put(Theme.Value.ENABLE, Theme.Value.Short.ENABLE);
        map.put(Theme.Value.HIDE, Theme.Value.Short.HIDE);
        map.put(Theme.Value.SHOW, Theme.Value.Short.SHOW);

        return map;
    }

    /**
     * Returns the file name to save the theme.
     *
     * @param prefix The prefix before the file name.
     * @param extension The file extension to be used.
     *
     * @return The file name to save the theme.
     */
    public static @NonNull String getFileName(
            @Nullable  String prefix, @NonNull String extension) {
        if (prefix == null) {
            prefix = "";
        }

        return prefix + DynamicDeviceUtils.getDateWithSeparator(
                System.currentTimeMillis()) + extension;
    }

    /**
     * Returns the file name to save the theme.
     *
     * @param extension The file extension to be used.
     *
     * @return The file name to save the theme.
     */
    public static @NonNull String getFileName(@NonNull String extension) {
        return getFileName(Theme.Key.SHARE + "-", extension);
    }

    /**
     * Converts the color integer into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the color.
     */
    public static @NonNull String getValueFromColor(int value) {
        if (value == Theme.AUTO) {
            return Theme.Value.AUTO;
        } else {
            return DynamicColorUtils.getColorString(value,
                    DynamicColorUtils.isAlpha(value), true);
        }
    }

    /**
     * Converts the color string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the color.
     */
    public static int getValueFromColor(@NonNull String value) {
        if (Theme.Value.AUTO.equals(value) || Theme.Value.Short.AUTO.equals(value)) {
            return Theme.AUTO;
        } else {
            return Color.parseColor(value.replace(Theme.Value.Short.HASH, Theme.Value.HASH));
        }
    }

    /**
     * Converts the font scale into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the font scale.
     */
    public static @NonNull String getValueFromFontScale(int value) {
        if (value == Theme.AUTO) {
            return Theme.Value.AUTO;
        } else {
            return String.valueOf(value);
        }
    }

    /**
     * Converts the font scale string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the font scale.
     */
    public static int getValueFromFontScale(@NonNull String value) {
        if (Theme.Value.AUTO.equals(value) || Theme.Value.Short.AUTO.equals(value)) {
            return Theme.AUTO;
        } else {
            return Integer.parseInt(value);
        }
    }

    /**
     * Converts the corner radius into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the corner radius.
     */
    public static @NonNull String getValueFromCornerRadius(int value) {
        if (value == Theme.AUTO) {
            return Theme.Value.AUTO;
        } else {
            return String.valueOf(DynamicUnitUtils.convertPixelsToDp(value));
        }
    }

    /**
     * Converts the corner radius string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the corner radius.
     */
    public static int getValueFromCornerRadius(@NonNull String value) {
        if (Theme.Value.AUTO.equals(value) || Theme.Value.Short.AUTO.equals(value)) {
            return Theme.AUTO;
        } else {
            return Integer.parseInt(value);
        }
    }

    /**
     * Converts the background aware into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the background aware.
     */
    public static @Theme.Value @NonNull String getValueFromBackgroundAware(
            @Theme.BackgroundAware int value) {
        switch (value) {
            case Theme.BackgroundAware.DISABLE:
                return Theme.Value.DISABLE;
            case Theme.BackgroundAware.ENABLE:
                return Theme.Value.ENABLE;
            case Theme.BackgroundAware.UNKNOWN:
            case Theme.BackgroundAware.AUTO:
            default:
                return Theme.Value.AUTO;
        }
    }

    /**
     * Converts the background aware string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the background aware.
     */
    public static @Theme.BackgroundAware int getValueFromBackgroundAware(
            @Theme.Value @NonNull String value) {
        switch (value) {
            case Theme.Value.DISABLE:
            case Theme.Value.Short.DISABLE:
                return Theme.BackgroundAware.DISABLE;
            case Theme.Value.ENABLE:
            case Theme.Value.Short.ENABLE:
                return Theme.BackgroundAware.ENABLE;
            case Theme.Value.AUTO:
            case Theme.Value.Short.AUTO:
            default:
                return Theme.BackgroundAware.AUTO;
        }
    }

    /**
     * Converts the contrast into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the contrast.
     */
    public static @Theme.Value @NonNull String getValueFromContrast(int value) {
        if (value == Theme.AUTO) {
            return Theme.Value.AUTO;
        } else {
            return Integer.toString(value);
        }
    }

    /**
     * Converts the contrast string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the contrast.
     */
    public static int getValueFromContrast(@NonNull String value) {
        if (Theme.Value.AUTO.equals(value) || Theme.Value.Short.AUTO.equals(value)) {
            return Theme.AUTO;
        } else {
            return Integer.parseInt(value);
        }
    }

    /**
     * Converts the opacity into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the opacity.
     */
    public static @Theme.Value @NonNull String getValueFromOpacity(int value) {
        if (value == Theme.AUTO) {
            return Theme.Value.AUTO;
        } else {
            return Integer.toString(value);
        }
    }

    /**
     * Converts the opacity string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the opacity.
     */
    public static int getValueFromOpacity(@NonNull String value) {
        if (Theme.Value.AUTO.equals(value) || Theme.Value.Short.AUTO.equals(value)) {
            return Theme.AUTO;
        } else {
            return Integer.parseInt(value);
        }
    }

    /**
     * Converts the style into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the style.
     */
    public static @Theme.Value @NonNull String getValueFromStyle(@Theme.Style int value) {
        switch (value) {
            case Theme.Style.CUSTOM:
                return Theme.Value.CUSTOM;
            case Theme.Style.AUTO:
            default:
                return Theme.Value.AUTO;
        }
    }

    /**
     * Converts the style string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the style.
     */
    public static @Theme.Style int getValueFromStyle(@Theme.Value @NonNull String value) {
        switch (value) {
            case Theme.Value.CUSTOM:
            case Theme.Value.Short.CUSTOM:
                return Theme.Style.CUSTOM;
            case Theme.Value.AUTO:
            case Theme.Value.Short.AUTO:
            default:
                return Theme.Style.AUTO;
        }
    }

    /**
     * Converts the type into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the type.
     */
    public static @Theme.Value @NonNull String getValueFromType(@Theme int value) {
        switch (value) {
            case Theme.APP:
                return Theme.Value.APP;
            case Theme.DAY:
                return Theme.Value.DAY;
            case Theme.NIGHT:
                return Theme.Value.NIGHT;
            case Theme.CUSTOM:
                return Theme.Value.CUSTOM;
            case Theme.AUTO:
            case Theme.WIDGET:
            case Theme.REMOTE:
            default:
                return Theme.Value.AUTO;
        }
    }

    /**
     * Converts the type string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the type.
     */
    public static @Theme int getValueFromType(@Theme.ToString @NonNull String value) {
        switch (value) {
            case Theme.Value.APP:
            case Theme.Value.Short.APP:
                return Theme.APP;
            case Theme.Value.DAY:
            case Theme.Value.Short.DAY:
                return Theme.DAY;
            case Theme.Value.NIGHT:
            case Theme.Value.Short.NIGHT:
                return Theme.NIGHT;
            case Theme.Value.CUSTOM:
            case Theme.Value.Short.CUSTOM:
                return Theme.CUSTOM;
            case Theme.Value.AUTO:
            case Theme.Value.Short.AUTO:
            default:
                return Theme.AUTO;
        }
    }

    /**
     * Converts the visibility into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the visibility.
     */
    public static @NonNull String getValueFromVisibility(@Theme.Visibility int value) {
        switch (value) {
            case Theme.Visibility.HIDE:
                return Theme.Value.HIDE;
            case Theme.Visibility.SHOW:
                return Theme.Value.SHOW;
            case Theme.Visibility.AUTO:
            default:
                return Theme.Value.AUTO;
        }
    }

    /**
     * Converts the visibility string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the visibility.
     */
    public static @Theme.Visibility int getValueFromVisibility(@NonNull String value) {
        switch (value) {
            case Theme.Value.HIDE:
            case Theme.Value.Short.HIDE:
                return Theme.Visibility.HIDE;
            case Theme.Value.SHOW:
            case Theme.Value.Short.SHOW:
                return Theme.Visibility.SHOW;
            case Theme.Value.AUTO:
            case Theme.Value.Short.AUTO:
            default:
                return Theme.Visibility.AUTO;
        }
    }

    /**
     * Formats the theme string and remove extra double quotes and white spaces.
     *
     * @param string The theme string to be formatted.
     *
     * @return The formatted theme string.
     */
    public static @NonNull String formatTheme(@NonNull String string) {
        try {
            String[] query = string.trim().split(Theme.QUERY);
            String theme = query.length > 1 && !TextUtils.isEmpty(query[1])
                    ? decodeTheme(query[1]) : string.trim();

            if (theme == null) {
                theme = string.trim();
            }

            return theme.replaceAll(PATTERN_LINE, "")
                    .replaceAll(PATTERN_SPACE, "")
                    .replaceAll(PATTERN_QUOTES, "\"");
        } catch (Exception ignored) {
        }

        return string;
    }

    /**
     * Checks whether the string is a valid JSON.
     *
     * @param string The string to be checked.
     *
     * @return {@code true} if the supplied string is a valid JSON.
     */
    public static boolean isValidTheme(@Nullable String string) {
        boolean validTheme = false;

        try {
            if (string != null) {
                new JSONObject(formatTheme(string));
                validTheme = true;
            }
        } catch (Exception e) {
            try {
                validTheme = string.toLowerCase(Locale.ROOT).contains(Theme.URL);
            } catch (Exception ignored) {
            }
        }

        return validTheme;
    }

    /**
     * Checks whether the intent is valid for the theme.
     *
     * @param context The context to match the uri mime type.
     * @param intent The intent to get the data.
     *
     * @return {@code true} if the intent is valid for the theme.
     */
    public static boolean isValidThemeIntent(@Nullable Context context, @Nullable Intent intent) {
        if (intent == null) {
            return false;
        }

        if (Intent.ACTION_SEND.equals(intent.getAction())) {
            String theme = intent.getStringExtra(Intent.EXTRA_TEXT);

            return DynamicFileUtils.isValidMimeType(context,
                    (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM),
                    Theme.MIME, Theme.EXTENSION)
                    || DynamicFileUtils.isValidMimeType(context,
                    (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM),
                    Theme.MIME_IMAGE_MATCH, Theme.EXTENSION)
                    || (theme != null && theme.contains(Theme.QUERY)
                    && (theme.contains(Theme.HOST) || theme.contains(Theme.SCHEME_CUSTOM)));
        } else {
            String data = intent.getData() != null ? intent.getData().toString() : null;

            return DynamicFileUtils.isValidMimeType(context,
                    intent, Theme.MIME, Theme.EXTENSION)
                    || DynamicFileUtils.isValidMimeType(context,
                    intent, Theme.MIME_IMAGE_MATCH, Theme.EXTENSION)
                    || (data != null && data.contains(Theme.QUERY)
                    && (data.contains(Theme.HOST) || data.contains(Theme.SCHEME_CUSTOM)));
        }
    }

    /**
     * Encodes a dynamic theme.
     *
     * @param theme The theme to be encoded.
     *
     * @return The encoded theme string.
     */
    public static @Nullable String encodeTheme(@Nullable StringTheme<?> theme) {
        if (theme == null) {
            return null;
        }

        String string = null;

        try {
            string = formatTheme(theme.toDynamicString());
            Map<String, String> map = getThemeMap();

            for (Map.Entry<String, String> element : map.entrySet()) {
                string = string.replaceAll(element.getKey(), element.getValue());
            }

            string = Uri.encode(string);
        } catch (Exception ignored) {
        }

        return string;
    }

    /**
     * Decodes a theme string.
     *
     * @param theme The theme string to be decoded.
     *
     * @return The decoded theme string.
     */
    public static @Nullable String decodeTheme(@Nullable String theme) {
        if (TextUtils.isEmpty(theme)) {
            return null;
        }

        String decodedTheme = null;

        try {
            decodedTheme = Uri.decode(theme);
            Map<String, String> map = new LinkedHashMap<>();

            for (String pair : decodedTheme.split(Theme.Key.Short.SPLIT)) {
                String[] keyValue = pair.split(Theme.Value.Short.SPLIT);
                if (keyValue.length > 1 && !TextUtils.isEmpty(keyValue[1])) {
                    map.put(keyValue[0], keyValue[1]);
                }
            }

            decodedTheme = new JSONObject(map).toString();
        } catch (Exception ignored) {
        }

        return decodedTheme;
    }

    /**
     * Returns the encoded theme string with the url.
     *
     * @param theme The theme to be processed.
     *
     * @return The encoded theme string with the url.
     */
    public static @NonNull String getThemeUrl(@Nullable StringTheme<?> theme) {
        return Theme.URL + encodeTheme(theme);
    }

    /**
     * Returns the theme uri from the intent.
     *
     * @param intent The intent to get the theme uri.
     *
     * @return The theme uri according to the intent data.
     *
     * @see Intent#EXTRA_TEXT
     * @see Intent#EXTRA_STREAM
     * @see Intent#getData()
     */
    public static @Nullable Uri getThemeUri(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }

        try {
            if (Intent.ACTION_SEND.equals(intent.getAction())
                    && intent.getStringExtra(Intent.EXTRA_TEXT) != null
                    && isValidTheme(intent.getStringExtra(Intent.EXTRA_TEXT))) {
                return Uri.parse(intent.getStringExtra(Intent.EXTRA_TEXT));
            } else {
                return DynamicIntentUtils.getStreamOrData(intent, Intent.ACTION_SEND);
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns the theme data from the uri.
     *
     * @param context The context to retrieve the resources.
     * @param uri The uri to get the theme data.
     *
     * @return The theme data according to the uri.
     *
     * @see #getThemeUri(Intent)
     */
    public static @Nullable String getThemeData(@Nullable Context context, @Nullable Uri uri) {
        if (context == null || uri == null) {
            return null;
        }

        String data = null;

        try {
            if (uri.getQueryParameterNames().contains(Theme.PARAMETER)) {
                data = DynamicThemeUtils.decodeTheme(uri.getQueryParameter(Theme.PARAMETER));
            } else if (DynamicFileUtils.isValidMimeType(context, uri,
                    Theme.MIME_IMAGE_MATCH, Theme.EXTENSION_IMAGE)) {
                data = scanThemeCode(DynamicBitmapUtils.getBitmap(context, uri));
            } else {
                data = DynamicFileUtils.readStringFromFile(context, uri);
            }
        } catch (Exception ignored) {
        }

        return data;
    }

    /**
     * Returns the theme data from the intent.
     *
     * @param context The context to retrieve the resources.
     * @param intent The intent to get the theme data.
     *
     * @return The theme data according to the intent data.
     *
     * @see #getThemeUri(Intent)
     */
    public static @Nullable String getThemeData(
            @Nullable Context context, @Nullable Intent intent) {
        return getThemeData(context, getThemeUri(intent));
    }

    /**
     * Returns the theme name from the intent.
     *
     * @param context The context to retrieve the resources.
     * @param intent The intent to get the theme name.
     * @param defaultName The default name for the theme.
     *
     * @return The theme name according to the intent data.
     *
     * @see #getThemeUri(Intent)
     */
    public static @Nullable String getThemeName(@Nullable Context context,
            @Nullable Intent intent, @Nullable String defaultName) {
        if (context == null || intent == null) {
            return null;
        }

        String name = null;

        try {
            Uri uri = getThemeUri(intent);

            if (uri != null) {
                if (uri.getQueryParameterNames().contains(Theme.PARAMETER)) {
                    name = defaultName;
                } else {
                    name = DynamicFileUtils.getFileNameFromUri(context, uri);
                }
            }
        } catch (Exception ignored) {
        }

        return name;
    }

    /**
     * Request to return a dynamic theme file.
     *
     * @param context The context to get the app storage.
     * @param theme The name for the theme file.
     * @param data The text content for the theme file.
     *
     * @return The dynamic theme file containing the supplied data.
     */
    public static @Nullable File requestThemeFile(@NonNull Context context,
            @NonNull String theme, @NonNull String data) {
        File themeFile = null;

        try {
            String themeName = File.separator + theme + Theme.EXTENSION;
            themeFile = new File(DynamicFileUtils.getTempDir(context) + themeName);

            DynamicFileUtils.verifyFile(themeFile.getParentFile());
            DynamicFileUtils.writeStringToFile(context, data,
                    DynamicFileUtils.getUriFromFile(context, themeFile));
        } catch (Exception ignored) {
        }

        return themeFile;
    }

    /**
     * Creates a bitmap to be shared along with the dynamic theme.
     *
     * @param view The theme preview to get the bitmap.
     *
     * @return The bitmap to be shared along with the dynamic theme.
     */
    public static @Nullable Bitmap createThemeBitmap(@NonNull View view) {
        return DynamicBitmapUtils.createBitmap(view, Theme.PREVIEW_WIDTH, Theme.PREVIEW_HEIGHT);
    }

    /**
     * Creates a bitmap to be shared along with the remote dynamic theme.
     *
     * @param view The remote theme preview to get the bitmap.
     *
     * @return The bitmap to be shared along with the remote dynamic theme.
     */
    public static @Nullable Bitmap createRemoteThemeBitmap(@NonNull View view) {
        return DynamicBitmapUtils.createBitmap(view,
                Theme.PREVIEW_WIDTH, Theme.PREVIEW_HEIGHT_REMOTE);
    }

    /**
     * Generates a QR code from the dynamic theme.
     *
     * @param theme The theme to generate the QR code.
     * @param overlay The optional QR code overlay.
     *
     * @return The generated QR code from the dynamic theme.
     */
    public static @Nullable Bitmap generateThemeCode(
            @Nullable CodeTheme<?> theme, @Nullable Drawable overlay) {
        if (theme == null) {
            return null;
        }

        Bitmap bitmap = null;
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, Theme.CHARACTER_SET);

        final @ColorInt int backgroundColor;
        final @ColorInt int dataColor;
        final @ColorInt int overlayColor;
        final @ColorInt int finderExternalColor;
        final @ColorInt int finderInternalColor;
        final @Theme.Code.Style int style = theme.getCodeStyle();

        if (theme instanceof BackgroundTheme) {
            backgroundColor = DynamicColorUtils.removeAlpha(
                    ((BackgroundTheme<?>) theme).getBackgroundColor());
            dataColor = DynamicColorUtils.removeAlpha(DynamicColorUtils
                    .getContrastColor(((BackgroundTheme<?>) theme).getTintBackgroundColor(),
                            backgroundColor, theme.getCodeContrastRatio()));
        } else {
            backgroundColor = Theme.Code.Color.BACKGROUND;
            dataColor = Theme.Code.Color.DATA;
        }

        if (theme instanceof AccentTheme) {
            overlayColor = DynamicColorUtils.removeAlpha(DynamicColorUtils
                    .getContrastColor(((AccentTheme<?>) theme).getAccentColor(),
                            backgroundColor, theme.getCodeContrastRatio()));
        } else {
            overlayColor = dataColor;
        }

        finderExternalColor = dataColor;
        if (theme instanceof PrimaryTheme) {
            finderInternalColor = DynamicColorUtils.removeAlpha(DynamicColorUtils
                    .getContrastColor(((PrimaryTheme<?>) theme).getPrimaryColor(),
                            backgroundColor, theme.getCodeContrastRatio()));
        } else {
            finderInternalColor = finderExternalColor;
        }

        try {
            ByteMatrix byteMatrix = Encoder.encode(theme.getCodeData(),
                    ErrorCorrectionLevel.L, hints).getMatrix();
            int quietZone = Theme.Code.QUIET_ZONE;
            int inputWidth = byteMatrix.getWidth();
            int inputHeight = byteMatrix.getHeight();
            int inputCenterX = inputWidth / 2;
            int inputCenterY = inputHeight / 2;
            int qrWidth = inputWidth + (quietZone * 2);
            int qrHeight = inputHeight + (quietZone * 2);
            int outputWidth = Math.max(Theme.Code.SIZE, qrWidth);
            int outputHeight = Math.max(Theme.Code.SIZE, qrHeight);
            int outputCenterX = outputWidth / 2;
            int outputCenterY = outputHeight / 2;

            bitmap = Bitmap.createBitmap(outputWidth, outputHeight, Bitmap.Config.ARGB_8888);
            final Canvas canvas = new Canvas(bitmap);
            final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setStrokeCap(style == Theme.Code.Style.OVAL
                    ? Paint.Cap.ROUND : style == Theme.Code.Style.ROUND
                    ? Paint.Cap.BUTT : Paint.Cap.SQUARE);
            paint.setColor(backgroundColor);
            canvas.drawPaint(paint);

            int multiple = Math.min(outputWidth / qrWidth, outputHeight / qrHeight);
            int leftPadding = (outputWidth - (inputWidth * multiple)) / 2;
            int topPadding = (outputHeight - (inputHeight * multiple)) / 2;

            final int FINDER_SIZE = 7;
            final float SCALE_DOWN_FACTOR = style == Theme.Code.Style.ROUND
                    || style == Theme.Code.Style.OVAL ? 21f / 30f : 31f / 32f;
            final int OVERLAY_SIZE = overlay != null ? Theme.Code.OVERLAY_SIZE : 0;
            final int OVERLAY_SIZE_CENTER = OVERLAY_SIZE / 2;

            int dataSize = (int) (multiple * SCALE_DOWN_FACTOR);
            int dataRadius = dataSize / 2;
            int finderDiameter = multiple * FINDER_SIZE;
            int overlaySize = multiple * OVERLAY_SIZE;
            final float corner;

            if (theme instanceof CornerTheme) {
                corner = ((CornerTheme<?>) theme).getCornerSizeDp(false)
                        == Theme.AUTO ? Theme.Code.Style.DEFAULT : Math.min(((CornerTheme<?>)
                        theme).getCornerRadius(), finderDiameter / 2);
            } else {
                corner = Theme.Code.Style.DEFAULT;
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
                                canvas.drawCircle(outputX, outputY, dataRadius, paint);
                            } else {
                                canvas.drawRect(new Rect(outputX, outputY, outputX + dataSize,
                                        outputY + dataSize), paint);
                            }
                        }
                    }
                }
            }

            drawCodeFinder(canvas, leftPadding, topPadding, finderDiameter, paint,
                    backgroundColor, finderExternalColor, finderInternalColor, corner, style);
            drawCodeFinder(canvas, leftPadding + (inputWidth - FINDER_SIZE) * multiple,
                    topPadding, finderDiameter, paint, backgroundColor, finderExternalColor,
                    finderInternalColor, corner, style);
            drawCodeFinder(canvas, leftPadding, topPadding + (inputHeight - FINDER_SIZE)
                            * multiple, finderDiameter, paint, backgroundColor,
                    finderExternalColor, finderInternalColor, corner, style);

            if (overlay != null) {
                Bitmap overlayBitmap = DynamicBitmapUtils.getBitmap(overlay,
                        overlaySize, overlaySize, false, 0);

                if (overlayBitmap != null) {
                    paint.setColorFilter(new PorterDuffColorFilter(
                            overlayColor, PorterDuff.Mode.SRC_ATOP));
                    canvas.drawBitmap(overlayBitmap, outputCenterX - overlaySize / 2f,
                            outputCenterY - overlaySize / 2f, paint);
                }
            }
        } catch (Exception ignored) {
        }

        return bitmap;
    }

    /**
     * Draws the finder for the QR code according to the supplied parameters.
     *
     * @param canvas The canvas to be used.
     * @param x The x-axis start location.
     * @param y The y-axis start location.
     * @param diameter The diameter to be used.
     * @param paint The paint ot be used.
     * @param background The background color to be set.
     * @param parent The parent color to be set.
     * @param child The child color to be set.
     * @param corner The corner radius to be set.
     * @param style The style to be used.
     */
    private static void drawCodeFinder(@Nullable Canvas canvas, int x,
            int y, int diameter, @Nullable Paint paint, @ColorInt int background,
            @ColorInt int parent, @ColorInt int child, float corner, @Theme.Code.Style int style) {
        if (canvas == null || paint == null) {
            return;
        }

        final int PARENT_SIZE = diameter * 5 / 7;
        final int PARENT_OFFSET = diameter / 7;
        final int CHILD_SIZE = diameter * 3 / 7;
        final int CHILD_OFFSET = diameter * 2 / 7;

        if (style == Theme.Code.Style.OVAL) {
            paint.setColor(parent);
            canvas.drawCircle(x + PARENT_OFFSET + CHILD_OFFSET,
                    y + PARENT_OFFSET + CHILD_OFFSET, diameter / 2f, paint);
            paint.setColor(background);
            canvas.drawCircle(x + PARENT_OFFSET + CHILD_OFFSET,
                    y + PARENT_OFFSET + CHILD_OFFSET, PARENT_SIZE / 2f, paint);
            paint.setColor(child);
            canvas.drawCircle(x + PARENT_OFFSET + CHILD_OFFSET,
                    y + PARENT_OFFSET + CHILD_OFFSET, CHILD_SIZE / 2f, paint);
        } else if (style == Theme.Code.Style.ROUND) {
            paint.setColor(parent);
            canvas.drawRoundRect(new RectF(x, y, x + diameter,
                    y + diameter), corner, corner, paint);
            paint.setColor(background);
            canvas.drawRoundRect(new RectF(x + PARENT_OFFSET, y + PARENT_OFFSET,
                    x + diameter - PARENT_OFFSET, y + diameter - PARENT_OFFSET),
                    corner, corner, paint);
            paint.setColor(child);
            canvas.drawRoundRect(new RectF(x + CHILD_OFFSET, y + CHILD_OFFSET,
                    x + diameter - CHILD_OFFSET, y + diameter - CHILD_OFFSET),
                    corner, corner, paint);
        } else {
            paint.setColor(parent);
            canvas.drawRect(new Rect(x, y, x + diameter, y + diameter), paint);
            paint.setColor(background);
            canvas.drawRect(x + PARENT_OFFSET, y + PARENT_OFFSET,
                    x + diameter - PARENT_OFFSET, y + diameter - PARENT_OFFSET, paint);
            paint.setColor(child);
            canvas.drawRect(x + CHILD_OFFSET, y + CHILD_OFFSET,
                    x + diameter - CHILD_OFFSET, y + diameter - CHILD_OFFSET, paint);
        }
    }

    /**
     * Scans the dynamic theme QR code.
     *
     * @param bitmap The bitmap to be scanned.
     *
     * @return The dynamic theme string from the QR code bitmap.
     */
    public static @Nullable String scanThemeCode(@Nullable Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }

        Bitmap resized = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        bitmap.recycle();

        String contents = null;
        int[] pixels = new int[resized.getWidth() * resized.getHeight()];
        resized.getPixels(pixels, 0, resized.getWidth(),
                0, 0, resized.getWidth(), resized.getHeight());

        LuminanceSource source = new RGBLuminanceSource(
                resized.getWidth(), resized.getHeight(), pixels);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new QRCodeReader();
        Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.CHARACTER_SET, Theme.CHARACTER_SET);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        hints.put(DecodeHintType.POSSIBLE_FORMATS, EnumSet.allOf(BarcodeFormat.class));

        try {
            contents = reader.decode(binaryBitmap, hints).getText();
        } catch (Exception again) {
            binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(source));

            try {
                contents = reader.decode(binaryBitmap, hints).getText();
            } catch (Exception tryAgain1) {
                source = new InvertedLuminanceSource(source);
                binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    contents = reader.decode(binaryBitmap, hints).getText();
                } catch (Exception tryOnceMore) {
                    binaryBitmap = new BinaryBitmap(new GlobalHistogramBinarizer(source));

                    try {
                        contents = reader.decode(binaryBitmap, hints).getText();
                    } catch (Exception ignore) {
                    }
                }
            }
        } finally {
            resized.recycle();
            reader.reset();
        }

        return contents;
    }

    /**
     * Broadcast the theme data to the supported apps.
     *
     * @param context The context to broadcast the theme.
     * @param theme The theme for the receiver.
     * @param value The theme value for the receiver.
     * @param data The theme data for the receiver.
     * @param considerSender {@code true} to consider the sender package if applicable.
     */
    public static void broadcastDynamicTheme(@NonNull Context context,
            @Nullable @Theme.ToString String theme, @Nullable @Theme.ToString String value,
            @Nullable String data, boolean considerSender) {
        List<ResolveInfo> receivers = context.getPackageManager()
                .queryBroadcastReceivers(new Intent(Theme.Intent.ACTION),
                        PackageManager.GET_META_DATA);

        for (ResolveInfo resolveInfo : receivers) {
            if (considerSender || !context.getPackageName()
                    .equals(resolveInfo.activityInfo.packageName)) {
                Intent intent = new Intent(Theme.Intent.ACTION);
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                intent.putExtra(Theme.Intent.EXTRA_THEME, theme);
                intent.putExtra(Theme.Intent.EXTRA_VALUE, value);
                intent.putExtra(Theme.Intent.EXTRA_DATA, data);
                intent.setPackage(resolveInfo.activityInfo.packageName);
                intent.setComponent(new ComponentName(
                        resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name));

                context.sendBroadcast(intent, ThemeContract.Permission.DYNAMIC_THEME);
            }
        }
    }

    /**
     * Broadcast the theme data to the supported apps.
     *
     * @param context The context to broadcast the theme.
     * @param theme The theme for the receiver.
     * @param value The theme value for the receiver.
     * @param data The theme data for the receiver.
     *
     * @see #broadcastDynamicTheme(Context, String, String, String, boolean)
     */
    public static void broadcastDynamicTheme(@NonNull Context context,
            @Nullable @Theme.ToString String theme,
            @Nullable @Theme.ToString String value, @Nullable String data) {
        broadcastDynamicTheme(context, theme, value, data, false);
    }
}
