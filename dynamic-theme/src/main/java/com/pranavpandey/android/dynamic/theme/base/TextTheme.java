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
 * A {@link BaseTheme} to implement the text theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface TextTheme<T extends TextTheme<T>> extends BaseTheme<T> {

    /**
     * Returns the primary text color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The primary text color used by this theme.
     */
    @ColorInt int getTextPrimaryColor(boolean resolve, boolean inverse);

    /**
     * Returns the primary text color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The primary text color used by this theme.
     */
    @ColorInt int getTextPrimaryColor(boolean resolve);

    /**
     * Returns the primary text color used by this theme.
     *
     * @return The primary text color used by this theme.
     */
    @ColorInt int getTextPrimaryColor();

    /**
     * Set the primary text color used by this theme.
     *
     * @param textPrimaryColor The primary text color to be set.
     * @param generateInverse {@code true} to automatically generate the inverse color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTextPrimaryColorInverse(int)
     */
    @NonNull T setTextPrimaryColor(@ColorInt int textPrimaryColor, boolean generateInverse);

    /**
     * Set the primary text color used by this theme.
     * <p>It will automatically generate the inverse color also.
     *
     * @param textPrimaryColor The primary text color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTextPrimaryColor(int, boolean)
     * @see #setTextPrimaryColorInverse(int)
     */
    @NonNull T setTextPrimaryColor(@ColorInt int textPrimaryColor);

    /**
     * Returns the secondary text color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The secondary text color used by this theme.
     */
    @ColorInt int getTextSecondaryColor(boolean resolve, boolean inverse);

    /**
     * Returns the secondary text color used by this theme.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The secondary text color used by this theme.
     */
    @ColorInt int getTextSecondaryColor(boolean resolve);

    /**
     * Returns the secondary text color used by this theme.
     *
     * @return The secondary text color used by this theme.
     */
    @ColorInt int getTextSecondaryColor();

    /**
     * Set the secondary text color used by this theme.
     *
     * @param textSecondaryColor The secondary text color to be set.
     * @param generateInverse {@code true} to automatically generate the inverse color also.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTextSecondaryColorInverse(int)
     */
    @NonNull T setTextSecondaryColor(@ColorInt int textSecondaryColor, boolean generateInverse);

    /**
     * Set the secondary text color used by this theme.
     * <p>It will automatically generate the inverse color also.
     *
     * @param textSecondaryColor The secondary text color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #setTextSecondaryColor(int, boolean)
     * @see #setTextSecondaryColorInverse(int)
     */
    @NonNull T setTextSecondaryColor(@ColorInt int textSecondaryColor);

    /**
     * Returns the inverse color for the primary text color.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The inverse color for the primary text color.
     */
    @ColorInt int getTextPrimaryColorInverse(boolean resolve, boolean inverse);

    /**
     * Returns the inverse color for the primary text color.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The inverse color for the primary text color.
     */
    @ColorInt int getTextPrimaryColorInverse(boolean resolve);

    /**
     * Returns the inverse color for the primary text color.
     *
     * @return The inverse color for the primary text color.
     */
    @ColorInt int getTextPrimaryColorInverse();

    /**
     * Set the primary text inverse color used by this theme.
     *
     * @param textPrimaryColorInverse The primary text inverse color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTextPrimaryColorInverse(int textPrimaryColorInverse);

    /**
     * Returns the inverse color for the secondary text color.
     *
     * @param resolve {@code true} to resolve the auto color.
     * @param inverse {@code true} to resolve the inverse color.
     *
     * @return The inverse color for the secondary text color.
     */
    @ColorInt int getTextSecondaryColorInverse(boolean resolve, boolean inverse);

    /**
     * Returns the inverse color for the secondary text color.
     *
     * @param resolve {@code true} to resolve the auto color.
     *
     * @return The inverse color for the secondary text color.
     */
    @ColorInt int getTextSecondaryColorInverse(boolean resolve);

    /**
     * Returns the inverse color for the secondary text color.
     *
     * @return The inverse color for the secondary text color.
     */
    @ColorInt int getTextSecondaryColorInverse();

    /**
     * Set the secondary text inverse color used by this theme.
     *
     * @param textSecondaryColorInverse The secondary text inverse color to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setTextSecondaryColorInverse(int textSecondaryColorInverse);

    /**
     * Returns the highlight color for this theme.
     *
     * @param contrastWithColor The contrast with color to be used.
     *
     * @return The highlight color for this theme.
     */
    @ColorInt int getHighlightColor(@ColorInt int contrastWithColor);

    /**
     * Returns the highlight color for this theme.
     *
     * @return The highlight color for this theme.
     */
    @ColorInt int getHighlightColor();

    /**
     * Returns the font scaling factor used by this theme.
     *
     * @param resolve {@code true} to resolve the auto font scale.
     *
     * @return The font scaling factor (in percent) used by this theme.
     */
    int getFontScale(boolean resolve);

    /**
     * Returns the font scaling factor used by this theme.
     *
     * @return The font scaling factor (in percent) used by this theme.
     */
    int getFontScale();

    /**
     * Returns the relative font scale after dividing it by 100.
     *
     * @return The relative font scale after dividing it by 100.
     */
    float getFontScaleRelative();

    /**
     * Set the font scaling factor used by this theme.
     *
     * @param fontScale The font scaling factor (in percent) to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setFontScale(int fontScale);

    /**
     * Checks whether the custom font scale is set.
     *
     * @return {@code true} if the custom font scale is set.
     */
    boolean isFontScale();
}
