plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

apply<ModuleLibraryAndroid>()

kotlin {
    sourceSets["commonMain"].dependencies {
        api(Dependency.Koin.core)
    }
    sourceSets["androidMain"].dependencies {
        api(Dependency.Koin.android)
        api(Dependency.Koin.compose)
    }
}