import java.util.Locale

object Dependency {

    object Detekt {
        const val version = "1.21.0"
        const val formatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$version"
    }

    object Kermit {
        const val version = "1.1.3"
        const val kermit = "co.touchlab:kermit:$version"
    }

    object Ktor {
        private const val version = "2.1.1"
        const val core = "io.ktor:ktor-client-core:$version"
        const val json = "io.ktor:ktor-client-json:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val serializationJson = "io.ktor:ktor-serialization-kotlinx-json:$version"

        const val auth = "io.ktor:ktor-client-auth:$version"
        const val websockets = "io.ktor:ktor-client-websockets:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val clientAndroid = "io.ktor:ktor-client-okhttp:$version"
        const val clientIos = "io.ktor:ktor-client-darwin:$version"
    }

    object Coroutines {
        private const val version = "1.6.4"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Koin {
        private const val version = "3.1.6"
        private const val composeVersion = "3.1.6"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$composeVersion"
        fun core(target: String) = "io.insert-koin:koin-core-${arch(target)}:$version"
    }

    object SqlDelight {
        private const val version = "1.5.3"
        const val runtime = "com.squareup.sqldelight:runtime:$version"
        const val coroutines = "com.squareup.sqldelight:coroutines-extensions:$version"
        const val android = "com.squareup.sqldelight:android-driver:$version"
        const val ios = "com.squareup.sqldelight:native-driver:$version"
    }

    object Serialization {
        private const val version = "1.3.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-serialization-core:$version"
        const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
    }

    object DateTime {
        private const val version = "0.4.0"
        const val core = "org.jetbrains.kotlinx:kotlinx-datetime:$version"
        fun core(target: String) = "org.jetbrains.kotlinx:kotlinx-datetime-${arch(target)}:$version"
    }

    const val krypto = "com.soywiz.korlibs.krypto:krypto:2.2.0"

    object JUnit {
        const val core = "junit:junit:4.13.2"
        const val params = "pl.pragmatists:JUnitParams:1.1.1"
    }

    const val kotest = "io.kotest:kotest-assertions-core-jvm:5.4.0"
    const val mockk = "io.mockk:mockk:1.13.2"

    const val commons = "org.apache.commons:commons-lang3:3.12.0"
    const val codec = "commons-codec:commons-codec:1.15"
    const val okhttp = "com.squareup.okhttp3:okhttp:4.10.0"
    const val dfu = "no.nordicsemi.android:dfu:2.2.0"

    object AndroidX {
        const val biometric = "androidx.biometric:biometric:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val fragment = "androidx.fragment:fragment-ktx:1.5.2"
        const val material = "com.google.android.material:material:1.6.1"
        const val preference = "androidx.preference:preference:1.2.0"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"
        const val work = "androidx.work:work-runtime-ktx:2.7.1"

        object Lifecycle {
            private const val version = "2.5.1"
            const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        }

        object Navigation {
            private const val version = "2.5.2"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val compose = "androidx.navigation:navigation-compose:$version"
        }
    }

    object Compose {
        const val kotlinCompilerVersion = "1.3.1"
        private const val version = "1.2.1"
        const val accompanistVersion = "0.25.1"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val material = "androidx.compose.material:material:$version"
        const val materialIconsCore = "androidx.compose.material:material-icons-core:$version"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$version"
        const val materialThemeAdapter = "com.google.android.material:compose-theme-adapter:1.1.18"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
        const val ui = "androidx.compose.ui:ui:$version"
        const val accompanist =
            "com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion"
        const val accompanistInsets =
            "com.google.accompanist:accompanist-insets:$accompanistVersion"
    }

    object Firebase {
        const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx:18.2.13"
        const val analytics = "com.google.firebase:firebase-analytics-ktx:21.1.1"
        const val core = "com.google.firebase:firebase-core:21.1.1"
        const val messaging = "com.google.firebase:firebase-messaging:23.0.8"
        const val config = "com.google.firebase:firebase-config:21.1.2"
        const val perf = "com.google.firebase:firebase-perf:20.1.1"
    }

    const val playServices = "com.google.android.gms:play-services-location:20.0.0"

    object MapBox {
        const val sdk = "com.mapbox.mapboxsdk:mapbox-android-sdk:9.3.0"
        const val annotation = "com.mapbox.mapboxsdk:mapbox-android-plugin-annotation-v9:0.9.0"
        const val telemetry = "com.mapbox.mapboxsdk:mapbox-android-telemetry:6.1.0"
    }

    object Test {
        const val turbine = "app.cash.turbine:turbine:0.11.0"
    }

    // TODO remove once not used
    const val circularprogress = "com.github.rahatarmanahmed:circularprogressview:2.5.0"
    const val pdfview = "com.dmitryborodin:pdfview-android:1.1.0"
    const val screenshotty = "eu.bolt:screenshotty:1.0.4"

    private fun arch(target: String) = target.toLowerCase(Locale.ROOT)

}
