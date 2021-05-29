package me.androidbox.home.listitems

import com.airbnb.epoxy.TypedEpoxyController
import me.androidbox.home.items.PlayerItem
import java.util.*

class ListItemPlayerController : TypedEpoxyController<List<PlayerItem>>() {

    override fun buildModels(data: List<PlayerItem>?) {
        data?.let { listOfPlayers ->
            listOfPlayers.map {
                listItemPlayer {
                    id(UUID.randomUUID().toString())
                    firstName(it.firstName)
                    lastName(it.lastName)
                    age(it.age)
                    height(it.height)
                    weight(it.weight)
                }
            }
        }
    }
}
