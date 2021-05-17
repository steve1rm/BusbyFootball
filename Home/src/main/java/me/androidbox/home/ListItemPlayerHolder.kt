package me.androidbox.home

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder

class ListItemPlayerHolder : EpoxyHolder() {

    lateinit var tvFullName: TextView
    lateinit var tvAge: TextView
    lateinit var tvHeight: TextView
    lateinit var tvWeight: TextView

    override fun bindView(itemView: View) {
        tvFullName = itemView.findViewById(R.id.tvFullName)
        tvAge = itemView.findViewById(R.id.tvAge)
        tvHeight = itemView.findViewById(R.id.tvHeight)
        tvWeight = itemView.findViewById(R.id.tvWeight)
    }
}
