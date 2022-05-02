/*
 * Copyright 2019-2022 Pranav Pandey
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
 * A {@link BaseTheme} to implement the translucent theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public interface TranslucentTheme<T extends TranslucentTheme<T>> extends BaseTheme<T> {

    /**
     * Get the opacity value used by this theme.
     *
     * @param resolve {@code true} to resolve auto opacity.
     *
     * @return The opacity value used by this theme.
     */
    int getOpacity(boolean resolve);

    /**
     * Get the opacity value used by this theme.
     *
     * @return The opacity value used by this theme.
     */
    int getOpacity();

    /**
     * Set the opacity value used by this theme.
     *
     * @param opacity The opacity value to be set.
     *
     * @return The {@link T} object to allow for chaining of calls to set methods.
     */
    @NonNull T setOpacity(int opacity);

    /**
     * Returns the opacity after converting it into the float range.
     *
     * @return The opacity after converting it into the float range.
     */
    float getAlpha();

    /**
     * Checks whether this theme is translucent.
     *
     * @return {@code true} if this theme is translucent.
     */
    boolean isTranslucent();
}
