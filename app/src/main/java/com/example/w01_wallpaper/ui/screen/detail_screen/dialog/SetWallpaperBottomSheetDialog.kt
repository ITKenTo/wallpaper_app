package com.example.w01_wallpaper.ui.screen.detail_screen.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.w01_wallpaper.ui.theme.W01_WallpaperTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperSheetDialog(
    modifier: Modifier = Modifier,
    isBottomSheetVisible: Boolean,
    onDismiss: () -> Unit
) {
    if (isBottomSheetVisible) {
        val sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        )

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RectangleShape,
            dragHandle = null,
            scrimColor = Color.Black.copy(alpha = .5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {

            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
private fun PreViewWallpaper() {
    W01_WallpaperTheme {
        WallpaperSheetDialog(
            isBottomSheetVisible = true,
            onDismiss = {}
        )
    }
}