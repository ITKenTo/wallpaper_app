package com.example.w01_wallpaper.ui.screen.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
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
import com.example.domain.model.ThemeModel
import com.example.w01_wallpaper.R
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme

@Composable
fun WallpaperDetail(
    themeModel: ThemeModel,
    navController: NavController
) {
    Column {
        ImageScreen()
    }
}


@Composable
fun ImageScreen() {

    Box {
        Image(
            painter = painterResource(id = R.drawable.wallpaper_demo),
            contentDescription = "bádsasjdhsa",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .blur(
                    radiusX = 10.dp,
                    radiusY = 10.dp,
                ),
        )
        Image(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 26.dp, start = 24.dp)
                .clickable {
//                    navController.navigateUp()
                }
                .size(32.dp)
                .align(Alignment.TopStart)
        )

        Image(
            painter = painterResource(id = R.drawable.wallpaper_demo),
            contentDescription = "bádsasjdhsa",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(top = 40.dp, start = 30.dp, end = 30.dp, bottom = 10.dp)
                .aspectRatio(0.49f)
                .clip(shape = RoundedCornerShape(20.dp))
                .align(Alignment.Center)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun DetailPreview() {
    W01_WallpaperTheme {
        ImageScreen()
    }
}