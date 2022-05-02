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

package com.pranavpandey.android.dynamic.theme.base;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

/**
 * A {@link BaseTheme} to implement the accent theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface AccentTheme<T extends AccentTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the accent color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The accent color used by this theme.
     */
    @ColorInt int getAccentColor(boolean resolve, boolean inverse);

    /**
     * Returns the accent color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The accent color used by this theme.
     */
    @ColorInt int getAccentColor(boolean resolve);

    /**
     * Returns the accent color used by this theme.
     *
     * @return The accent color used by this theme.
     */
    @ColorInt int getAccentColor();

    /**
     * Set the accent color used by this theme.
     *
     * @param accentColor The accent color to be set.
     * @param generateTint {@code true} to automatically generate the tint color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTintAccentColor(int)
     */
    @NonNull T setAccentColor(@ColorInt int accentColor, boolean generateTint);

    /**
     * Set the accent color used by this theme.
     * <p>It will automatically generate the tint color also.
     *
     * @param accentColor The accent color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setAccentColor(int, boolean)
     * @see #setTintAccentColor(int)
     */
    @NonNull T setAccentColor(@ColorInt int accentColor);

    /**
     * Returns the dark accent color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The dark accent color used by this theme.
     */
    @ColorInt int getAccentColorDark(boolean resolve, boolean inverse);

    /**
     * Returns the dark accent color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The dark accent color used by this theme.
     */
    @ColorInt int getAccentColorDark(boolean resolve);

    /**
     * Returns the dark accent color used by this theme.
     *
     * @return The dark accent color used by this theme.
     */
    @ColorInt int getAccentColorDark();

    /**
     * Set the dark accent color used by this theme.
     *
     * @param accentColorDark The dark accent color to be set.
     * @param generateTint {@code true} to automatically generate the tint color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTintAccentColorDark(int)
     */
    @NonNull T setAccentColorDark(@ColorInt int accentColorDark, boolean generateTint);

    /**
     * Set the dark accent color used by this theme.
     * <p>It will automatically generate the tint color also.
     *
     * @param accentColorDark The dark accent color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setAccentColorDark(int, boolean)
     * @see #setTintAccentColorDark(int)
     */
    @NonNull T setAccentColorDark(@ColorInt int accentColorDark);

    /**
     * Returns the accent tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The accent tint color used by this theme.
     */
    @ColorInt int getTintAccentColor(boolean resolve, boolean inverse);

    /**
     * Returns the accent tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The accent tint color used by this theme.
     */
    @ColorInt int getTintAccentColor(boolean resolve);

    /**
     * Returns the accent tint color used by this theme.
     *
     * @return The accent tint color used by this theme.
     */
    @ColorInt int getTintAccentColor();

    /**
     * Set the accent tint color used by this theme.
     *
     * @param tintAccentColor The accent tint color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTintAccentColor(@ColorInt int tintAccentColor);

    /**
     * Returns the dark accent tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The dark accent tint color used by this theme.
     */
    @ColorInt int getTintAccentColorDark(boolean resolve, boolean inverse);

    /**
     * Returns the dark accent tint color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The dark accent tint color used by this theme.
     */
    @ColorInt int getTintAccentColorDark(boolean resolve);

    /**
     * Returns the dark accent tint color used by this theme.
     *
     * @return The dark accent tint color used by this theme.
     */
    @ColorInt int getTintAccentColorDark();

    /**
     * Set the dark accent tint color used by this theme.
     *
     * @param tintAccentColorDark The dark accent tint color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTintAccentColorDark(@ColorInt int tintAccentColorDark);
}
