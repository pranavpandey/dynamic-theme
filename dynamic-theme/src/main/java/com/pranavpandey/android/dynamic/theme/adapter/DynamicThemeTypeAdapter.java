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

package com.pranavpandey.android.dynamic.theme.adapter;

import androidx.annotation.NonNull;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.pranavpandey.android.dynamic.theme.AppWidgetTheme;
import com.pranavpandey.android.dynamic.theme.Theme;
import com.pranavpandey.android.dynamic.theme.base.AccentTheme;
import com.pranavpandey.android.dynamic.theme.base.BackgroundAware;
import com.pranavpandey.android.dynamic.theme.base.BackgroundTheme;
import com.pranavpandey.android.dynamic.theme.base.BaseTheme;
import com.pranavpandey.android.dynamic.theme.base.CornerTheme;
import com.pranavpandey.android.dynamic.theme.base.ElevationTheme;
import com.pranavpandey.android.dynamic.theme.base.ErrorTheme;
import com.pranavpandey.android.dynamic.theme.base.PrimaryTheme;
import com.pranavpandey.android.dynamic.theme.base.StyleTheme;
import com.pranavpandey.android.dynamic.theme.base.SurfaceTheme;
import com.pranavpandey.android.dynamic.theme.base.TextTheme;
import com.pranavpandey.android.dynamic.theme.base.TranslucentTheme;
import com.pranavpandey.android.dynamic.theme.base.WidgetTheme;
import com.pranavpandey.android.dynamic.theme.util.DynamicThemeUtils;

import java.io.IOException;

/**
 * Gson type adapter to export and import the dynamic theme.
 *
 * @param <T> The type of the dynamic theme.
 *
 * @see BaseTheme
 * @see BackgroundTheme
 * @see SurfaceTheme
 * @see PrimaryTheme
 * @see AccentTheme
 * @see ErrorTheme
 * @see TextTheme
 * @see CornerTheme
 * @see BackgroundTheme
 * @see TranslucentTheme
 * @see StyleTheme
 * @see WidgetTheme
 */
public class DynamicThemeTypeAdapter<T extends BaseTheme<T>> extends TypeAdapter<T> {

    /**
     * Dynamic theme used by this adapter.
     */
    private final @NonNull T mDynamicTheme;

    /**
     * {@code true} to resolve the values.
     */
    private final boolean mResolve;

    /**
     * {@code true} to resolve the inverse values.
     */
    private final boolean mInverse;

    /**
     * Constructor to initialize an object of this class.
     *
     * @param dynamicTheme The dynamic theme to be used.
     */
    public DynamicThemeTypeAdapter(@NonNull T dynamicTheme) {
        this(dynamicTheme, false, false);
    }

    /**
     * Constructor to initialize an object of this class.
     *
     * @param dynamicTheme The dynamic theme to be used.
     * @param resolve {@code true} to resolve the values.
     * @param inverse {@code true} to resolve the inverse values.
     */
    public DynamicThemeTypeAdapter(@NonNull T dynamicTheme, boolean resolve, boolean inverse) {
        this.mDynamicTheme = dynamicTheme;
        this.mResolve = resolve;
        this.mInverse = inverse;
    }

    @Override
    public void write(JsonWriter writer, T value) throws IOException {
        try {
            writer.beginObject();

            if (value instanceof BackgroundTheme) {
                writer.name(Theme.Key.BACKGROUND);
                writer.value(DynamicThemeUtils.getValueFromColor(((BackgroundTheme<?>)
                        value).getBackgroundColor(mResolve, mInverse)));
                writer.name(Theme.Key.TINT_BACKGROUND);
                writer.value(DynamicThemeUtils.getValueFromColor(((BackgroundTheme<?>)
                        value).getTintBackgroundColor(mResolve, mInverse)));
            }

            if (value instanceof SurfaceTheme) {
                writer.name(Theme.Key.SURFACE);
                writer.value(DynamicThemeUtils.getValueFromColor(((SurfaceTheme<?>)
                        value).getSurfaceColor(mResolve, mInverse)));
                writer.name(Theme.Key.TINT_SURFACE);
                writer.value(DynamicThemeUtils.getValueFromColor(((SurfaceTheme<?>)
                        value).getTintSurfaceColor(mResolve, mInverse)));
            }

            if (value instanceof PrimaryTheme) {
                writer.name(Theme.Key.PRIMARY);
                writer.value(DynamicThemeUtils.getValueFromColor(((PrimaryTheme<?>)
                        value).getPrimaryColor(mResolve, mInverse)));
                writer.name(Theme.Key.TINT_PRIMARY);
                writer.value(DynamicThemeUtils.getValueFromColor(((PrimaryTheme<?>)
                        value).getTintPrimaryColor(mResolve, mInverse)));
                writer.name(Theme.Key.PRIMARY_DARK);
                writer.value(DynamicThemeUtils.getValueFromColor(((PrimaryTheme<?>)
                        value).getPrimaryColorDark(mResolve, mInverse)));
                writer.name(Theme.Key.TINT_PRIMARY_DARK);
                writer.value(DynamicThemeUtils.getValueFromColor(((PrimaryTheme<?>)
                        value).getTintPrimaryColorDark(mResolve, mInverse)));
            }

            if (value instanceof AccentTheme) {
                writer.name(Theme.Key.ACCENT);
                writer.value(DynamicThemeUtils.getValueFromColor(((AccentTheme<?>)
                        value).getAccentColor(mResolve, mInverse)));
                writer.name(Theme.Key.TINT_ACCENT);
                writer.value(DynamicThemeUtils.getValueFromColor(((AccentTheme<?>)
                        value).getTintAccentColor(mResolve, mInverse)));
                writer.name(Theme.Key.ACCENT_DARK);
                writer.value(DynamicThemeUtils.getValueFromColor(((AccentTheme<?>)
                        value).getAccentColorDark(mResolve, mInverse)));
                writer.name(Theme.Key.TINT_ACCENT_DARK);
                writer.value(DynamicThemeUtils.getValueFromColor(((AccentTheme<?>)
                        value).getTintAccentColorDark(mResolve, mInverse)));
            }

            if (value instanceof ErrorTheme) {
                writer.name(Theme.Key.ERROR);
                writer.value(DynamicThemeUtils.getValueFromColor(((ErrorTheme<?>)
                        value).getErrorColor(mResolve, mInverse)));
                writer.name(Theme.Key.TINT_ERROR);
                writer.value(DynamicThemeUtils.getValueFromColor(((ErrorTheme<?>)
                        value).getTintErrorColor(mResolve, mInverse)));
            }

            if (value instanceof TextTheme) {
                writer.name(Theme.Key.TEXT_PRIMARY);
                writer.value(DynamicThemeUtils.getValueFromColor(((TextTheme<?>)
                        value).getTextPrimaryColor(mResolve, mInverse)));
                writer.name(Theme.Key.TEXT_PRIMARY_INVERSE);
                writer.value(DynamicThemeUtils.getValueFromColor(((TextTheme<?>)
                        value).getTextPrimaryColorInverse(mResolve, mInverse)));
                writer.name(Theme.Key.TEXT_SECONDARY);
                writer.value(DynamicThemeUtils.getValueFromColor(((TextTheme<?>)
                        value).getTextSecondaryColor(mResolve, mInverse)));
                writer.name(Theme.Key.TEXT_SECONDARY_INVERSE);
                writer.value(DynamicThemeUtils.getValueFromColor(((TextTheme<?>)
                        value).getTextSecondaryColorInverse(mResolve, mInverse)));
                writer.name(Theme.Key.FONT_SCALE);
                writer.value(DynamicThemeUtils.getValueFromFontScale(((TextTheme<?>)
                        value).getFontScale(mResolve)));
            }

            if (value instanceof CornerTheme) {
                writer.name(Theme.Key.CORNER_RADIUS);
                writer.value(DynamicThemeUtils.getValueFromCornerRadius(
                        ((CornerTheme<?>) value).getCornerRadius(mResolve)));
            }

            if (value instanceof BackgroundAware) {
                writer.name(Theme.Key.BACKGROUND_AWARE);
                writer.value(DynamicThemeUtils.getValueFromBackgroundAware(
                        ((BackgroundAware<?>) value).getBackgroundAware(mResolve)));
                writer.name(Theme.Key.CONTRAST);
                writer.value(DynamicThemeUtils.getValueFromContrast(
                        ((BackgroundAware<?>) value).getContrast(mResolve)));
            }

            if (value instanceof TranslucentTheme) {
                writer.name(Theme.Key.OPACITY);
                writer.value(DynamicThemeUtils.getValueFromOpacity(
                        ((TranslucentTheme<?>) value).getOpacity(mResolve)));
            }

            if (value instanceof ElevationTheme) {
                writer.name(Theme.Key.ELEVATION);
                writer.value(DynamicThemeUtils.getValueFromElevation(
                        ((ElevationTheme<?>) value).getElevation(mResolve)));
            }

            if (value instanceof StyleTheme) {
                writer.name(Theme.Key.STYLE);
                writer.value(DynamicThemeUtils.getValueFromStyle(
                        ((StyleTheme<?>) value).getStyle()));
            }

            if (value instanceof WidgetTheme) {
                writer.name(Theme.Key.HEADER);
                writer.value(DynamicThemeUtils.getValueFromVisibility(
                        ((WidgetTheme<?, ?>) value).getHeader()));
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
            if (!JsonToken.BEGIN_OBJECT.equals(token)) {
                return mDynamicTheme;
            }

            reader.beginObject();

            while (!JsonToken.END_OBJECT.equals(reader.peek())) {
                if (!JsonToken.NAME.equals(reader.peek())) {
                    reader.skipValue();
                    continue;
                }

                switch (reader.nextName()) {
                    case Theme.Key.BACKGROUND:
                    case Theme.Key.Short.BACKGROUND:
                        if (mDynamicTheme instanceof BackgroundTheme) {
                            ((BackgroundTheme<?>) mDynamicTheme).setBackgroundColor(
                                    DynamicThemeUtils.getValueFromColor(
                                            reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TINT_BACKGROUND:
                    case Theme.Key.Short.TINT_BACKGROUND:
                        if (mDynamicTheme instanceof BackgroundTheme) {
                            ((BackgroundTheme<?>) mDynamicTheme).setTintBackgroundColor(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.SURFACE:
                    case Theme.Key.Short.SURFACE:
                        if (mDynamicTheme instanceof SurfaceTheme) {
                            ((SurfaceTheme<?>) mDynamicTheme).setSurfaceColor(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TINT_SURFACE:
                    case Theme.Key.Short.TINT_SURFACE:
                        if (mDynamicTheme instanceof SurfaceTheme) {
                            ((SurfaceTheme<?>) mDynamicTheme).setTintSurfaceColor(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.PRIMARY:
                    case Theme.Key.Short.PRIMARY:
                        if (mDynamicTheme instanceof PrimaryTheme) {
                            ((PrimaryTheme<?>) mDynamicTheme).setPrimaryColor(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TINT_PRIMARY:
                    case Theme.Key.Short.TINT_PRIMARY:
                        if (mDynamicTheme instanceof PrimaryTheme) {
                            ((PrimaryTheme<?>) mDynamicTheme).setTintPrimaryColor(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.PRIMARY_DARK:
                    case Theme.Key.Short.PRIMARY_DARK:
                        if (mDynamicTheme instanceof PrimaryTheme) {
                            ((PrimaryTheme<?>) mDynamicTheme).setPrimaryColorDark(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TINT_PRIMARY_DARK:
                    case Theme.Key.Short.TINT_PRIMARY_DARK:
                        if (mDynamicTheme instanceof PrimaryTheme) {
                            ((PrimaryTheme<?>) mDynamicTheme).setTintPrimaryColorDark(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.ACCENT:
                    case Theme.Key.Short.ACCENT:
                        if (mDynamicTheme instanceof AccentTheme) {
                            ((AccentTheme<?>) mDynamicTheme).setAccentColor(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TINT_ACCENT:
                    case Theme.Key.Short.TINT_ACCENT:
                        if (mDynamicTheme instanceof AccentTheme) {
                            ((AccentTheme<?>) mDynamicTheme).setTintAccentColor(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.ACCENT_DARK:
                    case Theme.Key.Short.ACCENT_DARK:
                        if (mDynamicTheme instanceof AccentTheme) {
                            ((AccentTheme<?>) mDynamicTheme).setAccentColorDark(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TINT_ACCENT_DARK:
                    case Theme.Key.Short.TINT_ACCENT_DARK:
                        if (mDynamicTheme instanceof AccentTheme) {
                            ((AccentTheme<?>) mDynamicTheme).setTintAccentColorDark(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.ERROR:
                    case Theme.Key.Short.ERROR:
                        if (mDynamicTheme instanceof ErrorTheme) {
                            ((ErrorTheme<?>) mDynamicTheme).setErrorColor(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TINT_ERROR:
                    case Theme.Key.Short.TINT_ERROR:
                        if (mDynamicTheme instanceof ErrorTheme) {
                            ((ErrorTheme<?>) mDynamicTheme).setTintErrorColor(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.TEXT_PRIMARY:
                    case Theme.Key.Short.TEXT_PRIMARY:
                        if (mDynamicTheme instanceof TextTheme) {
                            ((TextTheme<?>) mDynamicTheme).setTextPrimaryColor(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TEXT_PRIMARY_INVERSE:
                    case Theme.Key.Short.TEXT_PRIMARY_INVERSE:
                        if (mDynamicTheme instanceof TextTheme) {
                            ((TextTheme<?>) mDynamicTheme).setTextPrimaryColorInverse(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.TEXT_SECONDARY:
                    case Theme.Key.Short.TEXT_SECONDARY:
                        if (mDynamicTheme instanceof TextTheme) {
                            ((TextTheme<?>) mDynamicTheme).setTextSecondaryColor(DynamicThemeUtils
                                    .getValueFromColor(reader.nextString()), false);
                        }
                        break;
                    case Theme.Key.TEXT_SECONDARY_INVERSE:
                    case Theme.Key.Short.TEXT_SECONDARY_INVERSE:
                        if (mDynamicTheme instanceof TextTheme) {
                            ((TextTheme<?>) mDynamicTheme).setTextSecondaryColorInverse(
                                    DynamicThemeUtils.getValueFromColor(reader.nextString()));
                        }
                        break;
                    case Theme.Key.FONT_SCALE:
                    case Theme.Key.Short.FONT_SCALE:
                        if (mDynamicTheme instanceof TextTheme) {
                            ((TextTheme<?>) mDynamicTheme).setFontScale(DynamicThemeUtils
                                    .getValueFromFontScale(reader.nextString()));
                        }
                        break;
                    case Theme.Key.CORNER_RADIUS:
                    case Theme.Key.Short.CORNER_RADIUS:
                        if (mDynamicTheme instanceof CornerTheme) {
                            ((CornerTheme<?>) mDynamicTheme).setCornerSize(DynamicThemeUtils
                                    .getValueFromCornerRadius(reader.nextString()));
                        }
                        break;
                    case Theme.Key.BACKGROUND_AWARE:
                    case Theme.Key.Short.BACKGROUND_AWARE:
                        if (mDynamicTheme instanceof BackgroundAware) {
                            ((BackgroundAware<?>) mDynamicTheme).setBackgroundAware(
                                    DynamicThemeUtils.getValueFromBackgroundAware(
                                            reader.nextString()));
                        }
                        break;
                    case Theme.Key.CONTRAST:
                    case Theme.Key.Short.CONTRAST:
                        if (mDynamicTheme instanceof BackgroundAware) {
                            ((BackgroundAware<?>) mDynamicTheme).setContrast(DynamicThemeUtils
                                    .getValueFromContrast(reader.nextString()));
                        }
                        break;
                    case Theme.Key.OPACITY:
                    case Theme.Key.Short.OPACITY:
                        if (mDynamicTheme instanceof TranslucentTheme) {
                            ((TranslucentTheme<?>) mDynamicTheme).setOpacity(DynamicThemeUtils
                                    .getValueFromOpacity(reader.nextString()));
                        }
                        break;
                    case Theme.Key.ELEVATION:
                    case Theme.Key.Short.ELEVATION:
                        if (mDynamicTheme instanceof ElevationTheme) {
                            ((ElevationTheme<?>) mDynamicTheme).setElevation(DynamicThemeUtils
                                    .getValueFromElevation(reader.nextString()));
                        }
                        break;
                    case Theme.Key.STYLE:
                    case Theme.Key.Short.STYLE:
                        if (mDynamicTheme instanceof StyleTheme) {
                            ((StyleTheme<?>) mDynamicTheme).setStyle(DynamicThemeUtils
                                    .getValueFromStyle(reader.nextString()));
                        }
                        break;
                    case Theme.Key.HEADER:
                    case Theme.Key.Short.HEADER:
                        if (mDynamicTheme instanceof AppWidgetTheme) {
                            ((WidgetTheme<?, ?>) mDynamicTheme).setHeader(DynamicThemeUtils
                                    .getValueFromVisibility(reader.nextString()));
                        }
                        break;
                    default:
                        reader.skipValue();
                        break;
                }
            }

            reader.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mDynamicTheme;
    }
}
