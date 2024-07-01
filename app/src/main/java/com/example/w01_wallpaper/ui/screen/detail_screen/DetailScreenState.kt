package com.example.w01_wallpaper.ui.screen.detail_screen

import com.example.domain.model.CategoryModel
import com.example.domain.model.ThemeModel

data class DetailScreenState(
    val categories: List<CategoryModel> = emptyList(),
    val wallpapers : List<ThemeModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = "null"
)