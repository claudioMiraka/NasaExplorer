package com.example.nasaexplorer.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.example.nasaexplorer.ui.screens.daily_pic.DailyPictureWidget
import com.example.nasaexplorer.ui.screens.daily_pic.DailyPictureFeedViewModel
import com.example.nasaexplorer.ui.screens.mars_pictures.MarsPicturesViewModel
import com.example.nasaexplorer.ui.screens.mars_pictures.MarsPicturesWidget
import com.example.nasaexplorer.ui.screens.near_objects.NearEarthObjectsFeedViewModel
import com.example.nasaexplorer.ui.screens.near_objects.NearObjectsWidget
import javax.inject.Inject


class ScreensController @Inject constructor() {

    @Inject
    lateinit var dailyPictureFeedViewModel: DailyPictureFeedViewModel

    @Inject
    lateinit var nearEarthObjectsFeedViewModel: NearEarthObjectsFeedViewModel

    @Inject
    lateinit var marsPicturesViewModel: MarsPicturesViewModel



    data class AppScreens(
        val route: String,
        val title: String,
        val content: @Composable (backStackEntry: NavBackStackEntry) -> Unit
    )

    private val dailyPictureScreen = AppScreens(
        "dailyPicture",
        "Daily Picture"
    ) {
        DailyPictureWidget(modelPicture = dailyPictureFeedViewModel)
    }

    private val nearEarthObjectsScreen = AppScreens(
        "nearEarthObjects",
        "Near Earth Objects"
    ) {
        NearObjectsWidget(nearEarthObjectsFeedViewModel)
    }

    private val marsPictureScreen = AppScreens(
        "marsPictures",
        "Mars Pictures"
    ) {
        MarsPicturesWidget(marsPicturesViewModel)
    }

    val screensAvailable = listOf(dailyPictureScreen, nearEarthObjectsScreen, marsPictureScreen)
    val screensMap = screensAvailable.associateBy { it.route }

    val initialRoute = dailyPictureScreen.route

}