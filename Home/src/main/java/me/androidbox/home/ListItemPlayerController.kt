package me.androidbox.home

import android.content.Context
import com.airbnb.epoxy.TypedEpoxyController
import me.androidbox.domain.entities.PlayerEntity

class ListItemPlayerController(private val context: Context) : TypedEpoxyController<List<PlayerEntity>>() {

    override fun buildModels(data: List<PlayerEntity>?) {
        data?.let {
            ListItemPlayerModel_()
                .context(context)
        }
    }
}
