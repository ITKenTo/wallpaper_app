package com.example.domain.manger

import com.example.domain.model.CategoryModel
import com.example.domain.model.ThemeModel
import com.example.domain.utils.Resources
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {
    suspend fun getCategory(): List<CategoryModel>

    suspend fun getWallpaper(idCategory: Int): Flow<Resources<List<ThemeModel>>>
}