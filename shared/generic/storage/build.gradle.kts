plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("com.squareup.sqldelight")
}

apply<ModuleGeneric>()

kotlin {
    android()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Module.library.logger)
                implementation(Dependency.SqlDelight.runtime)
                implementation(Dependency.SqlDelight.coroutines)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Dependency.SqlDelight.androidDriver)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(Dependency.SqlDelight.iosDriver)
            }
        }

    }
}

sqldelight {
    database("IngredientsDatabase") {
        packageName = "com.cocktails"
        sourceFolders = listOf("ingredients-db")
    }
}
