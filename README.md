# Android Java reference

A reference Android project in Java for learning purposes.

Generated with ```Empty activity``` for ```API 21: Android 5.0 Lollipop```.

This repository will mirror the code in the repository ```android-kotlin-reference```.

# Notes

## General

* Android Jetpack extends on google's library for backward compatibility and packages starting
with ```androidx.*``` belong to Andorid Jetpack

* On 160 dpi screen, 1 dp == 1 pixel
    * on 480 dpi, 1 dp == 3 pixel
    
* The ```sp``` measurement for text size not only scaled by dpi of the screen, it is scaled by the
font size preference

# Layout

* XML files for describing layouts are placed in ```res/layout```

* Views - are the building blocks for building UI
    * ViewGroup subclass for layouts
    * other subclasses for widgets(buttons, text fields, images, etc)

* Linear layout
    * basic viewGroup for horizontal or vertical placement of views

* Constraint layout

## Gradle

* There is a top-level gradle script and there are gradle scripts for each of the sub-modules

* It is recommended to add additional dependencies for the app in its ```app``` submodule build script.

# Tips

* A good practice is to keep text data for UI in a separate file(for example in ```strings.xml```)

* A good practice is to keep dimensios of widgets in a separate file(for example in ```dimens.xml```)