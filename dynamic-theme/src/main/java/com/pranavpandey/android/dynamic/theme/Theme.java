/*
 * Copyright 2020 Pranav Pandey
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

package com.pranavpandey.android.dynamic.theme;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Constant values for the theme.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef(value = { Theme.APP, Theme.AUTO, Theme.CUSTOM,
        Theme.DISABLE, Theme.SYSTEM, Theme.DAY, Theme.NIGHT })
public @interface Theme {

    /**
     * Permissions for the dynamic theme.
     */
    @StringDef(value = { Permission.DYNAMIC_THEME, Permission.READ_THEME, Permission.WRITE_THEME })
    @interface Permission {

        /**
         * Permission to broadcast the dynamic theme events.
         */
        String DYNAMIC_THEME = "com.pranavpandey.theme.permission.DYNAMIC_THEME";

        /**
         * Permission to read the theme presets.
         */
        String READ_THEME = "com.pranavpandey.theme.permission.READ_THEME";

        /**
         * Permission to write the theme presets.
         */
        String WRITE_THEME = "com.pranavpandey.theme.permission.WRITE_THEME";
    }

    /**
     * String constant values for the dynamic theme intent.
     */
    @interface Intent {

        /**
         * Intent action constant for the dynamic theme.
         */
        String ACTION = "com.pranavpandey.theme.intent.action.DYNAMIC_THEME";

        /**
         * Intent extra key for the theme data.
         */
        String EXTRA_THEME = "adt_extra_theme";

        /**
         * Intent extra key for the theme value.
         */
        String EXTRA_VALUE = "adt_extra_value";

        /**
         * Intent extra key for the theme data.
         */
        String EXTRA_DATA = "adt_extra_data";
    }

    /**
     * Constant values for the dynamic theme.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { Dynamic.AUTO, Dynamic.VALUE, Dynamic.DATA, Dynamic.DISABLE })
    @interface Dynamic {

        /**
         * Constant for the auto dynamic theme.
         */
        int AUTO = Theme.AUTO;

        /**
         * Constant for the value dynamic theme.
         */
        int VALUE = 1;

        /**
         * Constant for the data dynamic theme.
         */
        int DATA = 2;

        /**
         * Constant to disable the dynamic theme.
         */
        int DISABLE = Theme.DISABLE;

        /**
         * String constant values for the dynamic theme.
         */
        @Retention(RetentionPolicy.SOURCE)
        @StringDef(value = { ToString.AUTO, ToString.VALUE, ToString.DATA, ToString.DISABLE })
        @interface ToString {

            /**
             * String constant for the auto dynamic theme.
             */
            String AUTO = Theme.ToString.AUTO;

            /**
             * String constant for the value dynamic theme.
             */
            String VALUE = "1";

            /**
             * String constant for the data dynamic theme.
             */
            String DATA = "2";

            /**
             * String constant to disable the dynamic theme.
             */
            String DISABLE = Theme.ToString.DISABLE;
        }
    }

    /**
     * Scheme for the theme.
     */
    String SCHEME = "pranavpandey";

    /**
     * Host for the theme.
     */
    String HOST = "theme.pranavpandey.com";

    /**
     * Query parameter for the URL.
     */
    String QUERY = "theme=";

    /**
     * Share path for the URL.
     */
    String PATH = "/share";

    /**
     * URL for the theme.
     */
    String URL = "theme.pranavpandey.com" + PATH + "?" + QUERY;

    /**
     * Query parameter for the theme.
     */
    String PARAMETER = "theme";

    /**
     * Mime type for the theme file.
     */
    String MIME = "application/vnd.dynamic.theme";

    /**
     * Extension for the theme file.
     */
    String EXTENSION = ".theme";

    /**
     * Default name for the theme file.
     */
    String NAME = "dynamic";

    /**
     * Constant value for the theme preview width.
     */
    int PREVIEW_WIDTH = 300;
    /**
     * Constant value for the theme preview height.
     */
    int PREVIEW_HEIGHT = 160;

    /**
     * Default theme resource id.
     */
    int DEFAULT_RES = -1;

    /**
     * Constant for the app theme.
     */
    int APP = -4;

    /**
     * Constant for the automatic theme.
     */
    int AUTO = -3;

    /**
     * Constant for the custom theme.
     */
    int CUSTOM = -2;

    /**
     * Constant to disable the theme.
     */
    int DISABLE = 0;

    /**
     * Constant for the system theme.
     */
    int SYSTEM = 1;

    /**
     * Constant for the day theme.
     */
    int DAY = 2;

    /**
     * Constant for the night theme.
     */
    int NIGHT = 3;

    /**
     * String constant values for the theme.
     */
    @Retention(RetentionPolicy.SOURCE)
    @StringDef(value = { ToString.APP, ToString.AUTO, ToString.CUSTOM,
            ToString.DISABLE, ToString.SYSTEM, ToString.DAY, ToString.NIGHT })
    @interface ToString {

        /**
         * String constant for the app theme.
         */
        String APP = "-4";

        /**
         * String constant for the automatic theme.
         */
        String AUTO = "-3";

        /**
         * String constant for the custom theme.
         */
        String CUSTOM = "-2";

        /**
         * String constant to disable the theme.
         */
        String DISABLE = "0";

        /**
         * String constant for the system theme.
         */
        String SYSTEM = "1";

        /**
         * String constant for the day theme.
         */
        String DAY = "2";

        /**
         * String constant for the night theme.
         */
        String NIGHT = "3";
    }

    /**
     * Constant values for the night theme.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { Night.AUTO, Night.CUSTOM, Night.SYSTEM, Night.BATTERY })
    public @interface Night {

        /**
         * Constant for the night theme according to the time.
         */
        int AUTO = Theme.AUTO;

        /**
         * Constant for the custom night theme implementation.
         */
        int CUSTOM = Theme.CUSTOM;

        /**
         * Constant for the night theme according to the system.
         */
        int SYSTEM = Theme.SYSTEM;

        /**
         * Constant for the night theme when battery saver is active.
         */
        int BATTERY = 2;

        @Retention(RetentionPolicy.SOURCE)
        @StringDef(value = { Night.ToString.AUTO, Night.ToString.CUSTOM,
                Night.ToString.SYSTEM, Night.ToString.BATTERY })
        @interface ToString {

            /**
             * String constant for the night theme according to the time.
             */
            String AUTO = Theme.ToString.AUTO;

            /**
             * String constant for the custom night theme implementation.
             */
            String CUSTOM = Theme.ToString.CUSTOM;

            /**
             * String constant for the night theme according to the system.
             */
            String SYSTEM = Theme.ToString.SYSTEM;

            /**
             * String constant for the night theme when battery saver is active.
             */
            String BATTERY = "2";
        }
    }

    /**
     * Constants for the theme keys.
     */
    @Retention(RetentionPolicy.SOURCE)
    @interface Key {

        /**
         * Regex pattern for the brackets.
         */
        String BRACKETS = "[{}]";

        /**
         * Constant for the double quote.
         */
        String QUOTE = "\"";

        /**
         * Constant to split the key.
         */
        String SPLIT = ",";

        /**
         * Serialized name for the dark suffix.
         */
        String DARK = "Dark";

        /**
         * Serialized name for the inverse suffix.
         */
        String INVERSE = "Inverse";

        /**
         * Constant name for sharing the theme.
         */
        String SHARE = "dynamic-theme";

        /**
         * Serialized name for the theme resource.
         */
        String RES = "themeRes";

        /**
         * Serialized name for the widget id.
         */
        String WIDGET_ID = "widgetId";

        /**
         * Serialized name for the background color.
         */
        String BACKGROUND = "backgroundColor";

        /**
         * Serialized name for the tint background color.
         */
        String TINT_BACKGROUND = "tintBackgroundColor";

        /**
         * Serialized name for the surface color.
         */
        String SURFACE = "surfaceColor";

        /**
         * Serialized name for the tint surface color.
         */
        String TINT_SURFACE = "tintSurfaceColor";

        /**
         * Serialized name for the primary color.
         */
        String PRIMARY = "primaryColor";

        /**
         * Serialized name for the tint primary color.
         */
        String TINT_PRIMARY = "tintPrimaryColor";

        /**
         * Serialized name for the primary color dark.
         */
        String PRIMARY_DARK = "primaryColorDark";

        /**
         * Serialized name for the tint primary color dark.
         */
        String TINT_PRIMARY_DARK = "tintPrimaryColorDark";

        /**
         * Serialized name for the accent color.
         */
        String ACCENT = "accentColor";

        /**
         * Serialized name for the tint accent color.
         */
        String TINT_ACCENT = "tintAccentColor";

        /**
         * Serialized name for the accent color dark.
         */
        String ACCENT_DARK = "accentColorDark";

        /**
         * Serialized name for the tint accent color dark.
         */
        String TINT_ACCENT_DARK = "tintAccentColorDark";

        /**
         * Serialized name for the text primary color.
         */
        String TEXT_PRIMARY = "textPrimaryColor";

        /**
         * Serialized name for the text primary color inverse.
         */
        String TEXT_PRIMARY_INVERSE = "textPrimaryColorInverse";

        /**
         * Serialized name for the text secondary color.
         */
        String TEXT_SECONDARY = "textSecondaryColor";

        /**
         * Serialized name for the text secondary color inverse.
         */
        String TEXT_SECONDARY_INVERSE = "textSecondaryColorInverse";

        /**
         * Serialized name for the font scale.
         */
        String FONT_SCALE = "fontScale";

        /**
         * Serialized name for the corner radius.
         */
        String CORNER_RADIUS = "cornerRadius";

        /**
         * Serialized name for the background aware.
         */
        String BACKGROUND_AWARE = "backgroundAware";

        /**
         * Serialized name for the header.
         */
        String HEADER = "header";

        /**
         * Serialized name for the opacity.
         */
        String OPACITY = "opacity";

        /**
         * Short constants for the theme keys.
         */
        @Retention(RetentionPolicy.SOURCE)
        @interface Short {

            /**
             * Short constant for the brackets.
             */
            String BRACKETS = "";

            /**
             * Short constant for the double quote.
             */
            String QUOTE = "";

            /**
             * Short constant to split the key.
             */
            String SPLIT = "-";

            /**
             * Short serialized name for the dark suffix.
             */
            String DARK = "Z";

            /**
             * Short serialized name for the inverse suffix.
             */
            String INVERSE = "Z";

            /**
             * Short serialized name for the background color.
             */
            String BACKGROUND = "0";

            /**
             * Short serialized name for the tint background color.
             */
            String TINT_BACKGROUND = "1";

            /**
             * Short serialized name for the surface color.
             */
            String SURFACE = "2";

            /**
             * Short serialized name for the tint surface color.
             */
            String TINT_SURFACE = "3";

            /**
             * Short serialized name for the primary color.
             */
            String PRIMARY = "4";

            /**
             * Short serialized name for the tint primary color.
             */
            String TINT_PRIMARY = "5";

            /**
             * Short serialized name for the primary color dark.
             */
            String PRIMARY_DARK = PRIMARY + DARK;

            /**
             * Short serialized name for the tint primary color dark.
             */
            String TINT_PRIMARY_DARK = "7";

            /**
             * Short serialized name for the accent color.
             */
            String ACCENT = "8";

            /**
             * Short serialized name for the tint accent color.
             */
            String TINT_ACCENT = "9";

            /**
             * Short serialized name for the accent color dark.
             */
            String ACCENT_DARK = ACCENT + DARK;

            /**
             * Short serialized name for the tint accent color dark.
             */
            String TINT_ACCENT_DARK = "11";

            /**
             * Short serialized name for the text primary color.
             */
            String TEXT_PRIMARY = "12";

            /**
             * Short serialized name for the text primary color inverse.
             */
            String TEXT_PRIMARY_INVERSE = TEXT_PRIMARY + INVERSE;

            /**
             * Short serialized name for the text secondary color.
             */
            String TEXT_SECONDARY = "14";

            /**
             * Short serialized name for the text secondary color inverse.
             */
            String TEXT_SECONDARY_INVERSE = TEXT_SECONDARY + INVERSE;

            /**
             * Short serialized name for the font scale.
             */
            String FONT_SCALE = "16";

            /**
             * Short serialized name for the corner radius.
             */
            String CORNER_RADIUS = "17";

            /**
             * Short serialized name for the background aware.
             */
            String BACKGROUND_AWARE = "18";

            /**
             * Short serialized name for the header.
             */
            String HEADER = "19";

            /**
             * Short serialized name for the opacity.
             */
            String OPACITY = "20";
        }
    }

    /**
     * Constants for the theme values.
     */
    @Retention(RetentionPolicy.SOURCE)
    @interface Value {

        /**
         * Constant to split the value.
         */
        String SPLIT = ":";

        /**
         * Constant for the hash value.
         */
        String HASH = "#";

        /**
         * Constant for the auto value.
         */
        String AUTO = "auto";

        /**
         * Constant for the disable value.
         */
        String DISABLE = "disable";

        /**
         * Constant for the enable value.
         */
        String ENABLE = "enable";

        /**
         * Constant for the hide value.
         */
        String HIDE = "hide";

        /**
         * Constant for the show value.
         */
        String SHOW = "show";

        /**
         * Short constants for the theme values.
         */
        @Retention(RetentionPolicy.SOURCE)
        @interface Short {

            /**
             * Short constant to split the value.
             */
            String SPLIT = "v";

            /**
             * Short constant for the hash value.
             */
            String HASH = "X";

            /**
             * Short constant for the auto value.
             */
            String AUTO = "A";

            /**
             * Short constant for the disable value.
             */
            String DISABLE = "D";

            /**
             * Short constant for the enable value.
             */
            String ENABLE = "E";

            /**
             * Short constant for the hide value.
             */
            String HIDE = "H";

            /**
             * Short constant for the show value.
             */
            String SHOW = "S";
        }
    }

    /**
     * Interface to hold the color type constant values according to the
     * {@link com.pranavpandey.android.dynamic.theme.R.attr#ads_colorType}.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { ColorType.NONE, ColorType.PRIMARY, ColorType.PRIMARY_DARK,
            ColorType.ACCENT, ColorType.ACCENT_DARK, ColorType.TINT_PRIMARY,
            ColorType.TINT_PRIMARY_DARK, ColorType.TINT_ACCENT, ColorType.TINT_ACCENT_DARK,
            ColorType.CUSTOM, ColorType.BACKGROUND, ColorType.TINT_BACKGROUND,
            ColorType.TEXT_PRIMARY, ColorType.TEXT_SECONDARY, ColorType.TEXT_PRIMARY_INVERSE,
            ColorType.TEXT_SECONDARY_INVERSE, ColorType.SURFACE, ColorType.TINT_SURFACE })
    @interface ColorType {

        /**
         * Constant for the unknown color.
         */
        int UNKNOWN = -2;

        /**
         * Constant for the no color.
         */
        int NONE = 0;

        /**
         * Constant for the primary color.
         */
        int PRIMARY = 1;

        /**
         * Constant for the dark primary color.
         */
        int PRIMARY_DARK = 2;

        /**
         * Constant for the accent color.
         */
        int ACCENT = 3;

        /**
         * Constant for the dark accent color.
         */
        int ACCENT_DARK = 4;

        /**
         * Constant for the tint primary color.
         */
        int TINT_PRIMARY = 5;

        /**
         * Constant for the tint dark primary color.
         */
        int TINT_PRIMARY_DARK = 6;

        /**
         * Constant for the tint accent color.
         */
        int TINT_ACCENT = 7;

        /**
         * Constant for the tint dark accent color.
         */
        int TINT_ACCENT_DARK = 8;

        /**
         * Constant for the custom color.
         */
        int CUSTOM = 9;

        /**
         * Constant for the background color.
         */
        int BACKGROUND = 10;

        /**
         * Constant for the tint background color.
         */
        int TINT_BACKGROUND = 11;

        /**
         * Constant for the text primary color.
         */
        int TEXT_PRIMARY = 12;

        /**
         * Constant for the text secondary color.
         */
        int TEXT_SECONDARY = 13;

        /**
         * Constant for the inverse text primary color.
         */
        int TEXT_PRIMARY_INVERSE = 14;

        /**
         * Constant for the inverse text secondary color.
         */
        int TEXT_SECONDARY_INVERSE = 15;

        /**
         * Constant for the surface color.
         */
        int SURFACE = 16;

        /**
         * Constant for the tint surface color.
         */
        int TINT_SURFACE = 17;
    }

    /**
     * Constant values for the visibility.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { Visibility.AUTO, Visibility.HIDE, Visibility.SHOW })
    @interface Visibility {

        /**
         * Constant for the automatic visibility.
         */
        int AUTO = Theme.AUTO;

        /**
         * Constant for the always hide visibility.
         */
        int HIDE = 0;

        /**
         * Constant for the always show visibility.
         */
        int SHOW = 1;

        /**
         * String constant values for the visibility.
         */
        @Retention(RetentionPolicy.SOURCE)
        @StringDef(value = { Theme.Visibility.ToString.AUTO,
                Theme.Visibility.ToString.HIDE, Theme.Visibility.ToString.SHOW })
        @interface ToString {

            /**
             * String constant for the automatic visibility.
             */
            String AUTO = Theme.ToString.AUTO;

            /**
             * String constant for the always hide visibility.
             */
            String HIDE = "0";

            /**
             * String constant for the always show visibility.
             */
            String SHOW = "1";
        }
    }

    /**
     * Constant values for the background aware functionality.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { BackgroundAware.AUTO, BackgroundAware.DISABLE, BackgroundAware.ENABLE })
    @interface BackgroundAware {

        /**
         * Constant for the automatic background aware.
         */
        int AUTO = Theme.AUTO;

        /**
         * Constant to disable the background aware.
         */
        int DISABLE = 0;

        /**
         * Constant to enable the background aware.
         */
        int ENABLE = 1;

        /**
         * String constant values for the background aware functionality.
         */
        @Retention(RetentionPolicy.SOURCE)
        @StringDef(value = { Theme.BackgroundAware.ToString.AUTO,
                Theme.BackgroundAware.ToString.DISABLE, Theme.BackgroundAware.ToString.ENABLE })
        @interface ToString {

            /**
             * String constant for the automatic background aware.
             */
            String AUTO = Theme.ToString.AUTO;

            /**
             * String constant to disable the background aware.
             */
            String DISABLE = "0";

            /**
             * String constant to enable the background aware.
             */
            String ENABLE = "1";
        }
    }
}