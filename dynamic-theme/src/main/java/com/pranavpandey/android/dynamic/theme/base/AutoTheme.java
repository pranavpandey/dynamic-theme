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

import androidx.annotation.NonNull;

/**
 * A {@link BaseTheme} to implement an auto theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface AutoTheme<T extends AutoTheme<T>> extends BaseTheme<T> {

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
}
