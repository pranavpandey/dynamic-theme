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

import android.graphics.Color;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.pranavpandey.android.dynamic.theme.base.AutoTheme;
import com.pranavpandey.android.dynamic.theme.base.BackgroundAware;
import com.pranavpandey.android.dynamic.theme.base.BaseTheme;
import com.pranavpandey.android.dynamic.theme.base.CodeTheme;
import com.pranavpandey.android.dynamic.theme.base.CornerTheme;
import com.pranavpandey.android.dynamic.theme.base.DynamicColor;
import com.pranavpandey.android.dynamic.theme.base.FallbackTheme;
import com.pranavpandey.android.dynamic.theme.base.ResourceTheme;
import com.pranavpandey.android.dynamic.theme.base.StringTheme;
import com.pranavpandey.android.dynamic.theme.base.StrokeTheme;
import com.pranavpandey.android.dynamic.theme.base.StyleTheme;
import com.pranavpandey.android.dynamic.theme.base.TextTheme;
import com.pranavpandey.android.dynamic.theme.base.TranslucentTheme;
import com.pranavpandey.android.dynamic.theme.base.TypeTheme;
import com.pranavpandey.android.dynamic.theme.util.DynamicThemeUtils;
import com.pranavpandey.android.dynamic.util.DynamicColorUtils;

/**
 * An abstract class to implement an app theme.
 *
 * @param <T> The type of the dynamic theme.
 */
public abstract class AppTheme<T extends AppTheme<T>> implements BaseTheme<T>, FallbackTheme<T>,
        ResourceTheme<T>, DynamicColor<T>, TextTheme<T>, AutoTheme<T>, CornerTheme<T>,
        BackgroundAware<T>, StrokeTheme<T>, TranslucentTheme<T>, StyleTheme<T>, TypeTheme<T>,
        StringTheme<T>, CodeTheme<T> {

    @Override
    public boolean isDynamicColor() {
        return getBackgroundColor(false, false) == Theme.AUTO
                || getPrimaryColor(false, false) == Theme.AUTO
                || getAccentColor(false, false) == Theme.AUTO;
    }

    @Override
    public boolean isStroke() {
        return DynamicColorUtils.removeAlpha(getBackgroundColor())
                == DynamicColorUtils.removeAlpha(getSurfaceColor())
                && Color.alpha(getSurfaceColor()) < Theme.Opacity.STROKE;
    }

    @Override
    public @NonNull String getThemeData() {
        return DynamicThemeUtils.getThemeUrl(this);
    }

    @Override
    public @NonNull String getCodeData() {
        return getThemeData();
    }

    @Override
    public @ColorInt int getCodeBackgroundColor() {
        return getBackgroundColor();
    }

    @Override
    public @ColorInt int getCodeStrokeColor() {
        return getStrokeColor();
    }

    @Override
    public @ColorInt int getCodeDataColor() {
        return getTintBackgroundColor();
    }

    @Override
    public @ColorInt int getCodeFinderColor() {
        return getPrimaryColor();
    }

    @Override
    public @ColorInt int getCodeOverlayColor() {
        return getAccentColor();
    }

    @Override
    public float getCodeContrastRatio() {
        return Math.max(Theme.Code.CONTRAST_RATIO, getContrastRatio());
    }

    @Override
    public @Theme.Code.Style int getCodeStyle() {
        return getCornerSizeDp() < Theme.Corner.MIN_ROUND
                ? Theme.Code.Style.DEFAULT : getCornerSizeDp() < Theme.Corner.MIN_OVAL
                ? Theme.Code.Style.ROUND : Theme.Code.Style.OVAL;
    }

    @Override
    public @NonNull String toJsonString() {
        return new Gson().toJson(this);
    }
}
