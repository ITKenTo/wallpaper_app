package com.example.w01_wallpaper.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.ThemeModel
import com.example.w01_wallpaper.R
import com.example.w01_wallpaper.ui.common.SearchBar
import com.example.w01_wallpaper.ui.screen.home.components.ImageSlider
import com.example.w01_wallpaper.ui.screen.home.view.CategorySelector
import com.example.w01_wallpaper.ui.screen.home.view.WallpaperView
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme

@Composable
fun HomeScreen(
    state: HomeScreenState, onEvent: (HomeScreenEvents) -> Unit,
    onNavigation: ((ThemeModel) -> Unit)? = null
) {

    LaunchedEffect(state.categories) {
        onEvent.invoke(HomeScreenEvents.getCategory)
        if (state.categories.isNotEmpty()) {
            onEvent.invoke(HomeScreenEvents.getWallpaper(state.categories[0].id))
        }
    }

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        SearchBar(
            modifier = Modifier.padding(top = 8.dp),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {}
        ) {
        }

        Spacer(modifier = Modifier.height(16.dp))

        ImageSlider()


        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.category),
                style = TextStyle(
                    color = colorResource(id = R.color.textColor),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                ),
                modifier = Modifier
                    .weight(1f)
                // Adjust weight for text width as needed
            )
            TextButton(
                onClick = {  },
                modifier = Modifier
            ) {
                Text(stringResource(R.string.view_all), color = colorResource(id = R.color.blue))
            }
        }

        CategorySelector(list = state.categories, categoryChange = {
            onEvent.invoke(HomeScreenEvents.getWallpaper(it))
        })

        Spacer(modifier = Modifier.height(16.dp))
        WallpaperView(list = state.wallpapers, themeChange = {
            onNavigation?.invoke(it)
        }, onLike = {})

    }
}


@Preview(showSystemUi = true)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    W01_WallpaperTheme {

//        HomeScreen()
    }
}