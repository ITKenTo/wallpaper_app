package com.example.data.manager

import android.app.WallpaperManager
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import coil.imageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.data.remote.WallpaperService
import com.example.data.remote.dto.ThemeResponse
import com.example.domain.manger.WallpaperRepository
import com.example.domain.model.CategoryModel
import com.example.domain.model.ThemeModel
import com.example.domain.utils.Resources
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class WallpaperRepositoryImpl(
    private val wallpaperService: WallpaperService
) : WallpaperRepository {

    override suspend fun getCategory(): List<CategoryModel> {
        return try {
            val result = wallpaperService.getCategories()
            if (result.isNotEmpty()) {
                result.map { category ->
                    category.convertCategoryModel(category)
                }
            } else {
                listOf()
            }
        } catch (error: Exception) {
            Log.d("ádsbds", "getCategory: ${error.message}")
            listOf()
        }
    }

    override suspend fun getWallpaper(idCategory: Int): Flow<Resources<List<ThemeModel>>> {
        return flow {

            emit(Resources.Loading(true))

            val remoteList = try {
                wallpaperService.getWallpaperThemes(idCategory)
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resources.Error("Could not load data"))
                null
            }

            if (remoteList == null) {
                emit(Resources.Loading(false))
            }

            remoteList.let { listing ->
                emit(Resources.Success(data = listing?.map { theme ->
                    ThemeResponse.convertThemeModel(
                        theme
                    )
                }))
                emit(Resources.Loading(false))
            }
        }
    }

    override suspend fun setWallpaper(
        context: Context,
        wallpaper: ThemeModel,
        width: Int,
        height: Int,
        option: Int
    ) {
        withContext(Dispatchers.IO) {
            val wallpaperManager = WallpaperManager.getInstance(context)
            var flag: Int? = null

            when (option) {
                1 -> flag =
                    WallpaperManager.FLAG_SYSTEM

                2 -> flag =
                    WallpaperManager.FLAG_LOCK
            }

            val request = ImageRequest.Builder(context)
                .data(wallpaper.url)
                .build()

            val result = (context.imageLoader.execute(request) as SuccessResult).drawable
            val bitmap = (result as BitmapDrawable).bitmap
            CoroutineScope(Dispatchers.IO).launch {
                if (flag == null) {
                    wallpaperManager.setBitmap(bitmap)
                } else {
                    wallpaperManager.setBitmap(bitmap, null, true, flag)
                }
            }

        }
    }
}