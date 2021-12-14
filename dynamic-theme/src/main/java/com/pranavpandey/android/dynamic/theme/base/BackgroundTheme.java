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
 * A {@link BaseTheme} to implement the background theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface BackgroundTheme<T extends BackgroundTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the background color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The background color used by this theme.
     */
    @ColorInt int getBackgroundColor(boolean resolve, boolean inverse);

    /**
     * Returns the background color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The background color used by this theme.
     */
    @ColorInt int getBackgroundColor(boolean resolve);

    /**
     * Returns the background color used by this theme.
     *
     * @return The background color used by this theme.
     */
    @ColorInt int getBackgroundColor();

    /**
     * Set the background color used by this theme.
     *
     * @param backgroundColor The background color to be set.
     * @param generateTint {@code true} to automatically generate the tint color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTintBackgroundColor(int)
     */
    @NonNull T setBackgroundColor(@ColorInt int backgroundColor, boolean generateTint);

    /**
     * Set the background color used by this theme.
     * <p>It will automatically generate the tint color also.
     *
     * @param backgroundColor The background color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setBackgroundColor(int, boolean)
     * @see #setTintBackgroundColor(int)
     */
    @NonNull T setBackgroundColor(@ColorInt int backgroundColor);

    /**
     * Returns the background tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The background tint color used by this theme.
     */
    @ColorInt int getTintBackgroundColor(boolean resolve, boolean inverse);

    /**
     * Returns the background tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The background tint color used by this theme.
     */
    @ColorInt int getTintBackgroundColor(boolean resolve);

    /**
     * Returns the background tint color used by this theme.
     *
     * @return The background tint color used by this theme.
     */
    @ColorInt int getTintBackgroundColor();

    /**
     * Set the background tint color used by this theme.
     *
     * @param tintBackgroundColor The background tint color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTintBackgroundColor(@ColorInt int tintBackgroundColor);

    /**
     * Returns {@code true} if this theme is dark.
     *
     * @return {@code true} if this theme is dark.
     */
    boolean isDarkTheme();

    /**
     * Checks whether this theme is applied in the inverse mode.
     *
     * @return {@code true} if this theme is applied in the inverse mode.
     */
    boolean isInverseTheme();

    /**
     * Returns whether to show the dividers for this theme.
     *
     * @return {@code true} to show the dividers for this theme.
     */
    boolean isShowDividers();
}
