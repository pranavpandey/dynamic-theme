/*
 * Copyright 2019 Pranav Pandey
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

import android.net.Uri;
import android.provider.BaseColumns;

import androidx.annotation.IntDef;

import static com.pranavpandey.android.dynamic.theme.ThemeContract.Preset.Type.CUSTOM;
import static com.pranavpandey.android.dynamic.theme.ThemeContract.Preset.Type.DEFAULT;

/**
 * Theme contract class to hold the database values.
 */
public class ThemeContract {

    /**
     * Interface to hold the content provider match codes.
     */
    @IntDef(value = { DEFAULT, CUSTOM })
    public static @interface Code {

        /**
         * Match code for some items in the Preset table.
         */
        int DIR = 1;

        /**
         * Match code for an item in the Preset table.
         */
        int ITEM = 2;
    }

    public @interface Preset {

        /**
         * Table name for the presets data.
         */
        String TABLE_NAME = "presets";

        /**
         * Package name for the theme manager app.
         */
        String AUTHORITY = "com.pranavpandey.theme";

        /**
         * Content provider uri for the presets table.
         */
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

        /**
         * Permissions required to read the presets.
         */
        String[] READ_PERMISSIONS = new String[] { Theme.Permission.READ_THEME };

        /**
         * Interface to hold the preset database columns.
         */
        @interface Column {

            /**
             * Column name for the preset id.
             */
            String _ID = BaseColumns._ID;

            /**
             * Column name for the preset theme string.
             */
            String THEME = "theme";

            /**
             * Column name for the preset parent theme string.
             */
            String PARENT = "parent";

            /**
             * Column name for the preset type.
             */
            String TYPE = "type";
        }

        /**
         * Interface to hold the theme preset type.
         */
        @IntDef(value = { DEFAULT, CUSTOM })
        @interface Type {

            /**
             * Constant for the default preset type.
             */
            int DEFAULT = 0;

            /**
             * Constant for the custom preset type.
             */
            int CUSTOM = 1;
        }
    }
}
