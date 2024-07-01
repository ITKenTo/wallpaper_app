package com.example.data.remote

import com.example.data.remote.dto.CategoryResponse
import com.example.data.remote.dto.ThemeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperService {

    @GET("getcategory")
    suspend fun getCategories(): List<CategoryResponse>

    @GET("getthemebycategory")
    suspend fun getWallpaperThemes(@Query("id") categoryId: Int): List<ThemeResponse>


}