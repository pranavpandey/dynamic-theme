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

import com.pranavpandey.android.dynamic.theme.Theme;

/**
 * A {@link BaseTheme} to implement a code theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface CodeTheme<T extends CodeTheme<T>> extends StringTheme<T> {

    /**
     * Returns the style for the theme code.
     *
     * @return The style for the theme code.
     */
    @Theme.Code.Style int getThemeCodeStyle();
}
