package com.example.w01_wallpaper.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.w01_wallpaper.R
import com.example.w01_wallpaper.ui.navigation.Route
import com.example.w01_wallpaper.ui.theme.background
import kotlinx.coroutines.delay

@Composable
fun LaunchScreen(
    navController: NavController,
    launchViewModel: LaunchViewModel,
    modifier: Modifier = Modifier
) {

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate(launchViewModel.startDestination.value) {
            popUpTo(Route.SplashScreen.route) { inclusive = true }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = "Splash Image",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )

        Spacer(modifier = Modifier.height(53.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.White)) {
                    append(stringResource(R.string.wallymax))
                }
                append(stringResource(R.string._4k_wallpapers))
            },
            fontSize = 24.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(95.dp))
        LoaderAnimation(
            modifier = Modifier.size(200.dp), anim = R.raw.loading
        )
    }
}

@Composable
fun LoaderAnimation(modifier: Modifier, anim: Int) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(anim))

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )
}
