package com.example.w01_wallpaper.ui.screen.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.w01_wallpaper.R
import com.tbuonomo.viewpagerdotsindicator.compose.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.compose.model.DotGraphic
import com.tbuonomo.viewpagerdotsindicator.compose.type.ShiftIndicatorType
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(modifier: Modifier = Modifier) {
    val imageSlider = listOf(
        painterResource(id = R.drawable.walkthough_1),
        painterResource(id = R.drawable.walkthough_2),
        painterResource(id = R.drawable.walkthough_3)
    )
    val pagerState = rememberPagerState(pageCount = {
        imageSlider.size
    })

    val coroutineScope = rememberCoroutineScope()

    // Auto-sliding effect
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // Change slide every 3 seconds
            coroutineScope.launch {
                val nextPage = (pagerState.currentPage + 1) % imageSlider.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }

    Column(
        modifier = Modifier.wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = modifier
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Image(
                    painter = imageSlider[page],
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        DotsIndicator(
            dotCount = imageSlider.size,
            type = ShiftIndicatorType(dotsGraphic = DotGraphic(color = Color.Gray)),
            pagerState = pagerState,
            dotSpacing = 7.dp,
            modifier = Modifier.height(10.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    ImageSlider()
}