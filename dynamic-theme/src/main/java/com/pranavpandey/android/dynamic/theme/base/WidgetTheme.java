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
 * A {@link BaseTheme} to implement a widget theme.
 *
 * @param <T> The type of the dynamic theme.
 * @param <V> The type of the app theme.
 */
public interface WidgetTheme<T extends WidgetTheme<T, V>,
        V extends BaseTheme<V>> extends BaseTheme<V> {

    /**
     * Get the app widget id used by this theme.
     *
     * @return The app widget id used by this theme.
     */
    int getWidgetId();

    /**
     * Set the widget id used by this theme.
     *
     * @param widgetId The widget id to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setWidgetId(int widgetId);

    /**
     * Get the header state used by this theme.
     *
     * @return The header state used by this theme.
     */
    @Theme.Visibility int getHeader();

    /**
     * Returns the header state string used by this theme.
     *
     * @return The header state string used by this theme.
     */
    @NonNull @Theme.Visibility.ToString String getHeaderString();

    /**
     * Set the header state used by this theme.
     *
     * @param header The header state to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setHeader(@Theme.Visibility int header);

    /**
     * Set the header state used by this theme.
     *
     * @param header The header state to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setHeaderString(@NonNull @Theme.Visibility.ToString String header);
}
