package com.example.w01_wallpaper.ui.screen.home.view

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.model.ThemeModel
import com.example.w01_wallpaper.R
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme

@Composable
fun WallpaperView(
    list: List<ThemeModel>,
    themeChange: ((ThemeModel) -> Unit)? = null,
    onLike: (() -> Unit)?
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(list) { index, item ->
            ItemWallpaper(
                item,
                onLike = { onLike?.invoke() },
                onTheme = { themeChange?.invoke(item) }
            )
        }
    }
}


@Composable
fun ItemWallpaper(
    themeModel: ThemeModel,
    onLike: (() -> Unit)?,
    onTheme: ((ThemeModel) -> Unit)?
) {

    val showShimmer = remember { mutableStateOf(true) }

    Box(modifier = Modifier.clickable {
        onTheme?.invoke(themeModel)
    }) {
        AsyncImage(
            model = themeModel.url,
            contentDescription = themeModel.url,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(shimmerBrush(targetValue = 1300f, showShimmer = showShimmer.value))
                .aspectRatio(0.56f)
                .clip(RoundedCornerShape(16.dp)),
            onSuccess = { showShimmer.value = false },
        )

        Box(
            modifier = Modifier
                .padding(4.dp)
                .width(40.dp)
                .clickable {
                    onLike?.invoke()
                }
                .aspectRatio(1f)
                .align(Alignment.BottomStart)
                .background(
                    Color.Black.copy(alpha = 0.2f),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_like),
                contentDescription = "like",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun shimmerBrush(showShimmer: Boolean = true, targetValue: Float = 1000f): Brush {
    return if (showShimmer) {
        val shimmerColors = listOf(
            Color.LightGray.copy(alpha = 0.6f),
            Color.LightGray.copy(alpha = 0.2f),
            Color.LightGray.copy(alpha = 0.6f),
        )

        val transition = rememberInfiniteTransition()
        val translateAnimation = transition.animateFloat(
            initialValue = 0f,
            targetValue = targetValue,
            animationSpec = infiniteRepeatable(
                animation = tween(800), repeatMode = RepeatMode.Reverse
            ), label = "njhj"
        )
        Brush.linearGradient(
            colors = shimmerColors,
            start = Offset.Zero,
            end = Offset(x = translateAnimation.value, y = translateAnimation.value)
        )
    } else {
        Brush.linearGradient(
            colors = listOf(Color.Transparent, Color.Transparent),
            start = Offset.Zero,
            end = Offset.Zero
        )
    }
}

@Preview
@Composable
private fun Wallpaperpreview() {
    W01_WallpaperTheme {
//        ItemWallpaper(
//            themeModel = "https://i.pinimg.com/236x/6e/73/0e/6e730e6a8a788b8559502a6d6df6bfcf.jpg",
//            onLike = {})
    }
}