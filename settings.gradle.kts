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
include(":shared:generic:ingredients-database")
include(":shared:generic:network")
include(":shared:generic:storage")
include(":shared:library:activity")
include(":shared:library:architecture")
include(":shared:library:architecture-fixtures")
include(":shared:library:coroutines")
include(":shared:library:coroutines-fixtures")
include(":shared:library:koin-ktx")
include(":shared:library:logger")
include(":shared:library:logger-kermit")
include(":shared:library:logger-koin")
include(":shared:library:mvvm")
include(":shared:library:navigation")
include(":shared:feature:ingredient")
