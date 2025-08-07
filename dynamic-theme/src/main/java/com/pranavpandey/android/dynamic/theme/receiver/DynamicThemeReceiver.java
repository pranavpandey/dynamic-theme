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

package com.pranavpandey.android.dynamic.theme.receiver;

import android.appwidget.AppWidgetManager;
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
    public void onReceive(final @NonNull Context context, @Nullable Intent intent) {
        if (intent == null) {
            return;
        }

        if (Theme.Intent.ACTION.equals(intent.getAction())) {
            if (intent.hasExtra(Theme.Intent.EXTRA_THEME)
                    || intent.hasExtra(Theme.Intent.EXTRA_DATA)) {
                onReceiveTheme(intent.getStringExtra(Theme.Intent.EXTRA_THEME),
                        intent.getStringExtra(Theme.Intent.EXTRA_VALUE),
                        intent.getStringExtra(Theme.Intent.EXTRA_DATA));
            }
        } else if (Theme.Intent.ACTION_APP_WIDGET.equals(intent.getAction())
                || intent.hasExtra(AppWidgetManager.EXTRA_APPWIDGET_ID)) {
            int appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);

            if (appWidgetId != AppWidgetManager.INVALID_APPWIDGET_ID) {
                onAppWidget(appWidgetId, intent.getStringExtra(Theme.Intent.EXTRA_PREFS),
                        intent.getStringExtra(Theme.Intent.EXTRA_THEME));
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

    /**
     * This method will be called when an app widget is added via pinning.
     *
     * @param appWidgetId The generated app widget id.
     * @param prefs The received shared preferences name.
     * @param theme The received widget theme or settings.
     */
    protected void onAppWidget(int appWidgetId,
            @Nullable String prefs, @Nullable String theme) { }
}
