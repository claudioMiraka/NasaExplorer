package com.example.nasaexplorer.ui.screens.daily_pic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nasaexplorer.R
import com.example.nasaexplorer.model.MarsPicture
import com.example.nasaexplorer.model.fake_data.MarsPicturesFake
import com.example.nasaexplorer.ui.util.images.GlideImage

@Composable
fun MarsPictureCard(modifier: Modifier = Modifier, marsPicture: MarsPicture, onClick: () -> Unit) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .clickable(onClick = onClick),
        ) {
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                url = marsPicture.imgSrc,
                defaultImage = R.drawable.cute_alien,
                errorImage = R.drawable.error_img
            )
            Column {
                Text(
                    text = "Rover: " + marsPicture.rover.name,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = "Camera: " + marsPicture.camera.fullName,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview("Mars Picture Card")
@Composable
private fun MarsPictureCardPreview() {
    val picture = MarsPicturesFake.marsPicture
    MarsPictureCard(marsPicture = picture, onClick = {})
}