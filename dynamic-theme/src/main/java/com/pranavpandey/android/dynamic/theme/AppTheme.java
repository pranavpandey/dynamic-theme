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

package com.pranavpandey.android.dynamic.theme;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

/**
 * Interface to implement an app theme.
 */
public interface AppTheme<T extends AppTheme<?>> {

    /**
     * Returns the fallback dynamic theme to resolve the runtime values like auto color.
     *
     * @param resolve {@code true} to resolve the current theme,
     *                otherwise return the default theme.
     *
     * @return The fallback dynamic theme to resolve the runtime values.
     */
    @NonNull T getThemeFallback(boolean resolve);

    /**
     * Returns the theme resource used by this theme.
     *
     * @return The theme resource used by this theme.
     */
    @StyleRes int getThemeRes();

    /**
     * Set the theme resource used by this theme.
     *
     * @param themeRes The theme resource to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setThemeRes(@StyleRes int themeRes);

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
     * Returns the stroke color used by this theme.
     *
     * @return The stroke color used by this theme.
     */
    @ColorInt int getStrokeColor();

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

    /**
     * Returns the background aware functionality used by this theme.
     *
     * @param resolve {@code true} to resolve auto background aware.
     *
     * @return The background aware functionality used by this theme.
     */
    @Theme.BackgroundAware int getBackgroundAware(boolean resolve);

    /**
     * Returns the background aware functionality used by this theme.
     *
     * @return The background aware functionality used by this theme.
     */
    @Theme.BackgroundAware int getBackgroundAware();

    /**
     * Checks whether the background aware functionality is enabled.
     *
     * @return {@code true} if the background aware functionality is enabled.
     */
    boolean isBackgroundAware();

    /**
     * Set the background aware functionality used by this theme.
     *
     * @param backgroundAware The background aware functionality to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setBackgroundAware(@Theme.BackgroundAware int backgroundAware);

    /**
     * Get the opacity value used by this theme.
     *
     * @param resolve {@code true} to resolve auto opacity.
     *
     * @return The opacity value used by this theme.
     */
    int getOpacity(boolean resolve);

    /**
     * Get the opacity value used by this theme.
     *
     * @return The opacity value used by this theme.
     */
    int getOpacity();

    /**
     * Set the opacity value used by this theme.
     *
     * @param opacity The opacity value to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setOpacity(int opacity);

    /**
     * Checks whether this theme is translucent.
     *
     * @return {@code true} if this theme is translucent.
     */
    boolean isTranslucent();

    /**
     * Get the style value used by this theme.
     *
     * @return The style value used by this theme.
     */
    @Theme.Style int getStyle();

    /**
     * Set the style value used by this theme.
     *
     * @param style The style value to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setStyle(@Theme.Style int style);

    /**
     * Get the type value used by this theme.
     *
     * @return The type value used by this theme.
     */
    @Theme int getType();

    /**
     * Set the type value used by this theme.
     *
     * @param type The type value to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setType(@Theme int type);

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
     * Checks whether the background should be used as the surface.
     *
     * @return {@code true} if the background should be used as surface.
     */
    boolean isBackgroundSurface();

    /**
     * Returns whether to show the dividers for this theme.
     *
     * @return {@code true} to show the dividers for this theme.
     */
    boolean isShowDividers();

    /**
     * Returns whether to the dynamic colors are used by this theme.
     *
     * @return {@code true} if the dynamic colors are used by this theme.
     */
    boolean isDynamicColor();

    /**
     * Auto generate tint or inverse colors according to the base colors. They can be set
     * individually by calling the appropriate methods.
     *
     * @param tint {@code true} to generate tint colors.
     * @param inverse {@code true} to generate inverse colors.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T autoGenerateColors(boolean tint, boolean inverse);

    /**
     * Auto generate tint or inverse colors according to the base colors. They can be set
     * individually by calling the appropriate methods.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     *
     * @see #autoGenerateColors(boolean, boolean)
     */
    @NonNull T autoGenerateColors();

    /**
     * Converts this theme into its JSON equivalent.
     *
     * @return The JSON equivalent of this theme.
     */
    @NonNull String toJsonString();

    /**
     * Convert this theme into a pretty JSON string.
     *
     * @return The converted JSON string.
     */
    @NonNull String toDynamicString();

    /**
     * Returns the style for the theme code.
     *
     * @return The style for the theme code.
     */
    @Theme.Code.Style int getThemeCodeStyle();
}
