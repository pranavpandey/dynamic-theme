/*
 * Copyright 2017-2022 Pranav Pandey
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

import com.pranavpandey.android.dynamic.theme.Theme;

/**
 * A {@link BaseTheme} to implement the code theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface CodeTheme<T extends CodeTheme<T>> extends StringTheme<T> {

    /**
     * Returns the data for the theme code.
     *
     * @return The data for the theme code.
     */
    @NonNull String getCodeData();

    /**
     * Returns the color for the code background.
     *
     * @return The color for the code background.
     */
    @ColorInt int getCodeBackgroundColor();

    /**
     * Returns the color for the code stroke.
     *
     * @return The color for the code stroke.
     */
    @ColorInt int getCodeStrokeColor();

    /**
     * Returns the color for the code data.
     *
     * @return The color for the code data.
     */
    @ColorInt int getCodeDataColor();

    /**
     * Returns the color for the code finder.
     *
     * @return The color for the finder data.
     */
    @ColorInt int getCodeFinderColor();

    /**
     * Returns the color for the code overlay.
     *
     * @return The color for the code overlay.
     */
    @ColorInt int getCodeOverlayColor();

    /**
     * Returns the code contrast ratio for by this theme.
     *
     * @return The code contrast ratio for by this theme.
     */
    float getCodeContrastRatio();

    /**
     * Returns the style for the theme code.
     *
     * @return The style for the theme code.
     */
    @Theme.Code.Style int getCodeStyle();
}
