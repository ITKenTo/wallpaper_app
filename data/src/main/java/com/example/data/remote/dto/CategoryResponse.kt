package com.example.data.remote.dto

import androidx.annotation.Keep
import com.example.domain.model.CategoryModel
import com.google.gson.annotations.SerializedName

@Keep
data class CategoryResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val icon: String
) {
    fun convertCategoryModel(categoryResponse: CategoryResponse): CategoryModel {
        return CategoryModel(
            categoryResponse.id,
            categoryResponse.name,
            categoryResponse.icon
        )
    }
}