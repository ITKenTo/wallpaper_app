package com.example.w01_wallpaper.ui.screen.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.domain.model.ThemeModel
import com.example.w01_wallpaper.R
import com.example.w01_wallpaper.ui.screen.detail_screen.components.BottomBarScreen
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme

@Composable
fun WallpaperDetail(
    themeModel: ThemeModel,
    navController: NavController
) {
    Column {
        ImageScreen(themeModel, navController)
    }
}


@Composable
fun ImageScreen(
    themeModel: ThemeModel,
    navController: NavController
) {
    Box {
        AsyncImage(
            model = themeModel.url,
            contentDescription = themeModel.url,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radiusX = 15.dp,
                    radiusY = 15.dp,
                ),
        )
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 26.dp, start = 24.dp)
                    .clickable {
                        navController.navigateUp()
                    }
                    .size(32.dp)
            )

            Box(
                modifier = Modifier
                    .padding(top = 16.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
            ) {
                AsyncImage(
                    model = themeModel.url,
                    contentDescription = themeModel.url,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(20.dp))
                )

                BottomBarScreen(
                    onLiked = {},
                    onShare = {},
                    onSetWallpaper = {},
                    modifier = Modifier
                        .align(
                            Alignment.BottomCenter
                        )
                        .padding(bottom = 20.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetailPreview() {
    W01_WallpaperTheme {
//        ImageScreen()
    }
}