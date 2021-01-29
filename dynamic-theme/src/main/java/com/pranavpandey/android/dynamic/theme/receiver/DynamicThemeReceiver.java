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

package com.pranavpandey.android.dynamic.theme.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pranavpandey.android.dynamic.theme.Theme;

/**
 * A {@link BroadcastReceiver} to receive the theme data.
 *
 * <p>Extend this broadcast receiver and declare it in the project's manifest to
 * receive the theme data.
 */
public abstract class DynamicThemeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(@NonNull final Context context, @Nullable Intent intent) {
        if (intent != null && intent.getAction() != null
                && intent.getAction().equals(Theme.Intent.ACTION)) {
            if (intent.hasExtra(Theme.Intent.EXTRA_THEME)
                    || intent.hasExtra(Theme.Intent.EXTRA_DATA)) {
                onReceiveTheme(intent.getStringExtra(Theme.Intent.EXTRA_THEME),
                        intent.getStringExtra(Theme.Intent.EXTRA_VALUE),
                        intent.getStringExtra(Theme.Intent.EXTRA_DATA));
            }
        }
    }

    /**
     * This method will be called when a theme data is received by this receiver.
     *
     * @param theme The theme received by the receiver.
     * @param value The theme value received by the receiver.
     * @param data The theme data received by the receiver.
     */
    protected abstract void onReceiveTheme(@Nullable @Theme.ToString String theme,
            @Nullable @Theme.ToString String value, @Nullable String data);
}
