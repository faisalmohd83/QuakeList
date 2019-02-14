package app.quakelist.earthquakes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import app.quakelist.R
import app.quakelist.earthquakes.dto.QuakeFeature

/**
 *
 */
class QuakeListAdapter internal constructor(private val mContext: Context?) : PagedListAdapter<QuakeFeature, QuakesViewHolder>
(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<QuakeFeature>() {
            override fun areItemsTheSame(oldItem: QuakeFeature, newItem: QuakeFeature): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: QuakeFeature, newItem: QuakeFeature): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakesViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.layout_single_item, parent, false)
        return QuakesViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuakesViewHolder, position: Int) {
        holder.tvName.text = getItem(position)!!.properties.title
    }
}


