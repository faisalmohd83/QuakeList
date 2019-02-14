package app.quakelist.earthquakes.dto

data class QuakeFeature(
        val geometry: QuakeGeometry,
        val id: String,
        val properties: QuakeData,
        val type: String
)