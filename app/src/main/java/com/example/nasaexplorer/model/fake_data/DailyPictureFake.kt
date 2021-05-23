package com.example.nasaexplorer.model.fake_data

import com.example.nasaexplorer.model.DailyPicture

/**
 *  Fake Objects to simulate the response from
 *      https://api.nasa.gov/planetary/apod?api_key={api_key}
 */
object DailyPictureFake {

    private const val date = "2021-05-13"

    private const val mediaType = "image"

    private const val hdurl =
        "https://apod.nasa.gov/apod/image/2105/ATLASHockeyStickWhaleGalaxiesGrandMesa.jpg"

    private const val explanation =
        "Closest to the Sun on March 1, and closest to planet Earth on April 23, " +
                "this Comet ATLAS (C/2020 R4) shows a faint greenish coma and short tail in this pretty, telescopic field of view. " +
                "Captured at its position on May 5, the comet was within the boundaries of northern constellation Canes Venatici (the Hunting Dogs)," +
                " and near the line-of-sight to intriguing background galaxies popularly known as the Whale and the Hockey Stick." +
                " Cetacean in appearance but Milky Way sized, NGC 4631 is a spiral galaxy seen edge-on at the top right, " +
                "some 25 million light-years away. NGC 4656/7 sports the bent-stick shape of interacting galaxies below and left of NGC 4631. " +
                "In fact, the distortions and mingling trails of gas detected at other wavelengths suggest the cosmic Whale and " +
                "Hockey Stick have had close encounters with each other in their distant past. Outbound and only about 7 light-minutes" +
                " from Earth this Comet ATLAS should revisit the inner solar system in just under 1,000 years."

    private const val serviceVersion = "v1"

    private const val title = "The Comet, the Whale, and the Hockey Stick"

    private const val url =
        "https://apod.nasa.gov/apod/image/2105/ATLASHockeyStickWhaleGalaxiesGrandMesa1024.jpg"

    val dailyPicture = DailyPicture(
        date = date,
        mediaType = mediaType,
        urlHD = hdurl,
        explanation = explanation,
        serviceVersion = serviceVersion,
        title = title,
        url = url
    )

}