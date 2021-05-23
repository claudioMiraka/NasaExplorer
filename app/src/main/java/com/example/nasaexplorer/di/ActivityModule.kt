package com.example.nasaexplorer.di

import com.example.nasaexplorer.MainActivity
import com.example.nasaexplorer.ui.screens.ScreenControllerModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ScreenControllerModule::class])
abstract class ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}