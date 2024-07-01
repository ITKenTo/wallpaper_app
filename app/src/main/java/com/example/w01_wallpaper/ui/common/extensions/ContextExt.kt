package com.example.w01_wallpaper.ui.common.extensions

import android.app.Activity
import android.view.View

fun Activity.hideNavigation() {
    try {
        val decorView = window.decorView
        val uiOptions =
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        decorView.systemUiVisibility = uiOptions
    } catch (e: Exception) {
        e.printStackTrace()
    }
}