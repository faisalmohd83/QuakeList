package app.quakelist.earthquakes.datasource

import android.annotation.SuppressLint
import androidx.paging.PageKeyedDataSource
import app.quakelist.earthquakes.dto.QuakeFeature
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuakeDataSource : PageKeyedDataSource<Int, QuakeFeature>() {

    private val format: String = "geojson"
    private val offset: Int = 1
    private val limit: Int = 50

    private val apiEndPoints: APIEndPoints = APIFactory.create()

    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, QuakeFeature>) {
        apiEndPoints.getEarthQuakes(format, offset, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result -> callback.onResult(result.features, 1, 2) },
                        { error -> error.printStackTrace() }
                )
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, QuakeFeature>) {
        apiEndPoints.getEarthQuakes(format, params.key, limit)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { result -> callback.onResult(result.features, params.key + 1) },
                        { error -> error.printStackTrace() }
                )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, QuakeFeature>) {
        // Do nothing
    }
}