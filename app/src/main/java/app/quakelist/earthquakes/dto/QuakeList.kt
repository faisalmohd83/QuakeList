package app.quakelist.earthquakes.dto

data class QuakeList(
        val bbox: List<Double>,
        val features: List<QuakeFeature>,
        val metadata: QuakeMetadata,
        val type: String
)