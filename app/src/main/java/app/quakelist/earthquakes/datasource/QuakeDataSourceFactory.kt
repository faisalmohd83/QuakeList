package app.quakelist.earthquakes.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import app.quakelist.earthquakes.dto.QuakeFeature

class QuakeDataSourceFactory : DataSource.Factory<Int, QuakeFeature>() {

    private val data = MutableLiveData<QuakeDataSource>()

    override fun create(): DataSource<Int, QuakeFeature> {
        val dataSource = QuakeDataSource()
        data.postValue(dataSource)
        return dataSource
    }
}