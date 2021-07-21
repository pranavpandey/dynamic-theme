/*
 * Copyright 2018-2021 Pranav Pandey
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

package com.pranavpandey.android.dynamic.theme.adapter;

import androidx.annotation.NonNull;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.pranavpandey.android.dynamic.theme.AppTheme;
import com.pranavpandey.android.dynamic.theme.AppWidgetTheme;
import com.pranavpandey.android.dynamic.theme.Theme;
import com.pranavpandey.android.dynamic.theme.utils.DynamicThemeUtils;

import java.io.IOException;

/**
 * Gson type adapter to export and import the dynamic theme.
 *
 * @param <T> The type of the dynamic theme.
 *
 * @see AppTheme
 * @see AppWidgetTheme
 */
public class DynamicThemeTypeAdapter<T extends AppTheme<?>> extends TypeAdapter<T> {

    /**
     * Dynamic theme used by this adapter.
     */
    private final @NonNull T mDynamicTheme;

    /**
     * Constructor to initialize an object of this class.
     *
     * @param dynamicTheme The dynamic theme to be used.
     */
    public DynamicThemeTypeAdapter(@NonNull T dynamicTheme) {
        this.mDynamicTheme = dynamicTheme;
    }

    @Override
    public void write(JsonWriter writer, T value) throws IOException {
        try {
            writer.beginObject();

            writer.name(Theme.Key.BACKGROUND);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getBackgroundColor(false, false)));
            writer.name(Theme.Key.TINT_BACKGROUND);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTintBackgroundColor(false, false)));
            writer.name(Theme.Key.SURFACE);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getSurfaceColor(false, false)));
            writer.name(Theme.Key.TINT_SURFACE);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTintSurfaceColor(false, false)));
            writer.name(Theme.Key.PRIMARY);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getPrimaryColor(false, false)));
            writer.name(Theme.Key.TINT_PRIMARY);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTintPrimaryColor(false, false)));
            writer.name(Theme.Key.PRIMARY_DARK);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getPrimaryColorDark(false, false)));
            writer.name(Theme.Key.TINT_PRIMARY_DARK);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTintPrimaryColorDark(false, false)));
            writer.name(Theme.Key.ACCENT);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getAccentColor(false, false)));
            writer.name(Theme.Key.TINT_ACCENT);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTintAccentColor(false, false)));
            writer.name(Theme.Key.ACCENT_DARK);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getAccentColorDark(false, false)));
            writer.name(Theme.Key.TINT_ACCENT_DARK);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTintAccentColorDark(false, false)));
            writer.name(Theme.Key.ERROR);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getErrorColor(false, false)));
            writer.name(Theme.Key.TINT_ERROR);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTintErrorColor(false, false)));
            writer.name(Theme.Key.TEXT_PRIMARY);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTextPrimaryColor(false, false)));
            writer.name(Theme.Key.TEXT_PRIMARY_INVERSE);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTextPrimaryColorInverse(false, false)));
            writer.name(Theme.Key.TEXT_SECONDARY);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTextSecondaryColor(false, false)));
            writer.name(Theme.Key.TEXT_SECONDARY_INVERSE);
            writer.value(DynamicThemeUtils.getValueFromColor(
                    value.getTextSecondaryColorInverse(false, false)));
            writer.name(Theme.Key.FONT_SCALE);
            writer.value(DynamicThemeUtils.getValueFromFontScale(
                    value.getFontScale(false)));
            writer.name(Theme.Key.CORNER_RADIUS);
            writer.value(DynamicThemeUtils.getValueFromCornerRadius(
                    value.getCornerRadius(false)));
            writer.name(Theme.Key.BACKGROUND_AWARE);
            writer.value(DynamicThemeUtils.getValueFromBackgroundAware(
                    value.getBackgroundAware(false)));
            writer.name(Theme.Key.OPACITY);
            writer.value(DynamicThemeUtils.getValueFromOpacity(value.getOpacity(false)));
            writer.name(Theme.Key.STYLE);
            writer.value(DynamicThemeUtils.getValueFromStyle(value.getStyle()));

            if (value instanceof AppWidgetTheme) {
                writer.name(Theme.Key.HEADER);
                writer.value(DynamicThemeUtils.getValueFromVisibility(
                        ((AppWidgetTheme<?>) value).getHeader()));
            }

            writer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public @NonNull T read(JsonReader reader) throws IOException {
        try {
            JsonToken token = reader.peek();
            if (JsonToken.BEGIN_OBJECT.equals(token)) {
                reader.beginObject();

                while (!JsonToken.END_OBJECT.equals(reader.peek())) {
                    if (JsonToken.NAME.equals(reader.peek())) {
                        switch (reader.nextName()) {
                            case Theme.Key.BACKGROUND:
                            case Theme.Key.Short.BACKGROUND:
                                mDynamicTheme.setBackgroundColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TINT_BACKGROUND:
                            case Theme.Key.Short.TINT_BACKGROUND:
                                mDynamicTheme.setTintBackgroundColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.SURFACE:
                            case Theme.Key.Short.SURFACE:
                                mDynamicTheme.setSurfaceColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TINT_SURFACE:
                            case Theme.Key.Short.TINT_SURFACE:
                                mDynamicTheme.setTintSurfaceColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.PRIMARY:
                            case Theme.Key.Short.PRIMARY:
                                mDynamicTheme.setPrimaryColor(DynamicThemeUtils.getValueFromColor(
                                        reader.nextString()), false);
                                break;
                            case Theme.Key.TINT_PRIMARY:
                            case Theme.Key.Short.TINT_PRIMARY:
                                mDynamicTheme.setTintPrimaryColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.PRIMARY_DARK:
                            case Theme.Key.Short.PRIMARY_DARK:
                                mDynamicTheme.setPrimaryColorDark(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TINT_PRIMARY_DARK:
                            case Theme.Key.Short.TINT_PRIMARY_DARK:
                                mDynamicTheme.setTintPrimaryColorDark(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.ACCENT:
                            case Theme.Key.Short.ACCENT:
                                mDynamicTheme.setAccentColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TINT_ACCENT:
                            case Theme.Key.Short.TINT_ACCENT:
                                mDynamicTheme.setTintAccentColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.ACCENT_DARK:
                            case Theme.Key.Short.ACCENT_DARK:
                                mDynamicTheme.setAccentColorDark(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TINT_ACCENT_DARK:
                            case Theme.Key.Short.TINT_ACCENT_DARK:
                                mDynamicTheme.setTintAccentColorDark(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.ERROR:
                            case Theme.Key.Short.ERROR:
                                mDynamicTheme.setErrorColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TINT_ERROR:
                            case Theme.Key.Short.TINT_ERROR:
                                mDynamicTheme.setTintErrorColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.TEXT_PRIMARY:
                            case Theme.Key.Short.TEXT_PRIMARY:
                                mDynamicTheme.setTextPrimaryColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TEXT_PRIMARY_INVERSE:
                            case Theme.Key.Short.TEXT_PRIMARY_INVERSE:
                                mDynamicTheme.setTextPrimaryColorInverse(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.TEXT_SECONDARY:
                            case Theme.Key.Short.TEXT_SECONDARY:
                                mDynamicTheme.setTextSecondaryColor(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()), false);
                                break;
                            case Theme.Key.TEXT_SECONDARY_INVERSE:
                            case Theme.Key.Short.TEXT_SECONDARY_INVERSE:
                                mDynamicTheme.setTextSecondaryColorInverse(DynamicThemeUtils
                                        .getValueFromColor(reader.nextString()));
                                break;
                            case Theme.Key.FONT_SCALE:
                            case Theme.Key.Short.FONT_SCALE:
                                mDynamicTheme.setFontScale(DynamicThemeUtils
                                        .getValueFromFontScale(reader.nextString()));
                                break;
                            case Theme.Key.CORNER_RADIUS:
                            case Theme.Key.Short.CORNER_RADIUS:
                                mDynamicTheme.setCornerRadiusDp(DynamicThemeUtils
                                        .getValueFromCornerRadius(reader.nextString()));
                                break;
                            case Theme.Key.BACKGROUND_AWARE:
                            case Theme.Key.Short.BACKGROUND_AWARE:
                                mDynamicTheme.setBackgroundAware(DynamicThemeUtils
                                        .getValueFromBackgroundAware(reader.nextString()));
                                break;
                            case Theme.Key.OPACITY:
                            case Theme.Key.Short.OPACITY:
                                mDynamicTheme.setOpacity(DynamicThemeUtils
                                        .getValueFromOpacity(reader.nextString()));
                                break;
                            case Theme.Key.STYLE:
                            case Theme.Key.Short.STYLE:
                                mDynamicTheme.setStyle(DynamicThemeUtils
                                        .getValueFromStyle(reader.nextString()));
                                break;
                            case Theme.Key.HEADER:
                            case Theme.Key.Short.HEADER:
                                if (mDynamicTheme instanceof AppWidgetTheme) {
                                    ((AppWidgetTheme<?>) mDynamicTheme).setHeader(DynamicThemeUtils
                                            .getValueFromVisibility(reader.nextString()));
                                }
                                break;
                            default:
                                reader.skipValue();
                                break;
                        }
                    } else {
                        reader.skipValue();
                    }
                }

                reader.endObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mDynamicTheme;
    }
}
