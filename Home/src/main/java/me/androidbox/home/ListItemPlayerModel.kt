package me.androidbox.home

import android.annotation.SuppressLint
import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import me.androidbox.domain.entities.PlayerEntity

@SuppressLint("NonConstantResourceId")
@EpoxyModelClass(layout = R.layout.list_item_player)
abstract class ListItemPlayerModel :  EpoxyModelWithHolder<ListItemPlayerHolder>() {

    @EpoxyAttribute
    lateinit var listOfPlayers: List<PlayerEntity>

    @EpoxyAttribute
    lateinit var context: Context

    override fun bind(holder: ListItemPlayerHolder) {
        listOfPlayers.map {
            with(holder) {
                tvFullName.text = context.getString(R.string.fullName, it.firstName, it.lastName)
                tvAge.text = context.getString(R.string.age, it.age)
                tvHeight.text = context.getString(R.string.height, it.height)
                tvWeight.text = context.getString(R.string.weight, it.weight)
            }
        }
    }
}