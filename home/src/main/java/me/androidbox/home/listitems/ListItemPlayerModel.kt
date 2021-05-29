package me.androidbox.home.listitems

import android.annotation.SuppressLint
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import me.androidbox.home.R
import me.androidbox.home.items.PlayerItem

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.list_item_player)
abstract class ListItemPlayerModel :  EpoxyModelWithHolder<ListItemPlayerHolder>() {

    @EpoxyAttribute
    lateinit var firstName: String

    @EpoxyAttribute
    lateinit var lastName: String

    @EpoxyAttribute
    var age: Int = 0

    @EpoxyAttribute
    var height: Int = 0

    @EpoxyAttribute
    var weight: Int = 0

    override fun bind(holder: ListItemPlayerHolder) {
            with(holder) {
                tvFullName.text = view.context.getString(R.string.fullName, firstName, lastName)
                tvAge.text = view.context.getString(R.string.age, age)
                tvHeight.text = view.context.getString(R.string.height, height)
                tvWeight.text = view.context.getString(R.string.weight, weight)
        }
    }
}