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
include(":ios:app")
include(":ios:integration")
include(":shared:app")
include(":shared:feature")
include(":shared:generic")
include(":shared:library:architecture")
include(":shared:library:architecture-fixtures")
include(":shared:library:coroutines")
include(":shared:library:coroutines-fixtures")
include(":shared:library:koin-ktx")
include(":shared:library:mvvm")