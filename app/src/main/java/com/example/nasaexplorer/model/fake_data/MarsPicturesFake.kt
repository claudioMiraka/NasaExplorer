package com.example.nasaexplorer.model.fake_data

import com.example.nasaexplorer.model.MarsCameraInfo
import com.example.nasaexplorer.model.MarsPicture
import com.example.nasaexplorer.model.MarsPictures
import com.example.nasaexplorer.model.MarsRoverInfo

object MarsPicturesFake {

    private val marsCameraInfo = MarsCameraInfo(
        id = 20,
        name = "FHAZ",
        roverId = 5,
        fullName = "Front Hazard Avoidance Camera"
    )

    private val marsRoverInfo = MarsRoverInfo(
        id = 5,
        name = " Curiosity",
        landingDate = "2012-08-06",
        launchDate = "2011-11-26",
        status = "active"
    )
    val marsPicture = MarsPicture(
        id = 837323,
        sol = 3122,
        camera = marsCameraInfo,
        imgSrc = "https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/03122/opgs/edr/fcam/FLB_674657615EDR_F0880366FHAZ00302M_.JPG",
        earthDate = "2021-05-18",
        rover = marsRoverInfo
    )

    val marsPictures = MarsPictures(
        photos = listOf(marsPicture, marsPicture, marsPicture, marsPicture)
    )
}