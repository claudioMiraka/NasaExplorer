package com.example.nasaexplorer.model.fake_data

import com.example.nasaexplorer.model.*
import java.math.BigDecimal
import java.math.BigInteger

/**
 * Fake Objects to simulate the response from
 *  https://api.nasa.gov/neo/rest/v1/feed?start_date={start_date}&end_date={end_date}&api_key={api_key}
 */

/////////////////////////////////////////////////////

object NearEarthObjectsFake {

    private val estimatedDiameterMinMaxKilometerFake = EstimatedDiameterMinMax(
        min = BigDecimal(0.1838886721),
        max = BigDecimal(0.411187571)
    )


    private val estimatedDiameterMinMaxMeters = EstimatedDiameterMinMax(
        min = BigDecimal(183.8886720703),
        max = BigDecimal(411.1875710413)
    )


    private val estimatedDiameterMinMaxMiles = EstimatedDiameterMinMax(
        min = BigDecimal(0.1142630881),
        max = BigDecimal(0.2555000322)
    )

    private   val estimatedDiameterMinMaxFeet = EstimatedDiameterMinMax(
        min = BigDecimal(603.309310875),
        max = BigDecimal(1349.040630575)
    )

    private  val estimatedDiameter = EstimatedDiameter(
        kilometers = estimatedDiameterMinMaxKilometerFake,
        meters = estimatedDiameterMinMaxMeters,
        miles = estimatedDiameterMinMaxMiles,
        feet = estimatedDiameterMinMaxFeet
    )

    /////////////////////////////////////////////////////
    private   val links = Links(
        next = "http://www.neowsapp.com/rest/v1/feed?start_date=2021-05-16&end_date=2021-05-23&detailed=false&api_key=DEMO_KEY",
        prev = "http://www.neowsapp.com/rest/v1/feed?start_date=2021-05-02&end_date=2021-05-09&detailed=false&api_key=DEMO_KEY",
        self = "http://www.neowsapp.com/rest/v1/feed?start_date=2021-05-09&end_date=2021-05-16&detailed=false&api_key=DEMO_KEY"
    )

    /////////////////////////////////////////////////////
    private  val velocity = Velocity(
        kilometersPerSecond = "8.5968416308",
        kilometersPerHour = "30948.6298707206",
        milesPerHour = "19230.2750438374"
    )

    private  val distance = Distance(
        astronomical = "0.2150532009",
        lunar = "83.6556951501",
        kilometers = "32171500.791322083",
        miles = "19990443.6225394254"
    )
    private val closeApproach = CloseApproach(
        closeApproachDate = "2021-05-09",
        closeApproachDateFull = "2021-May-09 14:43",
        epochDateCloseApproach = BigInteger("1620571380000"),
        relativeVelocity = velocity,
        missDistance = distance,
        orbitingBody = "Earth",
    )
/////////////////////////////////////////////////////

    val nearEarthObject = NearEarthObject(
        links = Links(
            self = "http://www.neowsapp.com/rest/v1/neo/2494710?api_key=DEMO_KEY",
            next = null,
            prev = null
        ),
        id = "2494710",
        name = "494710 (2005 MO13)",
        neoReferenceId = "2494710",
        nasaJplUrl = "http://ssd.jpl.nasa.gov/sbdb.cgi?sstr=2494710",
        absoluteMagnitudeH = 20.8,
        isPotentiallyHazardousAsteroid = true,
        estimatedDiameter = estimatedDiameter,
        isSentryObject = false,
        closeApproachData = listOf(closeApproach)
    )

/////////////////////////////////////////////////////

    val nearEarthObjects = NearEarthObjects(
        links = links,
        elementCount = 77,
        nearEarthObjects = mapOf(
            "2021-05-09" to listOf(
                nearEarthObject,
                nearEarthObject,
                nearEarthObject,
                nearEarthObject
            ),
        )
    )
}