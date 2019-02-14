package app.quakelist.earthquakes.dto

data class QuakeMetadata(
        val api: String,
        val count: Int,
        val generated: Long,
        val status: Int,
        val title: String,
        val url: String
)