package com.example.w01_wallpaper.ui.screen.home

sealed interface HomeScreenEvents {
    data object getCategory : HomeScreenEvents
    data class getWallpaper(val idCategory: Int) : HomeScreenEvents
}