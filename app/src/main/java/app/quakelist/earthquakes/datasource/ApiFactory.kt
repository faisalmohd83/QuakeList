package app.quakelist.earthquakes.datasource

import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object APIFactory {

    private const val BASE_URL = "https://earthquake.usgs.gov"

    fun create(): APIEndPoints {

        // create an RxJava Adapter, network calls made asynchronous
        val rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

        // Build retrofit object
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build()

        return retrofit.create(APIEndPoints::class.java)
    }

}