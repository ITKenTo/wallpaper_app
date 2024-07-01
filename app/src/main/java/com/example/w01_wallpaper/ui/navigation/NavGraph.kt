package com.example.w01_wallpaper.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

import com.example.w01_wallpaper.ui.screen.new_navigator.MainScreen
import com.example.w01_wallpaper.ui.screen.onboarding.OnBoardingScreen
import com.example.w01_wallpaper.ui.screen.onboarding.OnBoardingViewModel
import com.example.w01_wallpaper.ui.screen.splash.LaunchScreen
import com.example.w01_wallpaper.ui.screen.splash.LaunchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.SplashScreen.route
        ) {
            composable(route = Route.SplashScreen.route) {
                val viewModel: LaunchViewModel = hiltViewModel()
                LaunchScreen(navController, viewModel)
            }

            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent, navController)
            }

            composable(route = Route.MainScreen.route) {
                MainScreen()
            }
        }
    }
}