package com.example.w01_wallpaper.ui.navigation

/*
import androidx.navigation.NamedNavArgument
*/

sealed class Route(
    val route: String,
) {
    object AppStartNavigation : Route(route = "appStartNavigation")

    object SplashScreen : Route(route = "splashScreen")

    object OnBoardingScreen : Route(route = "onBoardingScreen")

    object HomeScreen : Route(route = "HomeScreen")

    object DetailWallpaperScreen : Route(route = "DetailWallpaperScreen")

    object MainScreen : Route(route = "MainScreen")
}

