package me.androidbox.home

import com.airbnb.epoxy.TypedEpoxyController
import me.androidbox.domain.entities.PlayerEntity
import java.util.*

class ListItemPlayerController : TypedEpoxyController<List<PlayerEntity>>() {

    override fun buildModels(data: List<PlayerEntity>?) {
        data?.let { listOfPlayers ->

            listItemPlayer {
                id(UUID.randomUUID().toString())
                listOfPlayers(listOfPlayers)
            }
        }
    }
}
