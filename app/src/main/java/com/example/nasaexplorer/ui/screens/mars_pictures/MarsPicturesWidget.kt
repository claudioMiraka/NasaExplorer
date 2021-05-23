package com.example.nasaexplorer.ui.screens.mars_pictures

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.nasaexplorer.model.fake_data.MarsPicturesFake
import com.example.nasaexplorer.ui.screens.daily_pic.MarsPictureCard


@Composable
fun MarsPicturesWidget(model: MarsPicturesViewModel) {
    val marsPictures by model.marsPicturesLiveData.observeAsState()
    model.refreshPictures()
    marsPictures?.let {
        NasaGrid(items = it.photos) { picture ->
            MarsPictureCard(marsPicture = picture, onClick = {})
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> NasaGrid(
    items: List<T>,
    count: Int = 2,
    child: @Composable (item: T) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(count = count)
    ) {
        items(items) { item ->
            child(item)
        }
    }
}


@Preview("NasaGrid")
@Composable
private fun NasaGridPreview() {
    val marsPictures = MarsPicturesFake.marsPictures
    NasaGrid(count = 2, items = marsPictures.photos) { picture ->
        MarsPictureCard(marsPicture = picture, onClick = {})
    }
}
