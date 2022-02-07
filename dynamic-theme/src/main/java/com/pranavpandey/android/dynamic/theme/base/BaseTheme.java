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
 * An interface to implement the base theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface BaseTheme<T extends BaseTheme<T>> {

    /**
     * Returns whether this theme is host and can have child themes.
     *
     * @return {@code true} if this theme is host and can have child themes.
     */
    boolean isHost();

    /**
     * Sets whether this theme is host and can have child themes.
     *
     * @param host {@code true} to set the theme as host.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setHost(boolean host);
}
