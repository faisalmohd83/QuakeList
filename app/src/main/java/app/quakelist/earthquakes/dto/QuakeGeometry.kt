package app.quakelist.earthquakes.dto

data class QuakeGeometry(
        val coordinates: List<Double>,
        val type: String
)