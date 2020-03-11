<img src="https://raw.githubusercontent.com/pranavpandey/dynamic-theme/master/graphics/dynamic-theme.png" width="160" height="160" align="right" hspace="20">

# Dynamic Theme

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/pranavpandey/dynamic-theme.svg?branch=master)](https://travis-ci.org/pranavpandey/dynamic-theme)
[![Download](https://api.bintray.com/packages/pranavpandey/android/dynamic-theme/images/download.svg)](https://bintray.com/pranavpandey/android/dynamic-theme/_latestVersion)

A text (JSON) based theme engine for apps supporting Android 4.0 (API 14) and above devices.

> It uses [AndroidX](https://developer.android.com/jetpack/androidx/) so, first
[migrate](https://developer.android.com/jetpack/androidx/migrate) your project to AndroidX.

<img src="https://raw.githubusercontent.com/pranavpandey/dynamic-theme/master/graphics/dynamic-theme-preview.png">

```
{
  "backgroundColor": "#252525",
  "tintBackgroundColor": "auto",
  "surfaceColor": "auto",
  "tintSurfaceColor": "auto",
  "primaryColor": "#FF9933",
  "tintPrimaryColor": "auto",
  "primaryColorDark": "auto",
  "tintPrimaryColorDark": "auto",
  "accentColor": "#8BC34A",
  "tintAccentColor": "auto",
  "accentColorDark": "auto",
  "tintAccentColorDark": "auto",
  "textPrimaryColor": "auto",
  "textPrimaryColorInverse": "auto",
  "textSecondaryColor": "auto",
  "textSecondaryColorInverse": "auto",
  "fontScale": "auto",
  "cornerRadius": "auto",
  "backgroundAware": "auto"
}
```

---

## Contents

- [Format](https://github.com/pranavpandey/dynamic-theme#format)
- [Installation](https://github.com/pranavpandey/dynamic-theme#installation)
- [Usage](https://github.com/pranavpandey/dynamic-theme#usage)
    - [Dependency](https://github.com/pranavpandey/dynamic-theme#dependency)
    - [Proguard](https://github.com/pranavpandey/dynamic-theme#proguard)
- [Palettes](https://github.com/pranavpandey/dynamic-theme#palettes)
- [License](https://github.com/pranavpandey/dynamic-theme#license)

---

## Format

A dynamic theme can be represented as a `JSON`, `URL` or a `File` with `.theme` extension 
containing the JSON text. Use the Palettes app for Android to create or share the dynamic themes 
in various formats. However, the most suitable way is to share it via a URL that can be imported 
easily on various platforms.

### JSON

A `JSON` is the original format for the dynamic theme that provides cross-app functionality.

```json
{
  "backgroundColor": "auto|color",
  "tintBackgroundColor": "auto|color",
  "surfaceColor": "auto|color",
  "tintSurfaceColor": "auto|color",
  "primaryColor": "auto|color",
  "tintPrimaryColor": "auto|color",
  "primaryColorDark": "auto|color",
  "tintPrimaryColorDark": "auto|color",
  "accentColor": "auto|color",
  "tintAccentColor": "auto|color",
  "accentColorDark": "auto|color",
  "tintAccentColorDark": "auto|color",
  "textPrimaryColor": "auto|color",
  "textPrimaryColorInverse": "auto|color",
  "textSecondaryColor": "auto|color",
  "textSecondaryColorInverse": "auto|color",
  "fontScale": "auto|integer",
  "cornerRadius": "auto|integer",
  "backgroundAware": "auto|disable|enable",
  "header": "auto|hide|show",
  "opacity": "auto|integer"
}
```

### URL

A `URL` is the short representation of the theme `JSON` that can be shared on the platforms 
having a character limit like Twitter. This is the most suitable way to share a dynamic theme that 
can be imported easily in various apps or platforms.

#### Mappings

| JSON                      | URL | 
| :------------------------ | --- |
| {,}                       |     |
| ""                        |     |
| Split (Key)               | -   |
| Dark                      | Z   |
| Inverse                   | Z   |
| backgroundColor           | 0   |
| tintBackgroundColor       | 1   |
| surfaceColor              | 2   |
| tintSurfaceColor          | 3   |
| primaryColor              | 4   |
| tintPrimaryColor          | 5   |
| primaryColorDark          | 4Z  |
| tintPrimaryColorDark      | 7   |
| accentColor               | 8   |
| tintAccentColor           | 9   |
| accentColorDark           | 8Z  |
| tintAccentColorDark       | 11  |
| textPrimaryColor          | 12  |
| textPrimaryColorInverse   | 12Z |
| textSecondaryColor        | 14  | 
| textSecondaryColorInverse | 14Z |
| fontScale                 | 16  |
| cornerRadius              | 17  |
| backgroundAware           | 18  |
| header                    | 19  |
| opacity                   | 20  |

#### Values

| JSON          | URL | 
| :-------------| --- |
| Split (Value) | v   |
| #             | X   |
| auto          | A   |
| disable       | D   |
| enable        | E   |
| hide          | H   |
| show          | S   |

### File

A `File` with `.theme` extension containing the JSON text. Currently, it is possible to export 
or import a dynamic theme file on the Android (Java) platform.

---

## Installation

It can be installed by adding the following dependency to your `build.gradle` file:

```groovy
dependencies {
    // For AndroidX enabled projects.
    implementation 'com.pranavpandey.android:dynamic-theme:1.1.0'
}
```

---

## Usage

It can be used in raw JSON format or can be implemented on the Android (Java) platform.

> For complete reference, please read the [documentation](https://pranavpandey.github.io/dynamic-theme).

### Android (Java)

Just implement the [AppTheme][app theme] or [AppWidgetTheme][app widget theme] to create a 
dynamic theme. A possible implementation can be found [here][theme implementation].

```java
public class DynamicAppTheme implements AppTheme<DynamicAppTheme> {
    
    ...
    
    @Override
    public @StyleRes int getThemeRes() {
        return themeRes;
    }

    @Override
    public @NonNull DynamicAppTheme setThemeRes(@StyleRes int themeRes) {
        this.themeRes = themeRes;

        return this;
    }

    ...

    @Override
    public @NonNull String toJsonString() {
        return new Gson().toJson(new DynamicAppTheme(this));
    }

    @Override
    public @NonNull String toDynamicString() {
        return new GsonBuilder().setExclusionStrategies(new ExcludeStrategy())
                .registerTypeAdapter(DynamicAppTheme.class, new DynamicThemeTypeAdapter<>())
                .setPrettyPrinting().create().toJson(new DynamicAppTheme(this));
    }
}
```

### Dependency

It depends on the [dynamic-utils](https://github.com/pranavpandey/dynamic-utils) to perform
various internal operations. So, its functions can also be used to perform other useful operations.

### Proguard

This library uses [Gson](https://github.com/google/gson) and has custom strategy to process the 
theme data. It will automatically apply the appropriate rules if proguard is enabled in the 
project.

The following rules will be applied by this library:

```yml
# Gson uses generic type information stored in a class file when working with fields.
# Proguard removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using Gson annotation.
-keepattributes *Annotation*

# Gson specific classes.
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** { *; }
```

---

## Palettes

Palettes is a universal manager for apps supporting the dynamic theme on Android. 
It provides some default configurations that can be extended to create custom ones. 
Let's give it a try to explore its other useful features.

- A collection of theme presets that can be applied in the supported apps.
- Extend them to create custom ones according to the requirement.
- Preview them natively in the supported apps and widgets.
- Experimental option to enable dark mode in devices that don't have a system setting.

[Palettes - Theme Manager](https://play.google.com/store/apps/details?id=com.pranavpandey.theme)

---

## Author

Pranav Pandey

[![GitHub](https://img.shields.io/github/followers/pranavpandey?label=GitHub&style=social)](https://github.com/pranavpandey)
[![Follow on Twitter](https://img.shields.io/twitter/follow/pranavpandeydev?label=Follow&style=social)](https://twitter.com/intent/follow?screen_name=pranavpandeydev)
[![Donate via PayPal](https://img.shields.io/static/v1?label=Donate&message=PayPal&color=blue)](https://paypal.me/pranavpandeydev)

---

## License

    Copyright 2019-2020 Pranav Pandey

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    
[app theme]: https://github.com/pranavpandey/dynamic-theme/blob/master/dynamic-theme/src/main/java/com/pranavpandey/android/dynamic/theme/AppTheme.java
[app widget theme]: https://github.com/pranavpandey/dynamic-theme/blob/master/dynamic-theme/src/main/java/com/pranavpandey/android/dynamic/theme/AppWidgetTheme.java
[theme implementation]: https://github.com/pranavpandey/dynamic-support/blob/master/dynamic-support/src/main/java/com/pranavpandey/android/dynamic/support/model/DynamicAppTheme.java
