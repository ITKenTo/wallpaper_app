package com.example.w01_wallpaper.ui.screen.onboarding

import android.app.LocaleManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.manger.LocalUserManger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val localUserManager: LocalUserManger
): ViewModel() {

    fun onEvent(event: OnBoardingEvent){
        when(event){
            is OnBoardingEvent.SaveAppEntry ->{
                saveUserEntry()
            }
        }
    }

    private fun saveUserEntry() {
        viewModelScope.launch {
            localUserManager.saveAppEntry()
        }
    }
}