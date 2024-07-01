package com.example.w01_wallpaper.ui.screen.detail_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.w01_wallpaper.R
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme

@Composable
fun BottomBarScreen(
    onShare: (() -> Unit)? = null,
    onSetWallpaper: (() -> Unit)? = null,
    onLiked: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        ItemBottom(icon = R.drawable.ic_share, title = "Share", onClick = { onShare?.invoke() })
        Spacer(modifier = Modifier.width(24.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        onSetWallpaper?.invoke()
                    }
                    .background(
                        color = Color(0xFFF9F9F9),
                        shape = CircleShape
                    )
                    .padding(16.dp)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_set),
                    contentDescription = "like",
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Box(
                modifier = Modifier
                    .background(
                        Color.Black.copy(alpha = 0.4f),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(vertical = 4.dp, horizontal = 13.dp)
            ) {
                Text(text = "SET", fontSize = 12.sp, color = Color.White)
            }
        }
        Spacer(modifier = Modifier.width(24.dp))
        ItemBottom(icon = R.drawable.ic_like, title = "Favorite", onClick = { onLiked?.invoke() })
    }
}

@Composable
fun ItemBottom(
    onClick: (() -> Unit)? = null,
    icon: Int,
    title: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .padding(4.dp)
                .width(40.dp)
                .clickable {
                    onClick?.invoke()
                }
                .aspectRatio(1f)
                .background(
                    Color.Black.copy(alpha = 0.4f),
                    shape = CircleShape
                )
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "like",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .background(
                    Color.Black.copy(alpha = 0.4f),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(vertical = 4.dp, horizontal = 13.dp)
        ) {
            Text(text = title, fontSize = 12.sp, color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomBarScreenPreview() {
    W01_WallpaperTheme {
        BottomBarScreen()
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemPreview() {
    W01_WallpaperTheme {
        ItemBottom(onClick = {}, icon = R.drawable.ic_share, "Share")
    }
}