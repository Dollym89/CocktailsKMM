package com.example.cocktailskmm.android.app.system

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import clv.library.navigation.system.NavigationActivityDelegate
import com.example.ingredient.cocktailskmm.data.IngredientsApi
import com.example.network.data.networkCall
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val lifecycle: MainActivityLifecycle by inject()
    private val navigationDelegate: NavigationActivityDelegate by inject()
    private val api: IngredientsApi by inject()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(lifecycle.onCreate(savedInstanceState))
        val result = api
        lifecycleScope.launch {
            networkCall {
                result.downloadIngredients()
            }
        }
        setContent {
            Scaffold {
                Column(modifier = Modifier.padding(it)) {
                    Text("TEXT TO SHOW")
                }
            }
        }
    }


    override fun onStart() {
        super.onStart()
        navigationDelegate.onStart(this)
    }

    override fun onStop() {
        navigationDelegate.onStop()
        super.onStop()
    }
}
