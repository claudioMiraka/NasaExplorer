package com.example.nasaexplorer.ui.screens.near_objects

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.ui.core.AlignmentLine
import com.example.nasaexplorer.model.NearEarthObject
import com.example.nasaexplorer.model.fake_data.NearEarthObjectsFake


@Composable
fun NearObjectCard(
    modifier: Modifier = Modifier,
    nearEarthObject: NearEarthObject,
    onClick: () -> Unit = {}
) {
    Card(
        modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(4.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .padding(8.dp),

        ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp),
            horizontalAlignment = Alignment.Start,
        ) {

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    nearEarthObject.name,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.wrapContentWidth(Alignment.Start)
                )
                Text(nearEarthObject.id, modifier = Modifier.wrapContentWidth(Alignment.End))
            }

            Text(
                "Diameter: " + getSubstring(
                    nearEarthObject.estimatedDiameter.kilometers.max.toEngineeringString(), 15
                ) + "km", style = MaterialTheme.typography.body2
            )
            Text(
                "Distance: " + getSubstring(
                    nearEarthObject.closeApproachData[0].missDistance.kilometers, 15
                ) + "km", style = MaterialTheme.typography.body2
            )
            Text(
                "Velocity: " + getSubstring(
                    nearEarthObject.closeApproachData[0].relativeVelocity.kilometersPerHour, 15
                ) + "km/h",
                style = MaterialTheme.typography.body2
            )
        }

    }
}

@Preview("NearObjectCardPreview")
@Composable
private fun NearObjectCardPreview() {
    val nearObj = NearEarthObjectsFake.nearEarthObject
    NearObjectCard(nearEarthObject = nearObj)
}

private fun getSubstring(s: String, max: Int): String {
    if (s.length <= max)
        return s
    return s.subSequence(0, max).toString()
}