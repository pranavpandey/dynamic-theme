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

/**
 * A {@link BaseTheme} to implement the stroke theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface StrokeTheme<T extends StrokeTheme<T>> extends BaseTheme<T> {

    /**
     * Returns whether the stroke is required for this theme.
     *
     * @return {@code true} if the stroke is required for this theme.
     */
    boolean isStroke();

    /**
     * Returns the stroke color used by this theme.
     *
     * @return The stroke color used by this theme.
     */
    @ColorInt int getStrokeColor();
}
