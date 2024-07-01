package com.example.data.manager

import android.util.Log
import com.example.data.remote.WallpaperService
import com.example.data.remote.dto.ThemeResponse
import com.example.domain.manger.WallpaperRepository
import com.example.domain.model.CategoryModel
import com.example.domain.model.ThemeModel
import com.example.domain.utils.Resources
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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
                emit(Resources.Success(data = listing?.map { theme -> ThemeResponse.convertThemeModel(theme) }))
                emit(Resources.Loading(false))
            }
        }
    }


}