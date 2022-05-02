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

package com.pranavpandey.android.dynamic.theme;

import com.pranavpandey.android.dynamic.theme.base.WidgetTheme;

/**
 * An abstract class to implement an app widget theme.
 *
 * @param <T> The type of the dynamic theme.
 * @param <V> The type of the app theme.
 */
public abstract class AppWidgetTheme<T extends AppWidgetTheme<T, V>, V extends AppTheme<V>>
        extends AppTheme<V> implements WidgetTheme<T, V> { }
