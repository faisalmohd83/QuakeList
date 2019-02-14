package app.quakelist.earthquakes

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_single_item.view.*

/**
 *
 */
class QuakesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvName = itemView.tv_incident_name!!
}
