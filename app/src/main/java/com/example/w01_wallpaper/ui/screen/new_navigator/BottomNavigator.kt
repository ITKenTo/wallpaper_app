package com.example.w01_wallpaper.ui.screen.new_navigator

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.domain.model.ThemeModel
import com.example.w01_wallpaper.ui.navigation.Route
import com.example.w01_wallpaper.ui.screen.detail_screen.WallpaperDetail
import com.example.w01_wallpaper.ui.screen.home.HomeScreen
import com.example.w01_wallpaper.ui.screen.home.HomeViewModel
import com.example.w01_wallpaper.ui.screen.new_navigator.components.BottomBarScreen
import com.example.w01_wallpaper.ui.screen.setting.SettingScreen

@Composable
fun BottomNavigator(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route)
        {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel.state, onEvent = viewModel::onEvent) {
                navigateToDetails(navController, it)
            }
        }

        composable(route = Route.DetailWallpaperScreen.route)
        {
            val theme = getThemeNavigateToDetails(navController)
            theme?.let { themeModel ->
                WallpaperDetail(themeModel = themeModel, navController = navController)
            }
        }

        composable(route = BottomBarScreen.Category.route)
        {
//            ReportScreen()
        }
        composable(route = BottomBarScreen.Setting.route)
        {
            SettingScreen()
        }
    }
}

private fun navigateToDetails(navController: NavController, themeModel: ThemeModel) {
    navController.currentBackStackEntry?.savedStateHandle?.set("wallpaper", themeModel.toJson())
    navController.navigate(
        route = Route.DetailWallpaperScreen.route
    )
}

private fun getThemeNavigateToDetails(navController: NavController): ThemeModel? {
    val themModel =
        navController.previousBackStackEntry?.savedStateHandle?.get<String?>("wallpaper")
    return themModel?.let { ThemeModel.fromJson(it) }
}