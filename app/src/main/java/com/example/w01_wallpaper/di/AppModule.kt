package com.example.w01_wallpaper.di

import android.app.Application
import com.example.data.manager.LocalUserMangerImpl
import com.example.data.manager.WallpaperRepositoryImpl
import com.example.data.remote.WallpaperService
import com.example.domain.manger.LocalUserManger
import com.example.domain.manger.WallpaperRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideLocalUserManager(
        application: Application
    ): LocalUserManger {
        return LocalUserMangerImpl(application)
    }

    @Singleton
    @Provides
    fun provideWallpaperRepository(
        wallpaperService: WallpaperService
    ): WallpaperRepository {
        return WallpaperRepositoryImpl(wallpaperService)
    }

}