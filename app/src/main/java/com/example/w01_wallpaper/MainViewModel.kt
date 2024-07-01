package com.example.w01_wallpaper

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
/*
    private val readAppEntry: ReadAppEntry
*/
): ViewModel() {

//    private val _splashCondition = mutableStateOf(true)
//    val splashCondition: State<Boolean> = _splashCondition
//
//    private val _startDestination = mutableStateOf(Route.AppStartNavigation.route)
//    val startDestination: State<String> = _startDestination
//
//    init {
//        readAppEntry().onEach { shouldStartFromHomeScreen ->
//            if(shouldStartFromHomeScreen){
//                _startDestination.value = Route.NewsNavigation.route
//            }else{
//                _startDestination.value = Route.AppStartNavigation.route
//            }
//            delay(300) //Without this delay, the onBoarding screen will show for a momentum.
//            _splashCondition.value = false
//        }.launchIn(viewModelScope)
//    }
}




