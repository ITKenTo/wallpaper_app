package com.example.w01_wallpaper.ui.screen.new_navigator.components

import com.example.w01_wallpaper.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home_un_selected,
        icon_focused = R.drawable.ic_home_selected
    )

    // for report
    object Category : BottomBarScreen(
        route = "Category",
        title = "Category",
        icon = R.drawable.ic_category_un_selected,
        icon_focused = R.drawable.ic_category_selected
    )

    // for report
    object Setting : BottomBarScreen(
        route = "Setting",
        title = "Setting",
        icon = R.drawable.ic_setting_un_selected,
        icon_focused = R.drawable.ic_setting_selected
    )
}