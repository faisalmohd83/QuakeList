package app.quakelist.earthquakes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import app.quakelist.earthquakes.datasource.QuakeDataSourceFactory
import app.quakelist.earthquakes.dto.QuakeFeature

class QuakesViewModel : ViewModel() {

    private val pageSize = 50

    private var incidents: LiveData<PagedList<QuakeFeature>>

    init {
        val pagedListConfig = PagedList.Config.Builder()
                .setPageSize(pageSize)
                .setInitialLoadSizeHint(pageSize * 2)
                .setEnablePlaceholders(true)
                .setPrefetchDistance(pageSize)
                .build()

        incidents = LivePagedListBuilder<Int, QuakeFeature>(QuakeDataSourceFactory(), pagedListConfig)
                // .setBoundaryCallback() TODO
                .build()
    }

    fun getIncidents(): LiveData<PagedList<QuakeFeature>> {
        return incidents
    }
}