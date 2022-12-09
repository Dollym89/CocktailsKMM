package com.example.cocktailskmm.android.app.di

import clv.library.koin.di.singleOf
import com.example.cocktailskmm.android.app.system.MainActivityLifecycle
import org.koin.dsl.module

internal val androidModule = module {
//    singleOf(::buildType)
//    singleOf(::applicationVersion)
    singleOf(::MainActivityLifecycle)
}

// internal fun buildType(): BuildType = when (BuildConfig.BUILD_TYPE) {
//    "debug" -> BuildType.DEBUG
//    "staging" -> BuildType.STAGING
//    else -> BuildType.RELEASE
// }

// internal fun applicationVersion(): ApplicationVersion = AndroidApplicationVersion(
//    code = BuildConfig.VERSION_CODE.toString(),
//    name = BuildConfig.VERSION_NAME,
// )
