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

import com.pranavpandey.android.dynamic.theme.Theme;

/**
 * A {@link BaseTheme} to implement a type theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface TypeTheme<T extends TypeTheme<T>> extends BaseTheme<T> {

    /**
     * Get the type value used by this theme.
     *
     * @param resolve {@code true} to resolve theme style.
     *
     * @return The type value used by this theme.
     */
    @Theme int getType(boolean resolve);

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
}
