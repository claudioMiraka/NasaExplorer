package com.example.nasaexplorer.ui.screens

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class ScreenControllerModule {

    @ContributesAndroidInjector
    abstract fun contributeScreensController() : ScreensController

}