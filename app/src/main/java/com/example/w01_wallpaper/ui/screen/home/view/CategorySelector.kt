package com.example.w01_wallpaper.ui.screen.home.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.CategoryModel

@Composable
fun CategorySelector(list: List<CategoryModel>, categoryChange: ((Int) -> Unit)? = null) {
    var selectedCategory by remember {
        mutableIntStateOf(0)
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) { items(list.size) {
            ItemCategory(name = list[it].name, onItemClicked = {
                selectedCategory = it
                categoryChange?.invoke(list[it].id)
            }, selected = it == selectedCategory)
        }
    }
}

@Composable
fun ItemCategory(
    name: String,
    selected: Boolean = false,
    onItemClicked: (() -> Unit)? = null
) {
    Box(
        modifier = Modifier
            .background(
                if (selected) Color.Black else Color(0xFFF0F0F0),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 6.dp, horizontal = 10.dp)
            .clickable {
                onItemClicked?.invoke()
            }

    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge,
            color = if (selected) Color.White else Color.Black,
            fontSize = 18.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun ItemCategoryPreview() {
    ItemCategory(name = "All", true)
}