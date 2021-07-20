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

package com.pranavpandey.android.dynamic.theme;

import android.annotation.TargetApi;
import android.app.WallpaperColors;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pranavpandey.android.dynamic.utils.DynamicColorUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A class to handle dynamic colors generation.
 */
public class DynamicColors implements Parcelable {

    /**
     * Factor to generate shades of a color.
     */
    private static final float FACTOR = 0.8f;

    /**
     * Map to store the original colors.
     */
    private final Map<Integer, Integer> mOriginal;

    /**
     * Map to store the mutated (dark) colors.
     */
    private final Map<Integer, Integer> mDark;

    /**
     * Map to store the mutated (light) colors.
     */
    private final Map<Integer, Integer> mLight;

    /**
     * Constructor to initialize an object of this class.
     */
    public DynamicColors() {
        this(new HashMap<>());
    }

    /**
     * Constructor to initialize an object of this class.
     *
     * @param original The original colors to be handled.
     */
    public DynamicColors(@NonNull Map<Integer, Integer> original) {
        this.mOriginal = new HashMap<>(original);
        this.mDark = new HashMap<>(original);
        this.mLight = new HashMap<>(original);
    }

    /**
     * Parcelable creator to create from parcel.
     */
    public static final Parcelable.Creator<DynamicColors> CREATOR =
            new Parcelable.Creator<DynamicColors>() {
        @Override
        public DynamicColors createFromParcel(Parcel in) {
            return new DynamicColors(in);
        }

        @Override
        public DynamicColors[] newArray(int size) {
            return new DynamicColors[size];
        }
    };

    /**
     * Read an object of this class from the parcel.
     *
     * @param in The parcel to read the values.
     */
    public DynamicColors(Parcel in) {
        this();

        in.readMap(mOriginal, mOriginal.getClass().getClassLoader());
        in.readMap(mDark, mDark.getClass().getClassLoader());
        in.readMap(mLight, mDark.getClass().getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeMap(mOriginal);
        dest.writeMap(mDark);
        dest.writeMap(mLight);
    }

    /**
     * Get the map of original colors.
     *
     * @return The map of original colors.
     */
    public @NonNull Map<Integer, Integer> getOriginal() {
        return mOriginal;
    }

    /**
     * Get the map of mutated (dark) colors.
     *
     * @return The map of mutated (dark) colors.
     */
    public @NonNull Map<Integer, Integer> getDark() {
        return mDark;
    }

    /**
     * Get the map of mutated (light) colors.
     *
     * @return The map of mutated (light) colors.
     */
    public @NonNull Map<Integer, Integer> getLight() {
        return mLight;
    }

    /**
     * Get the color according to its type from the supplied map.
     *
     * @param colors The color map to be used.
     * @param colorType The type of the color.
     * @param fallback The fallback color if the request color type is not found.
     *
     * @return The color according to its type from the supplied map.
     */
    public @ColorInt int get(@NonNull Map<Integer, Integer> colors,
            @Theme.ColorType int colorType, @ColorInt int fallback) {
        final @ColorInt Integer color;
        if (colors.containsKey(colorType) && (color = colors.get(colorType)) != null) {
            return color != Theme.AUTO ? color : fallback;
        }

        return fallback;
    }

    /**
     * Get the original color according to its type.
     *
     * @param colorType The type of the color.
     * @param fallback The fallback color if the request color type is not found.
     *
     * @return The original color according to its type.
     */
    public @ColorInt int getOriginal(@Theme.ColorType int colorType, @ColorInt int fallback) {
        return get(getOriginal(), colorType, fallback);
    }

    /**
     * Get the map of mutated colors according to the supplied theme.
     *
     * @param theme The dynamic theme to be used.
     *
     * @return The map of mutated colors according to the supplied theme.
     */
    public @NonNull Map<Integer, Integer> getMutated(@NonNull AppTheme<?> theme) {
        if (theme.isDarkTheme()) {
            return theme.isInverseTheme() ? mLight : mDark;
        }

        return theme.isInverseTheme() ? mDark : mLight;
    }

    /**
     * Get the mutated color according to its type.
     *
     * @param colorType The type of the color.
     * @param fallback The fallback color if the request color type is not found.
     * @param theme The dynamic theme to be used.
     *
     * @return The mutated color according to its type.
     */
    public @ColorInt int getMutated(@Theme.ColorType int colorType,
            @ColorInt int fallback, @NonNull AppTheme<?> theme) {
        return get(getMutated(theme), colorType, fallback);
    }

    /**
     * Store the color according to its type in the supplied map.
     *
     * @param colors The map to store the color.
     * @param colorType The type of the color.
     * @param color The color to be stored.
     */
    public void put(@NonNull Map<Integer, Integer> colors,
            @Theme.ColorType int colorType, @ColorInt int color) {
        colors.put(colorType, color);
    }

    /**
     * Store the color according to its type in the original map.
     *
     * @param colorType The type of the color.
     * @param color The color to be stored.
     */
    public void putOriginal(@Theme.ColorType int colorType, @ColorInt int color) {
        put(getOriginal(), colorType, color);
    }

    /**
     * Store the color according to its type in the mutated (dark) map.
     *
     * @param colorType The type of the color.
     * @param color The color to be stored.
     */
    public void putDark(@Theme.ColorType int colorType, @ColorInt int color) {
        put(getDark(), colorType, color);
    }

    /**
     * Store the color according to its type in the mutated (light) map.
     *
     * @param colorType The type of the color.
     * @param color The color to be stored.
     */
    public void putLight(@Theme.ColorType int colorType, @ColorInt int color) {
        put(getLight(), colorType, color);
    }

    /**
     * Store the colors in the supplied map.
     *
     * @param colors The map to store the colors.
     * @param newColors The colors to be stored.
     */
    public void put(@NonNull Map<Integer, Integer> colors,
            @Nullable Map<Integer, Integer> newColors) {
        if (newColors == null) {
            return;
        }

        clear();
        colors.putAll(newColors);
    }

    /**
     * Store the colors in the original map.
     *
     * @param colors The colors to be stored.
     */
    public void putOriginal(@Nullable Map<Integer, Integer> colors) {
        put(getOriginal(), colors);
    }

    /**
     * Store the colors in the mutated (dark) map.
     *
     * @param colors The colors to be stored.
     */
    public void putDark(@Nullable Map<Integer, Integer> colors) {
        put(getDark(), colors);
    }

    /**
     * Store the colors in the mutated (light) map.
     *
     * @param colors The colors to be stored.
     */
    public void putLight(@Nullable Map<Integer, Integer> colors) {
        put(getLight(), colors);
    }

    /**
     * Store the wallpaper colors in the supplied map.
     *
     * @param colors The map to store the colors.
     * @param newColors The wallpaper colors to be stored.
     */
    @TargetApi(Build.VERSION_CODES.O_MR1)
    public void put(@NonNull Map<Integer, Integer> colors, @Nullable WallpaperColors newColors) {
        if (newColors == null) {
            return;
        }

        clear();

        colors.put(Theme.ColorType.ACCENT, newColors.getPrimaryColor().toArgb());

        if (newColors.getSecondaryColor() != null) {
            colors.put(Theme.ColorType.PRIMARY, newColors.getSecondaryColor().toArgb());
        } else {
            colors.put(Theme.ColorType.PRIMARY, newColors.getPrimaryColor().toArgb());
        }

        if (newColors.getTertiaryColor() != null) {
            colors.put(Theme.ColorType.BACKGROUND, newColors.getTertiaryColor().toArgb());
        } else {
            colors.put(Theme.ColorType.BACKGROUND, newColors.getPrimaryColor().toArgb());
        }
    }

    /**
     * Store the wallpaper colors in the original map.
     *
     * @param colors The wallpaper colors to be stored.
     */
    @TargetApi(Build.VERSION_CODES.O_MR1)
    public void putOriginal(@Nullable WallpaperColors colors) {
        put(getOriginal(), colors);
    }

    /**
     * Store the wallpaper colors in the mutated (dark) map.
     *
     * @param colors The wallpaper colors to be stored.
     */
    @TargetApi(Build.VERSION_CODES.O_MR1)
    public void putDark(@Nullable WallpaperColors colors) {
        put(getDark(), colors);
    }

    /**
     * Store the wallpaper colors in the mutated (light) map.
     *
     * @param colors The wallpaper colors to be stored.
     */
    @TargetApi(Build.VERSION_CODES.O_MR1)
    public void putLight(@Nullable WallpaperColors colors) {
        put(getLight(), colors);
    }

    /**
     * Mutate original colors for the supplied app theme.
     *
     * @param dark The map to store the mutated (dark) colors.
     * @param light The map to store the mutated (light) colors.
     * @param theme The dynamic theme to be used.
     */
    public void mutate(@NonNull Map<Integer, Integer> dark,
            @NonNull Map<Integer, Integer> light, @NonNull AppTheme<?> theme) {
        dark.clear();
        light.clear();

        @ColorInt int background = getOriginal(Theme.ColorType.BACKGROUND,
                theme.getBackgroundColor());
        @ColorInt int primary = getOriginal(Theme.ColorType.PRIMARY, theme.getPrimaryColor());
        @ColorInt int accent = getOriginal(Theme.ColorType.ACCENT, theme.getAccentColor());

        if (!getOriginal().containsKey(Theme.ColorType.PRIMARY)) {
            primary = background;
        }

        if (!getOriginal().containsKey(Theme.ColorType.ACCENT)) {
            accent = background;
        }

        put(dark, Theme.ColorType.BACKGROUND,
                DynamicColorUtils.getDarkerColor(background, FACTOR));
        put(dark, Theme.ColorType.SURFACE, Theme.AUTO);
        put(dark, Theme.ColorType.PRIMARY,
                DynamicColorUtils.getDarkerColor(primary, FACTOR));
        put(dark, Theme.ColorType.PRIMARY_DARK, Theme.AUTO);
        put(dark, Theme.ColorType.ACCENT, accent);
        put(dark, Theme.ColorType.ACCENT_DARK, Theme.AUTO);
        put(dark, Theme.ColorType.ERROR, Theme.AUTO);

        put(light, Theme.ColorType.BACKGROUND,
                DynamicColorUtils.getLighterColor(background, FACTOR));
        put(light, Theme.ColorType.SURFACE, Theme.AUTO);
        put(light, Theme.ColorType.PRIMARY,
                DynamicColorUtils.getLighterColor(primary, FACTOR));
        put(light, Theme.ColorType.PRIMARY_DARK, Theme.AUTO);
        put(light, Theme.ColorType.ACCENT, accent);
        put(light, Theme.ColorType.ACCENT_DARK, Theme.AUTO);
        put(light, Theme.ColorType.ERROR, Theme.AUTO);
    }

    /**
     * Mutate original colors for the supplied app theme.
     *
     * @param theme The dynamic theme to be used.
     */
    public void mutate(@NonNull AppTheme<?> theme) {
        mutate(getDark(), getLight(), theme);
    }

    /**
     * Returns all the colors including original, light and dark.
     *
     * @return All the colors including original, dark and light.
     */
    public @NonNull ArrayList<Integer> getAll() {
        ArrayList<Integer> colors = new ArrayList<>();


        for (int color : getOriginal().values()) {
            if (color != Theme.AUTO && !colors.contains(color)) {
                colors.add(color);
            }
        }
        for (int color : getDark().values()) {
            if (color != Theme.AUTO && !colors.contains(color)) {
                colors.add(color);
            }
        }
        for (int color : getLight().values()) {
            if (color != Theme.AUTO && !colors.contains(color)) {
                colors.add(color);
            }
        }

        return colors;
    }

    /**
     * Clear original and mutated colors.
     */
    public void clear() {
        getOriginal().clear();
        getDark().clear();
        getLight().clear();
    }
}
