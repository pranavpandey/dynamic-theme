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
 * A {@link BaseTheme} to implement a string theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface StringTheme<T extends StringTheme<T>> extends BaseTheme<T> {

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
}
