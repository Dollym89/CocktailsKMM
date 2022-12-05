plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

apply<ModuleLibraryAndroid>()
apply<ConfigCompose>()

android {
    buildFeatures {
        viewBinding = true
    }
}

kotlin {
    sourceSets["commonMain"].dependencies {
        implementation(Module.library.koinKtx)
    }
    sourceSets["androidMain"].dependencies {
        api(Dependency.AndroidX.fragment)
        api(Dependency.AndroidX.recyclerView)
        api(Dependency.AndroidX.Lifecycle.viewModel)
        api(Dependency.AndroidX.material)
    }
}
