import java.util.Locale

@Suppress("SpellCheckingInspection")
object Dependency {

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
        const val core = "androidx.core:core-ktx:1.7.0"
        const val crypto = "androidx.security:security-crypto:1.1.0-alpha03"
        const val flexbox = "com.google.android.flexbox:flexbox:3.0.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.5.2"

        object Lifecycle {
            private const val version = "2.5.1"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        const val material = "com.google.android.material:material:1.6.1"

        object Navigation {
            private const val version = "2.5.2"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        }

        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"

        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
    }

    const val archUnit = "com.tngtech.archunit:archunit-junit4:0.23.1"

    object Compose {
        const val kotlinCompilerVersion = "1.3.0"
        private const val version = "1.3.0"
        val compiler = "androidx.compose.compiler:compiler:$version"

        val activity = "androidx.activity:activity-compose:1.6.1"
        val animationGraphics = "androidx.compose.animation:animation-graphics:$version"
        val foundation = "androidx.compose.foundation:foundation:$version"
        val icons = "androidx.compose.material:material-icons-core:$version"
        val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
        val material = "androidx.compose.material:material:$version"
        val runtime = "androidx.compose.runtime:runtime:$version"
        val systemUI = "com.google.accompanist:accompanist-systemuicontroller:0.25.1"
        val tooling = "androidx.compose.ui:ui-tooling:$version"
        val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        val ui = "androidx.compose.ui:ui:$version"
    }

    object Camerax {
        private const val version = "1.1.0-beta03"
        val camera = "androidx.camera:camera-camera2:$version"
        val lifeCycle = "androidx.camera:camera-lifecycle:$version"
        val view = "androidx.camera:camera-view:$version"
    }

    object Coroutines {
        private const val version = "1.6.1-native-mt"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"

        object Binding {
            private const val version = "1.5.5"
            const val appcompat = "ru.ldralighieri.corbind:corbind-appcompat:$version"
            const val viewpager = "ru.ldralighieri.corbind:corbind-viewpager2:$version"
            const val material = "ru.ldralighieri.corbind:corbind-material:$version"
        }
    }

    object SqlDelight {
        private const val version = "1.5.3"
        const val coroutines = "com.squareup.sqldelight:coroutines-extensions:$version"
        const val androidDriver = "com.squareup.sqldelight:android-driver:$version"
        const val iosDriver = "com.squareup.sqldelight:native-driver:$version"
    }

    object DateTime {
        private const val version = "0.4.0"
        const val core = "org.jetbrains.kotlinx:kotlinx-datetime:$version"
        fun core(target: String) = "org.jetbrains.kotlinx:kotlinx-datetime-${arch(target)}:$version"
    }

    object JUnit {
        const val runtime = "junit:junit:4.13.2"
        const val params = "pl.pragmatists:JUnitParams:1.1.1"
    }

    const val kermit = "co.touchlab:kermit:1.1.3"

    object Ktor {
        private const val version = "1.6.7"

        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"

        object Engine {
            const val android = "io.ktor:ktor-client-okhttp:$version"
            const val ios = "io.ktor:ktor-client-ios:$version"
        }
    }

    object Koin {
        private const val version = "3.1.5"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
        const val core = "io.insert-koin:koin-core:$version"
        const val test = "io.insert-koin:koin-test:$version"
        fun core(target: String) = "io.insert-koin:koin-core-${arch(target)}:$version"
    }

    object Kotest {
        private const val version = "5.3.0"
        const val assertions = "io.kotest:kotest-assertions-core-jvm:$version"
    }

    object LeakCanary {
        private const val version = "2.9.1"
        const val detector = "com.squareup.leakcanary:leakcanary-android:$version"
        const val plumber = "com.squareup.leakcanary:plumber-android:$version"
    }

    object Mockk {
        private const val version = "1.12.3"
        const val android = "io.mockk:mockk-android:$version"
        const val kotlin = "io.mockk:mockk:$version"
    }

    const val okHttp = "com.squareup.okhttp3:okhttp:4.9.3"

    object Serialization {
        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0"
    }

    object Settings {
        private const val version = "0.9"
        const val core = "com.russhwolf:multiplatform-settings:$version"
        const val coroutines = "com.russhwolf:multiplatform-settings-coroutines-native-mt:$version"
        const val test = "com.russhwolf:multiplatform-settings-test:$version"
    }

    private fun arch(target: String) = target.toLowerCase(Locale.ROOT)
}