package com.example.nasaexplorer.ui.screens.daily_pic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nasaexplorer.R
import com.example.nasaexplorer.model.DailyPicture
import com.example.nasaexplorer.model.MediaType
import com.example.nasaexplorer.model.fake_data.DailyPictureFake
import com.example.nasaexplorer.ui.util.images.GlideImage

@Composable
fun DailyPictureWidget(modelPicture: DailyPictureFeedViewModel) {
    val picture by modelPicture.dailyPictureLiveData.observeAsState()
    modelPicture.refreshDaily()
    picture?.let {
        DailyPictureFeedWidget(it)
    }
}

@Composable
private fun DailyPictureFeedWidget(picture: DailyPicture) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {

        if (picture.getMediaType() == MediaType.PICTURE) {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                url = picture.url,
                defaultImage = R.drawable.cute_alien,
                errorImage = R.drawable.error_img
            )
        } else {
            BasicText("Media format not supported")
        }
        Text(
            text = picture.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(picture.explanation,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp))
    }
}

@Preview
@Composable
fun DailyPictureFeedPreview() {
    DailyPictureFeedWidget(DailyPictureFake.dailyPicture)
}
