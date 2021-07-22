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

/**
 * A {@link BaseTheme} to implement a corner theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface CornerTheme<T extends CornerTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the corner size used by this theme in pixels.
     *
     * @param resolve {@code true} to resolve auto corner size.
     *
     * @return The corner size used by this theme in pixels.
     */
    int getCornerRadius(boolean resolve);

    /**
     * Returns the corner size used by this theme in pixels.
     *
     * @return The corner size used by this theme in pixels.
     */
    int getCornerRadius();

    /**
     * Returns the corner size used by this theme in dips.
     *
     * @param resolve {@code true} to resolve auto corner size in dips.
     *
     * @return The corner size used by this theme in dips.
     */
    int getCornerSizeDp(boolean resolve);

    /**
     * Returns the corner size used by this theme in dips.
     *
     * @return The corner size used by this theme in dips.
     */
    int getCornerSizeDp();

    /**
     * Set the corner size used by this theme.
     *
     * @param cornerRadius The corner size to be set in pixels.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setCornerRadius(int cornerRadius);

    /**
     * Set the corner size used by this theme.
     *
     * @param cornerSize The corner size to be set in dips.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setCornerRadiusDp(float cornerSize);
}
