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
 * A {@link BaseTheme} to implement a type theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface PrimaryTheme<T extends PrimaryTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the primary color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The primary color used by this theme.
     */
    @ColorInt int getPrimaryColor(boolean resolve, boolean inverse);

    /**
     * Returns the primary color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The primary color used by this theme.
     */
    @ColorInt int getPrimaryColor(boolean resolve);

    /**
     * Returns the primary color used by this theme.
     *
     * @return The primary color used by this theme.
     */
    @ColorInt int getPrimaryColor();

    /**
     * Set the primary color used by this theme.
     *
     * @param primaryColor The primary color to be set.
     * @param generateTint {@code true} to automatically generate the tint color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTintPrimaryColor(int)
     */
    @NonNull T setPrimaryColor(@ColorInt int primaryColor, boolean generateTint);

    /**
     * Set the primary color used by this theme.
     * <p>It will automatically generate the tint color also.
     *
     * @param primaryColor The primary color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setPrimaryColor(int, boolean)
     * @see #setTintPrimaryColor(int)
     */
    @NonNull T setPrimaryColor(@ColorInt int primaryColor);

    /**
     * Returns the dark primary color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The dark primary color used by this theme.
     */
    @ColorInt int getPrimaryColorDark(boolean resolve, boolean inverse);

    /**
     * Returns the dark primary color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The dark primary color used by this theme.
     */
    @ColorInt int getPrimaryColorDark(boolean resolve);

    /**
     * Returns the dark primary color used by this theme.
     *
     * @return The dark primary color used by this theme.
     */
    @ColorInt int getPrimaryColorDark();

    /**
     * Set the dark primary color used by this theme.
     *
     * @param primaryColorDark The dark primary color to be set.
     * @param generateTint {@code true} to automatically generate the tint color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTintPrimaryColorDark(int)
     */
    @NonNull T setPrimaryColorDark(@ColorInt int primaryColorDark, boolean generateTint);

    /**
     * Set the dark primary color used by this theme.
     * <p>It will automatically generate the tint color also.
     *
     * @param primaryColorDark The dark primary color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setPrimaryColorDark(int, boolean)
     * @see #setTintPrimaryColorDark(int)
     */
    @NonNull T setPrimaryColorDark(@ColorInt int primaryColorDark);

    /**
     * Returns the primary tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The primary tint color used by this theme.
     */
    @ColorInt int getTintPrimaryColor(boolean resolve, boolean inverse);

    /**
     * Returns the primary tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The primary tint color used by this theme.
     */
    @ColorInt int getTintPrimaryColor(boolean resolve);

    /**
     * Returns the primary tint color used by this theme.
     *
     * @return The primary tint color used by this theme.
     */
    @ColorInt int getTintPrimaryColor();

    /**
     * Set the primary tint color used by this theme.
     *
     * @param tintPrimaryColor The primary tint color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTintPrimaryColor(@ColorInt int tintPrimaryColor);

    /**
     * Returns the dark primary tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The dark primary tint color used by this theme.
     */
    @ColorInt int getTintPrimaryColorDark(boolean resolve, boolean inverse);

    /**
     * Returns the dark primary tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The dark primary tint color used by this theme.
     */
    @ColorInt int getTintPrimaryColorDark(boolean resolve);

    /**
     * Returns the dark primary tint color used by this theme.
     *
     * @return The dark primary tint color used by this theme.
     */
    @ColorInt int getTintPrimaryColorDark();

    /**
     * Set the dark primary tint color used by this theme.
     *
     * @param tintPrimaryColorDark The dark primary tint color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTintPrimaryColorDark(@ColorInt int tintPrimaryColorDark);
}
