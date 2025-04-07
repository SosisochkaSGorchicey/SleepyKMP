@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "SleepyKMP"

include(":composeApp")
include(":core:domain")
include(":core:data")
include(":core:common")
include(":core:navigation")
include(":core:ui")
include(":core:mvi")
include(":feature:initial")
