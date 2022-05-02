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

import androidx.annotation.NonNull;

import com.pranavpandey.android.dynamic.theme.DynamicColors;

/**
 * A {@link BaseTheme} to implement the dynamic color theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface DynamicColor<T extends DynamicColor<T>> extends BaseTheme<T>,
        BackgroundTheme<T>, SurfaceTheme<T>, PrimaryTheme<T>, AccentTheme<T>, ErrorTheme<T>  {

    /**
     * Returns whether to the dynamic colors are used by this theme.
     *
     * @return {@code true} if the dynamic colors are used by this theme.
     */
    boolean isDynamicColor();

    /**
     * Return the dynamic colors used by the app.
     *
     * @return The dynamic colors used by the app.
     */
    @NonNull DynamicColors getDynamicColors();
}
