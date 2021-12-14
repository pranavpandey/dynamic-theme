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
 * A {@link BaseTheme} to implement the error theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface ErrorTheme<T extends ErrorTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the error color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The error color used by this theme.
     */
    @ColorInt int getErrorColor(boolean resolve, boolean inverse);

    /**
     * Returns the error color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The error color used by this theme.
     */
    @ColorInt int getErrorColor(boolean resolve);

    /**
     * Returns the error color used by this theme.
     *
     * @return The error color used by this theme.
     */
    @ColorInt int getErrorColor();

    /**
     * Set the error color used by this theme.
     *
     * @param errorColor The error color to be set.
     * @param generateTint {@code true} to automatically generate the tint color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTintErrorColor(int)
     */
    @NonNull T setErrorColor(@ColorInt int errorColor, boolean generateTint);

    /**
     * Set the error color used by this theme.
     * <p>It will automatically generate the tint color also.
     *
     * @param errorColor The error color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setErrorColor(int, boolean)
     * @see #setTintErrorColor(int)
     */
    @NonNull T setErrorColor(@ColorInt int errorColor);

    /**
     * Returns the error tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The error tint color used by this theme.
     */
    @ColorInt int getTintErrorColor(boolean resolve, boolean inverse);

    /**
     * Returns the error tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The error tint color used by this theme.
     */
    @ColorInt int getTintErrorColor(boolean resolve);

    /**
     * Returns the error tint color used by this theme.
     *
     * @return The error tint color used by this theme.
     */
    @ColorInt int getTintErrorColor();

    /**
     * Set the error tint color used by this theme.
     *
     * @param tintErrorColor The error tint color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTintErrorColor(@ColorInt int tintErrorColor);
}
