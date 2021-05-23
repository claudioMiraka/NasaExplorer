package com.example.nasaexplorer.model

import com.google.gson.annotations.SerializedName

/**
 *  Class that will parse and hold data retrieved at:
 *      https://api.nasa.gov/planetary/apod?api_key={api_key}
 *
 *  Go to https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
 *      to see a sample response
 */
data class DailyPicture(
    val date: String,

    val explanation : String,

    @SerializedName("hdurl")
    val urlHD: String,

    @SerializedName("media_type")
    val mediaType : String,

    @SerializedName("service_version")
    val serviceVersion : String,

    val title: String,

    val url : String,

    ){
    fun getMediaType() : MediaType{
        return when(mediaType){
            "image" -> MediaType.PICTURE
            "vide" -> MediaType.VIDEO
            else -> MediaType.UNKNOWN
        }
    }
}

enum class MediaType{
    PICTURE,
    VIDEO,
    UNKNOWN
}
