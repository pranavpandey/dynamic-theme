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

package com.pranavpandey.android.dynamic.theme.base;

import androidx.annotation.NonNull;

import com.pranavpandey.android.dynamic.theme.Theme;

/**
 * A {@link BaseTheme} to implement the elevation theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface ElevationTheme<T extends ElevationTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the elevation functionality used by this theme.
     *
     * @param resolve {@code true} to resolve auto elevation.
     *
     * @return The elevation functionality used by this theme.
     */
    @Theme.Elevation int getElevation(boolean resolve);

    /**
     * Returns the elevation functionality used by this theme.
     *
     * @return The elevation functionality used by this theme.
     */
    @Theme.Elevation int getElevation();

    /**
     * Checks whether the elevation functionality is enabled.
     *
     * @return {@code true} if the elevation functionality is enabled.
     */
    boolean isElevation();

    /**
     * Set the elevation functionality used by this theme.
     *
     * @param elevation The elevation functionality to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setElevation(@Theme.Elevation int elevation);
}
