package com.example.w01_wallpaper.ui.screen.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.manger.WallpaperRepository
import com.example.domain.utils.Resources
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val wallpaperRepository: WallpaperRepository
) : ViewModel() {

    var state by mutableStateOf(HomeScreenState())
        private set

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.getCategory -> {
                getCategories()
            }

            is HomeScreenEvents.getWallpaper -> {
                getWallpaper(event.idCategory)
            }

            else -> {}
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            try {
                state = state.copy(isLoading = true)
                val result = wallpaperRepository.getCategory()
                Log.d("ádsbds", "getCategories: $result")
                result?.let {
                    state = state.copy(categories = it)
                }
            } catch (_: Exception) {
//                state = state.copy(error = e.message)
            }
        }
    }

    private fun getWallpaper(idCategory: Int) {
        viewModelScope.launch {
            wallpaperRepository.getWallpaper(idCategory).collect { result ->
                when (result) {
                    is Resources.Loading -> {
                        state = state.copy(isLoading = result.isLoading)
                    }

                    is Resources.Success -> {
                        println("Data in View model  ${result.data}")
                        val listWallpaper = result.data?.filter { it.isVideo == 0 }
                        listWallpaper?.let { listings ->
                            state = state.copy(
                                wallpapers = listings
                            )
                        }
                    }

                    is Resources.Error -> {
                        state = state.copy(isLoading = false)
                    }
                }
            }
        }
    }
}