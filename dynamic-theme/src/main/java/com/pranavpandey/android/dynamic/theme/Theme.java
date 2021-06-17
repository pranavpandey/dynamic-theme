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

package com.pranavpandey.android.dynamic.theme;

import androidx.annotation.IntDef;
import androidx.annotation.StringDef;

import com.google.zxing.common.CharacterSetECI;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Constant values for the theme.
 */
@Retention(RetentionPolicy.SOURCE)
@IntDef(value = { Theme.APP, Theme.AUTO, Theme.CUSTOM, Theme.DISABLE,
        Theme.SYSTEM, Theme.DAY, Theme.NIGHT, Theme.REMOTE })
public @interface Theme {

    /**
     * String constant values for the dynamic theme intent.
     */
    @Retention(RetentionPolicy.SOURCE)
    @StringDef(value = { Intent.ACTION, Intent.EXTRA_THEME,
            Intent.EXTRA_VALUE, Intent.EXTRA_DATA })
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
     * Constant values for the dynamic theme style.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { Style.AUTO, Style.CUSTOM })
    @interface Style {

        /**
         * Constant for the auto theme style.
         */
        int AUTO = Theme.AUTO;

        /**
         * Constant for the custom theme style.
         */
        int CUSTOM = Theme.CUSTOM;

        /**
         * String constant values for the dynamic theme style.
         */
        @Retention(RetentionPolicy.SOURCE)
        @StringDef(value = { ToString.AUTO, ToString.CUSTOM })
        @interface ToString {

            /**
             * String constant for the auto theme style.
             */
            String AUTO = Theme.ToString.AUTO;

            /**
             * String constant for the custom theme style.
             */
            String CUSTOM = Theme.ToString.CUSTOM;
        }
    }

    /**
     * Scheme for the theme.
     */
    String SCHEME = "https";

    /**
     * Custom scheme for the theme.
     */
    String SCHEME_CUSTOM = "pranavpandey";

    /**
     * Scheme separator for the theme.
     */
    String SCHEME_SEPARATOR = "://";

    /**
     * Host for the theme.
     */
    String HOST = "theme.pranavpandey.com";

    /**
     * Share path for the URL.
     */
    String PATH = "/share";

    /**
     * Query parameter for the URL.
     */
    String QUERY = "theme=";

    /**
     * Scheme separator for the theme.
     */
    String QUERY_SEPARATOR = "?";

    /**
     * URL for the theme.
     */
    String URL = SCHEME + SCHEME_SEPARATOR + HOST + PATH + QUERY_SEPARATOR + QUERY;

    /**
     * Query parameter for the theme.
     */
    String PARAMETER = "theme";

    /**
     * Character set for the theme content.
     */
    String CHARACTER_SET = CharacterSetECI.UTF8.name();

    /**
     * Mime type for the theme file.
     */
    String MIME = "application/vnd.dynamic.theme";

    /**
     * Mime type for the theme image file.
     */
    String MIME_IMAGE = "image/png";
    
    /**
     * Mime type matcher for the theme image file.
     */
    String MIME_IMAGE_MATCH = "image";

    /**
     * Extension for the theme file.
     */
    String EXTENSION = ".theme";

    /**
     * Extension for the theme image file.
     */
    String EXTENSION_IMAGE = ".png";

    /**
     * Default name for the theme file.
     */
    String NAME = "dynamic";

    /**
     * Constant value for the theme preview width in dips.
     */
    int PREVIEW_WIDTH = 300;

    /**
     * Constant value for the theme preview height in dips.
     */
    int PREVIEW_HEIGHT = 160;

    /**
     * Constant value for the remote heme preview height in dips.
     */
    int PREVIEW_HEIGHT_REMOTE = 120;

    /**
     * Constant value for the theme code size in pixels.
     */
    int CODE_SIZE = 480;

    /**
     * Constant value for the theme code margin in pixels.
     */
    int CODE_MARGIN = 0;

    /**
     * Constant value for the theme code visible contrast.
     */
    float CODE_CONTRAST = 0.4f;

    /**
     * Constant value for the theme code overlay size in pixels.
     */
    int OVERLAY_SIZE = 40;

    /**
     * Constant value for the QR ode overlay background size in pixels.
     */
    int OVERLAY_BACKGROUND_SIZE = 80;

    /**
     * Default theme resource id.
     */
    int DEFAULT_RES = -1;

    /**
     * Constant to open the theme.
     */
    int OPEN = -5;

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
     * Constant for the remote theme.
     */
    int REMOTE = 4;

    /**
     * String constant values for the theme.
     */
    @Retention(RetentionPolicy.SOURCE)
    @StringDef(value = { ToString.APP, ToString.AUTO, ToString.CUSTOM, ToString.DISABLE,
            ToString.SYSTEM, ToString.DAY, ToString.NIGHT, ToString.REMOTE })
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

        /**
         * String constant for the remote theme.
         */
        String REMOTE = "4";
    }

    /**
     * Constant values for the night theme.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { Night.AUTO, Night.CUSTOM, Night.SYSTEM, Night.BATTERY })
    @interface Night {

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

        /**
         * String constant values for the night theme.
         */
        @Retention(RetentionPolicy.SOURCE)
        @StringDef(value = { ToString.AUTO, ToString.CUSTOM, ToString.SYSTEM, ToString.BATTERY })
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
    @StringDef(value = { Key.BRACKETS, Key.QUOTE, Key.SPLIT, Key.DARK, Key.INVERSE,
            Key.SHARE, Key.RES, Key.WIDGET_ID, Key.BACKGROUND, Key.TINT_BACKGROUND,
            Key.SURFACE, Key.TINT_SURFACE, Key.PRIMARY, Key.TINT_PRIMARY,
            Key.PRIMARY_DARK, Key.TINT_PRIMARY_DARK, Key.ACCENT, Key.TINT_ACCENT,
            Key.ACCENT_DARK, Key.TINT_ACCENT_DARK, Key.ERROR, Key.TINT_ERROR,
            Key.TEXT_PRIMARY, Key.TEXT_PRIMARY_INVERSE, Key.TEXT_SECONDARY,
            Key.TEXT_SECONDARY_INVERSE, Key.FONT_SCALE, Key.CORNER_RADIUS,
            Key.BACKGROUND_AWARE, Key.STYLE, Key.HEADER, Key.OPACITY })
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
         * Serialized name for the error color.
         */
        String ERROR = "errorColor";

        /**
         * Serialized name for the tint error color.
         */
        String TINT_ERROR = "tintErrorColor";

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
         * Serialized name for the style.
         */
        String STYLE = "style";

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
        @StringDef(value = { Key.BRACKETS, Short.QUOTE, Short.SPLIT, Short.DARK,
                Short.INVERSE, Short.BACKGROUND, Short.TINT_BACKGROUND, Short.SURFACE,
                Short.TINT_SURFACE, Short.PRIMARY, Short.TINT_PRIMARY, Short.PRIMARY_DARK,
                Short.TINT_PRIMARY_DARK, Short.ACCENT, Short.TINT_ACCENT, Short.ACCENT_DARK,
                Short.TINT_ACCENT_DARK, Short.ERROR, Short.TINT_ERROR, Short.TEXT_PRIMARY,
                Short.TEXT_PRIMARY_INVERSE, Short.TEXT_SECONDARY, Short.TEXT_SECONDARY_INVERSE,
                Short.FONT_SCALE, Short.CORNER_RADIUS, Short.BACKGROUND_AWARE, Short.STYLE,
                Short.HEADER, Short.OPACITY })
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

            /**
             * Short serialized name for the error color.
             */
            String ERROR = "21";

            /**
             * Short serialized name for the tint error color.
             */
            String TINT_ERROR = "22";

            /**
             * Short serialized name for the style.
             */
            String STYLE = "23";
        }
    }

    /**
     * Constants for the theme values.
     */
    @Retention(RetentionPolicy.SOURCE)
    @StringDef(value = { Value.SPLIT, Value.HASH, Value.AUTO, Value.CUSTOM,
            Value.DISABLE, Value.ENABLE, Value.HIDE, Value.SHOW })
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
         * Constant for the custom value.
         */
        String CUSTOM = "custom";

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
        @StringDef(value = { Short.SPLIT, Short.HASH, Short.AUTO, Short.CUSTOM,
                Short.DISABLE, Short.ENABLE, Short.HIDE, Short.SHOW })
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
             * Short constant for the custom value.
             */
            String CUSTOM = "C";

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
     * Interface to hold the color constants.
     */
    @interface Color {

        /**
         * Constant for the unknown color.
         */
        int UNKNOWN = 0x1;
    }

    /**
     * Interface to hold the color type constant values according to the
     * {@link R.attr#adt_colorType}.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { ColorType.UNKNOWN, ColorType.NONE, ColorType.CUSTOM,
            ColorType.BACKGROUND, ColorType.TINT_BACKGROUND, ColorType.SURFACE,
            ColorType.TINT_SURFACE, ColorType.PRIMARY, ColorType.TINT_PRIMARY,
            ColorType.PRIMARY_DARK, ColorType.TINT_PRIMARY_DARK, ColorType.ACCENT,
            ColorType.TINT_ACCENT, ColorType.ACCENT_DARK, ColorType.TINT_ACCENT_DARK,
            ColorType.ERROR, ColorType.TINT_ERROR, ColorType.TEXT_PRIMARY,
            ColorType.TEXT_PRIMARY_INVERSE, ColorType.TEXT_SECONDARY,
            ColorType.TEXT_SECONDARY_INVERSE })
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

        /**
         * Constant for the error color.
         */
        int ERROR = 18;

        /**
         * Constant for the tint error color.
         */
        int TINT_ERROR = 19;
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
        @StringDef(value = { ToString.AUTO, ToString.HIDE, ToString.SHOW })
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
    @IntDef(value = { BackgroundAware.AUTO, BackgroundAware.UNKNOWN,
            BackgroundAware.DISABLE, BackgroundAware.ENABLE })
    @interface BackgroundAware {

        /**
         * Constant for the automatic background aware.
         */
        int AUTO = Theme.AUTO;

        /**
         * Constant for the unknown background aware.
         */
        int UNKNOWN = Theme.CUSTOM;

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
        @StringDef(value = { ToString.AUTO, ToString.UNKNOWN, ToString.DISABLE, ToString.ENABLE })
        @interface ToString {

            /**
             * String constant for the automatic background aware.
             */
            String AUTO = Theme.ToString.AUTO;

            /**
             * String constant for the unknown background aware.
             */
            String UNKNOWN = Theme.ToString.CUSTOM;

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

    /**
     * Theme actions to perform the operations accordingly.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = { Action.SELECT_ALL, Action.SELECT_APP, Action.SELECT, Action.INVALID,
            Action.APPLY, Action.COPY, Action.SHARE, Action.SHARE_DATA, Action.SHARE_FILE,
            Action.SHARE_CODE, Action.EDIT, Action.SAVE,  Action.SAVE_FILE, Action.SAVE_CODE,
            Action.IMPORT, Action.IMPORT_FILE, Action.DELETE })
    @interface Action {

        /**
         * Constant for the import theme selection action with all the themes including
         * remote theme.
         */
        int SELECT_ALL = -3;

        /**
         * Constant for the import theme selection action with all the themes.
         */
        int SELECT_APP = -2;

        /**
         * Constant for the import theme selection action with day and night themes.
         */
        int SELECT = -1;

        /**
         * Constant for the invalid theme action.
         */
        int INVALID = 0;

        /**
         * Constant for the apply theme action.
         */
        int APPLY = 1;

        /**
         * Constant for the copy theme action.
         */
        int COPY = 2;

        /**
         * Constant for the share theme action.
         */
        int SHARE = 3;

        /**
         * Constant for the share theme (only text) action.
         */
        int SHARE_DATA = 4;

        /**
         * Constant for the share theme (with file) action.
         */
        int SHARE_FILE = 5;

        /**
         * Constant for the share theme (with code) action.
         */
        int SHARE_CODE = 6;

        /**
         * Constant for the edit theme action.
         */
        int EDIT = 7;

        /**
         * Constant for the save theme action.
         */
        int SAVE = 8;

        /**
         * Constant for the save theme (file) action.
         */
        int SAVE_FILE = 9;

        /**
         * Constant for the save theme (code) action.
         */
        int SAVE_CODE = 10;

        /**
         * Constant for the import theme action.
         */
        int IMPORT = 11;

        /**
         * Constant for the import (from file) theme action.
         */
        int IMPORT_FILE = 12;

        /**
         * Constant for the delete theme action.
         */
        int DELETE = 13;
    }
}
