package com.example.data.remote.dto

import androidx.annotation.Keep
import com.example.domain.model.ThemeModel
import com.google.gson.annotations.SerializedName

@Keep
data class ThemeResponse(
    @SerializedName("id")
    val id: Long,
    @SerializedName("thumbnail_theme")
    val thumbnailTheme: String,
    @SerializedName("path_theme")
    var url: String,
    @SerializedName("point")
    val gold: Int,
    @SerializedName("is_vip")
    val premium: Int,
    @SerializedName("category_id")
    val categoryId: Long,
    @SerializedName("is_video")
    val isVideo: Int,
) {
    companion object {
        fun convertThemeModel(themeResponse: ThemeResponse): ThemeModel {
            return ThemeModel(
                themeResponse.id,
                themeResponse.thumbnailTheme,
                themeResponse.url,
                themeResponse.gold,
                themeResponse.premium,
                themeResponse.categoryId,
                themeResponse.isVideo
            )
        }
    }
}