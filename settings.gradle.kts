pluginManagement {
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

rootProject.name = "CocktailsKMM"
include(":android:app")
include(":android:feature")
include(":android:generic")
include(":android:library")
include(":shared:app")
include(":shared:feature")
include(":shared:generic")
include(":shared:library")