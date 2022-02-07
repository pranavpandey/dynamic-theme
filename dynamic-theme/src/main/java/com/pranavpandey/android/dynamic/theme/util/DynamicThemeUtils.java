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

package com.pranavpandey.android.dynamic.theme.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pranavpandey.android.dynamic.theme.Theme;
import com.pranavpandey.android.dynamic.theme.ThemeContract;
import com.pranavpandey.android.dynamic.theme.base.StringTheme;
import com.pranavpandey.android.dynamic.util.DynamicBitmapUtils;
import com.pranavpandey.android.dynamic.util.DynamicColorUtils;
import com.pranavpandey.android.dynamic.util.DynamicDeviceUtils;
import com.pranavpandey.android.dynamic.util.DynamicFileUtils;
import com.pranavpandey.android.dynamic.util.DynamicIntentUtils;
import com.pranavpandey.android.dynamic.util.DynamicUnitUtils;

import org.json.JSONObject;

import java.io.File;
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
        map.put(Theme.Key.ELEVATION, Theme.Key.Short.ELEVATION);
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
        } else {
            prefix = prefix + "-";
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
        return getFileName(Theme.Key.SHARE, extension);
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
     * Converts the elevation into its string equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The string equivalent of the elevation.
     */
    public static @Theme.Value @NonNull String getValueFromElevation(
            @Theme.Elevation int value) {
        switch (value) {
            case Theme.Elevation.DISABLE:
                return Theme.Value.DISABLE;
            case Theme.Elevation.ENABLE:
                return Theme.Value.ENABLE;
            case Theme.Elevation.UNKNOWN:
            case Theme.Elevation.AUTO:
            default:
                return Theme.Value.AUTO;
        }
    }

    /**
     * Converts the elevation string into its integer equivalent.
     *
     * @param value The value to be converted.
     *
     * @return The integer equivalent of the elevation.
     */
    public static @Theme.Elevation int getValueFromElevation(
            @Theme.Value @NonNull String value) {
        switch (value) {
            case Theme.Value.DISABLE:
            case Theme.Value.Short.DISABLE:
                return Theme.Elevation.DISABLE;
            case Theme.Value.ENABLE:
            case Theme.Value.Short.ENABLE:
                return Theme.Elevation.ENABLE;
            case Theme.Value.AUTO:
            case Theme.Value.Short.AUTO:
            default:
                return Theme.Elevation.AUTO;
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
    public static @NonNull String format(@NonNull String string) {
        try {
            String[] query = string.trim().split(Theme.QUERY);
            String theme = query.length > 1 && !TextUtils.isEmpty(query[1])
                    ? decodeTheme(query[1]) : string.trim();

            if (theme == null) {
                theme = string.trim();
            }

            return theme.replaceAll(DynamicCodeUtils.PATTERN_LINE_BREAK, "")
                    .replaceAll(DynamicCodeUtils.PATTERN_SPACE, "")
                    .replaceAll(DynamicCodeUtils.PATTERN_QUOTES, "\"");
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
                new JSONObject(format(string));
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
     * @param context The context to match the URI mime type.
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
            string = format(theme.toDynamicString());
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
     * Returns the encoded theme string with the URL.
     *
     * @param theme The theme to be processed.
     *
     * @return The encoded theme string with the URL.
     */
    public static @NonNull String getThemeUrl(@Nullable StringTheme<?> theme) {
        return Theme.URL + encodeTheme(theme);
    }

    /**
     * Returns the theme URI from the intent.
     *
     * @param intent The intent to get the theme URI.
     *
     * @return The theme URI according to the intent data.
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
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Returns the theme data from the URI.
     *
     * @param context The context to be used.
     * @param uri The URI to get the theme data.
     *
     * @return The theme data according to the URI.
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
                data = DynamicCodeUtils.getTheme(DynamicBitmapUtils.getBitmap(context, uri));
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
     * @param context The context to be used.
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
     * @param context The context to be used.
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
     * Broadcast the theme data to the supported apps.
     *
     * @param context The context to broadcast the theme.
     * @param theme The theme for the receiver.
     * @param value The theme value for the receiver.
     * @param data The theme data for the receiver.
     * @param considerSender {@code true} to consider the sender package if applicable.
     */
    public static void broadcastDynamicTheme(@Nullable Context context,
            @Nullable @Theme.ToString String theme, @Nullable @Theme.ToString String value,
            @Nullable String data, boolean considerSender) {
        if (context == null) {
            return;
        }

        List<ResolveInfo> receivers = context.getPackageManager()
                .queryBroadcastReceivers(new Intent(Theme.Intent.ACTION),
                        PackageManager.GET_META_DATA);

        for (ResolveInfo resolveInfo : receivers) {
            if (considerSender || !context.getPackageName()
                    .equals(resolveInfo.activityInfo.packageName)) {
                Intent intent = new Intent(Theme.Intent.ACTION);
                intent.putExtra(Theme.Intent.EXTRA_THEME, theme);
                intent.putExtra(Theme.Intent.EXTRA_VALUE, value);
                intent.putExtra(Theme.Intent.EXTRA_DATA, data);
                intent.setPackage(resolveInfo.activityInfo.packageName);
                intent.setComponent(new ComponentName(resolveInfo.activityInfo.packageName,
                        resolveInfo.activityInfo.name));

                context.sendBroadcast(intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES),
                        ThemeContract.Permission.DYNAMIC_THEME);
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
