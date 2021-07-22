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
import androidx.annotation.StyleRes;

/**
 * A {@link BaseTheme} to implement a resource theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface ResourceTheme<T extends ResourceTheme<T>> extends BaseTheme<T> {

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
}
