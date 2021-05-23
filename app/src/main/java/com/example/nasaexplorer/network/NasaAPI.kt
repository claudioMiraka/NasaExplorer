package com.example.nasaexplorer.network

import com.example.nasaexplorer.model.DailyPicture
import com.example.nasaexplorer.model.MarsPictures
import com.example.nasaexplorer.model.NearEarthObjects
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *  Interface providing API calls available for https://api.nasa.gov/
 */
interface NasaAPI {

    /**
     *  Get the daily picture and all relative info
     */
    @GET("planetary/apod")
    fun getDailyPicture(@Query("api_key") api_key: String): Call<DailyPicture>


    /**
     *  Get the list of all the objects near to Earth from {start_date} to {end_date}
     *  and relative info (distance, velocity, diameter)
     */
    @GET("/neo/rest/v1/feed")
    fun getNearEarthObjects(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String
    ): Call<NearEarthObjects>

    /**
     * Get Mars pictures
     */
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    fun getMarsPictures(
        @Query("earth_date") earthDate: String,
        @Query("api_key") apiKey: String
    ): Call<MarsPictures>


}