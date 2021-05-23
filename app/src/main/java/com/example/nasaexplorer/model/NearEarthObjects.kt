package com.example.nasaexplorer.model

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.math.BigInteger


/**
 *  Class that will parse and hold data retrieved at:
 *      https://api.nasa.gov/neo/rest/v1/feed?start_date={start_date}&end_date={end_date}&api_key={api_key}
 *
 *  Look at https://api.nasa.gov/neo/rest/v1/feed?start_date=2015-09-07&end_date=2015-09-08&api_key=DEMO_KEY
 *      for a sample response
 *
 */
data class NearEarthObjects(
    val links: Links,

    @SerializedName("element_count")
    val elementCount: Int,

    @SerializedName("near_earth_objects")
    val nearEarthObjects: Map<String, List<NearEarthObject>>
)

/////////////////////////////////////////////////////

data class NearEarthObject(
    val links: Links,
    val id: String,
    val name: String,

    @SerializedName("neo_reference_id")
    val neoReferenceId: String,

    @SerializedName("nasa_jpl_url")
    val nasaJplUrl: String,

    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitudeH: Double,

    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean,

    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,

    @SerializedName("is_sentry_object")
    val isSentryObject: Boolean,

    @SerializedName("close_approach_data")
    val closeApproachData: List<CloseApproach>
)

/////////////////////////////////////////////////////

data class Links(
    val next: String?,
    val prev: String?,
    val self: String
)

/////////////////////////////////////////////////////
data class EstimatedDiameter(
    val kilometers: EstimatedDiameterMinMax,
    val meters: EstimatedDiameterMinMax,
    val miles: EstimatedDiameterMinMax,
    val feet: EstimatedDiameterMinMax,
)

data class EstimatedDiameterMinMax(
    @SerializedName("estimated_diameter_min")
    val min: BigDecimal,

    @SerializedName("estimated_diameter_max")
    val max: BigDecimal
)

/////////////////////////////////////////////////////

data class CloseApproach(
    @SerializedName("close_approach_date")
    val closeApproachDate: String,

    @SerializedName("close_approach_date_full")
    val closeApproachDateFull: String,

    @SerializedName("epoch_date_close_approach")
    val epochDateCloseApproach: BigInteger,

    @SerializedName("relative_velocity")
    val relativeVelocity: Velocity,

    @SerializedName("miss_distance")
    val missDistance: Distance,

    @SerializedName("orbiting_body")
    val orbitingBody: String,

)

data class Velocity(
    @SerializedName("kilometers_per_second")
    val kilometersPerSecond: String,
    @SerializedName("kilometers_per_hour")
    val kilometersPerHour: String,
    @SerializedName("miles_per_hour")
    val milesPerHour: String,
)

data class Distance(
    val astronomical: String,
    val lunar: String,
    val kilometers: String,
    val miles: String
)