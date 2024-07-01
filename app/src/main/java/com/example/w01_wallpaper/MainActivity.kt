package com.example.w01_wallpaper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.w01_wallpaper.ui.common.extensions.hideNavigation
import com.example.w01_wallpaper.ui.navigation.NavGraph
import com.example.w01_wallpaper.ui.navigation.Route
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            W01_WallpaperTheme {
                Box(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                ) {
                    NavGraph(startDestination = Route.AppStartNavigation.route)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        hideNavigation()
    }
}