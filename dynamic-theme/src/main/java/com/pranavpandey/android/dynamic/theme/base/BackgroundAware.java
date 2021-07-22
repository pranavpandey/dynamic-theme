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
 * A {@link BaseTheme} to implement a background aware theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface BackgroundAware<T extends BackgroundAware<T>> extends BaseTheme<T> {

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
}
