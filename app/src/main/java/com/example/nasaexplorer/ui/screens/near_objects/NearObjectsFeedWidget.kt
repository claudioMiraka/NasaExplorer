package com.example.nasaexplorer.ui.screens.near_objects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nasaexplorer.model.NearEarthObjects
import com.example.nasaexplorer.model.fake_data.NearEarthObjectsFake

@Composable
fun NearObjectsWidget(model: NearEarthObjectsFeedViewModel) {
    val nearEarthObjects by model.nearEarthObjects.observeAsState()
    model.refreshNearEarthObjects()
    nearEarthObjects?.let {
        NearObjectsFeedWidget(nearEarthObj = it)
    }
}

@Composable
private fun NearObjectsFeedWidget(nearEarthObj: NearEarthObjects) {
    val nearEarthObjects = nearEarthObj.nearEarthObjects
    val nearEarthObjectsCount = nearEarthObj.elementCount

    Column(Modifier.fillMaxWidth()) {
        Text("There are $nearEarthObjectsCount orbiting around us",
            Modifier.padding(5.dp, 10.dp)
        )
        LazyColumn() {
            nearEarthObjects.forEach { (_, nearEarthObject) ->
                items(nearEarthObject) { obj ->
                    NearObjectCard(nearEarthObject = obj)
                }
            }
        }
    }
}


@Preview
@Composable
fun NearObjectsFeedPreview() {
    val nearObj = NearEarthObjectsFake.nearEarthObjects
    NearObjectsFeedWidget(nearObj)
}
