package app.quakelist.earthquakes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import app.quakelist.R
import app.quakelist.common.ViewModelFactory
import app.quakelist.earthquakes.dto.QuakeFeature
import kotlinx.android.synthetic.main.fragment_quake_list.*

class QuakesFragment : Fragment(), Observer<PagedList<QuakeFeature>> {

    private lateinit var viewModel: QuakesViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mRecyclerAdapter: QuakeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModel
        viewModelFactory = ViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(QuakesViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?)
            : View? = inflater.inflate(R.layout.fragment_quake_list, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mRecyclerAdapter = QuakeListAdapter(context)

        rv_quake_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mRecyclerAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        // Listen to data change
        viewModel.getIncidents().observe(this, this)
    }

    override fun onChanged(incidentList: PagedList<QuakeFeature>?) {
        mRecyclerAdapter.submitList(incidentList)
    }

    override fun onPause() {
        viewModel.getIncidents().removeObserver(this)
        super.onPause()
    }

}