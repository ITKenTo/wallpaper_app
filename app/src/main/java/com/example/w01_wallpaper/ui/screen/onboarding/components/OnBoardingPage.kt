package com.example.w01_wallpaper.ui.screen.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.w01_wallpaper.R
import com.example.w01_wallpaper.ui.screen.onboarding.Page
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme
import com.example.w01_wallpaper.ui.theme.background
import com.example.w01_wallpaper.utils.Dimens.MediumPadding1
import com.example.w01_wallpaper.utils.Dimens.MediumPadding2

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page,
) {
    Column(modifier = modifier.background(background)) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
            ,
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.description,
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    W01_WallpaperTheme {
        OnBoardingPage(
            page = Page(
            title = "Lorem Ipsum is simply dummy",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            image = R.drawable.walkthough_1
        )
        )
    }
}












