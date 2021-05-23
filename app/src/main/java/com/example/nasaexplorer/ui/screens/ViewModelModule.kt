package com.example.nasaexplorer.ui.screens

import com.example.nasaexplorer.network.NasaNetworkModule
import com.example.nasaexplorer.ui.screens.daily_pic.DailyPictureFeedViewModel
import com.example.nasaexplorer.ui.screens.mars_pictures.MarsPicturesViewModel
import com.example.nasaexplorer.ui.screens.near_objects.NearEarthObjectsFeedViewModel
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [NasaNetworkModule::class])
abstract class ViewModelModule {

    @ContributesAndroidInjector
    abstract fun contributeDailyFeedViewModel(): DailyPictureFeedViewModel

    @ContributesAndroidInjector
    abstract fun contributeNearEarthObjectsViewModel(): NearEarthObjectsFeedViewModel

    @ContributesAndroidInjector
    abstract fun contributeMarsPicturesViewModel(): MarsPicturesViewModel

}
