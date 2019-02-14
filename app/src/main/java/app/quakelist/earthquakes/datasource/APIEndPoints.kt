package app.quakelist.earthquakes.datasource

import app.quakelist.earthquakes.dto.QuakeList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIEndPoints {

    /**
     * API Interface to fetch Earth quake as lists of 50 results per page.
     * @see https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&offset=2&limit=10
     */
    @GET("/fdsnws/event/1/query")
    fun getEarthQuakes(@Query("format") format: String,
                       @Query("offset") offset: Int,
                       @Query("limit") limit: Int
    ): Observable<QuakeList>
}