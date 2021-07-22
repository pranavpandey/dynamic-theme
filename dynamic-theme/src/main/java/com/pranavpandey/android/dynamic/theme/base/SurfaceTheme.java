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

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/**
 * A {@link BaseTheme} to implement a surface theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface SurfaceTheme<T extends SurfaceTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the surface color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The surface color used by this theme.
     */
    @ColorInt int getSurfaceColor(boolean resolve, boolean inverse);

    /**
     * Returns the surface color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The surface color used by this theme.
     */
    @ColorInt int getSurfaceColor(boolean resolve);

    /**
     * Returns the surface color used by this theme.
     *
     * @return The surface color used by this theme.
     */
    @ColorInt int getSurfaceColor();

    /**
     * Set the surface color used by this theme.
     *
     * @param surfaceColor The surface color to be set.
     * @param generateTint {@code true} to automatically generate the tint color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTintSurfaceColor(int)
     */
    @NonNull T setSurfaceColor(@ColorInt int surfaceColor, boolean generateTint);

    /**
     * Set the surface color used by this theme.
     * <p>It will automatically generate the tint color also.
     *
     * @param surfaceColor The surface color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setSurfaceColor(int, boolean)
     * @see #setTintSurfaceColor(int)
     */
    @NonNull T setSurfaceColor(@ColorInt int surfaceColor);

    /**
     * Returns the surface tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The surface tint color used by this theme.
     */
    @ColorInt int getTintSurfaceColor(boolean resolve, boolean inverse);

    /**
     * Returns the surface tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The surface tint color used by this theme.
     */
    @ColorInt int getTintSurfaceColor(boolean resolve);

    /**
     * Returns the surface tint color used by this theme.
     *
     * @return The surface tint color used by this theme.
     */
    @ColorInt int getTintSurfaceColor();

    /**
     * Set the surface tint color used by this theme.
     *
     * @param tintSurfaceColor The surface tint color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTintSurfaceColor(@ColorInt int tintSurfaceColor);

    /**
     * Checks whether the background should be used as the surface.
     *
     * @return {@code true} if the background should be used as surface.
     */
    boolean isBackgroundSurface();
}
