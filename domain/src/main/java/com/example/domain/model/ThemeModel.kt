package com.example.domain.model

import com.google.gson.Gson

data class ThemeModel(
    val id: Long,
    val thumbnailTheme: String,
    var url: String,
    val gold: Int,
    val premium: Int,
    val categoryId: Long,
    val isVideo: Int
) {

    companion object {
        fun fromJson(json: String): ThemeModel {
            return Gson().fromJson(json, ThemeModel::class.java)
        }
    }

    fun toJson(): String {
        return Gson().toJson(this)
    }

    fun isVipType(): Boolean {
        return isVideo == 1
    }

    fun isCoins(): Boolean {
        return gold != 0
    }
}