<img src="https://raw.githubusercontent.com/pranavpandey/dynamic-theme/master/graphics/dynamic-theme.png" width="160" height="160" align="right" hspace="20">

# Dynamic Theme

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Build Status](https://travis-ci.org/pranavpandey/dynamic-theme.svg?branch=master)](https://travis-ci.org/pranavpandey/dynamic-theme)
[![Download](https://api.bintray.com/packages/pranavpandey/android/dynamic-theme/images/download.svg)](https://bintray.com/pranavpandey/android/dynamic-theme/_latestVersion)

A text (JSON) based theme engine for apps supporting Android 4.0 (API 14) and above devices.

> It uses [AndroidX](https://developer.android.com/jetpack/androidx/) so, first
[migrate](https://developer.android.com/jetpack/androidx/migrate) your project to AndroidX.

---

## Contents

- [Installation](https://github.com/pranavpandey/dynamic-theme#installation)
- [Usage](https://github.com/pranavpandey/dynamic-theme#usage)
    - [Dependency](https://github.com/pranavpandey/dynamic-theme#dependency)
    - [Proguard](https://github.com/pranavpandey/dynamic-theme#proguard)
- [License](https://github.com/pranavpandey/dynamic-theme#license)

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

> For complete reference, please read the [documentation](https://pranavpandey.github.io/dynamic-theme).

---

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

## Author

Pranav Pandey

[![GitHub](https://img.shields.io/github/followers/pranavpandey?label=GitHub&style=social)](https://github.com/pranavpandey)
[![Follow on Twitter](https://img.shields.io/twitter/follow/pranavpandeydev?label=Follow&style=social)](https://twitter.com/intent/follow?screen_name=pranavpandeydev)
[![Donate via PayPal](https://img.shields.io/static/v1?label=Donate&message=PayPal&color=blue)](https://paypal.me/pranavpandeydev)

---

## License

    Copyright 2019 Pranav Pandey

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
