package com.example.nasaexplorer.model

import com.google.gson.annotations.SerializedName


data class MarsPictures(
    val photos: List<MarsPicture>
)

data class MarsPicture(
    val id: Int,
    val sol: Int,
    val camera: MarsCameraInfo,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("earth_date")
    val earthDate: String,
    val rover : MarsRoverInfo
)

data class MarsCameraInfo(
    val id: Int,
    val name: String,
    @SerializedName("rover_id")
    val roverId: Int,
    @SerializedName("full_name")
    val fullName: String
)

data class MarsRoverInfo(
    val id: Int,
    val name: String,
    @SerializedName("landing_date")
    val landingDate: String,
    @SerializedName("launch_date")
    val launchDate: String,
    val status: String,
)