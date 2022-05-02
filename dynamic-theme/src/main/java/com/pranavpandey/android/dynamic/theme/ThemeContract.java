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

package com.pranavpandey.android.dynamic.theme;

import android.net.Uri;
import android.provider.BaseColumns;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Theme contract class to hold the database values.
 */
public class ThemeContract {

    /**
     * Permissions for the dynamic theme.
     */
    public @interface Permission {

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
     * Interface to hold the content provider match codes.
     */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Code {

        /**
         * Match code for some items in the Preset table.
         */
        int DIR = 1;

        /**
         * Match code for an item in the Preset table.
         */
        int ITEM = 2;
    }

    /**
     * Interface to hold the preset constants.
     */
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
         * Content provider URI for the presets table.
         */
        Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

        /**
         * Permissions required to read the presets.
         */
        String[] READ_PERMISSIONS = new String[] { Permission.READ_THEME };

        /**
         * Permissions required to receive the presets.
         */
        String[] RECEIVER_PERMISSIONS = new String[] { Permission.DYNAMIC_THEME };

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
        @Retention(RetentionPolicy.SOURCE)
        @interface Type {

            /**
             * Constant for the no preset type.
             */
            int ALL = -1;

            /**
             * Constant for the default preset type.
             */
            int DEFAULT = 0;

            /**
             * Constant for the custom preset type.
             */
            int CUSTOM = 1;

            /**
             * Constant for the minimum presets count.
             */
            int COUNT_MIN = -1;

            /**
             * Constant for the maximum presets count.
             */
            int COUNT_MAX = 500;

            /**
             * Constant for the default presets count.
             */
            int COUNT_DEFAULT = 100;

            /**
             * String constant values for the theme presets.
             */
            @Retention(RetentionPolicy.SOURCE)
            @interface ToString {

                /**
                 * String constant for the no preset type.
                 */
                String ALL = "-1";

                /**
                 * String constant for the default preset type.
                 */
                String DEFAULT = "0";

                /**
                 * String constant for the custom preset type.
                 */
                String CUSTOM = "1";
            }
        }
    }
}
