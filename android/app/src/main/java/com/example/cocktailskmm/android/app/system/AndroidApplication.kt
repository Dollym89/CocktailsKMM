package com.example.cocktailskmm.android.app.system

import android.app.Application
import com.example.cocktailskmm.android.app.di.registerAndroidModules
import com.example.cocktailskmm.app.system.SharedApplication
import org.koin.android.ext.koin.androidContext

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        SharedApplication.init {
            androidContext(this@AndroidApplication)
            registerAndroidModules()
        }
    }
}
