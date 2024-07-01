package com.example.w01_wallpaper.ui.screen.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.manger.LocalUserManger
import com.example.w01_wallpaper.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val localUserManger: LocalUserManger
) : ViewModel() {

    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Route.OnBoardingScreen.route)
    val startDestination: State<String> = _startDestination

    init {
        localUserManger.readAppEntry().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen) {
                _startDestination.value = Route.MainScreen.route
            } else {
                _startDestination.value = Route.OnBoardingScreen.route
            }
            delay(300) //Without this delay, the onBoarding screen will show for a momentum.
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}