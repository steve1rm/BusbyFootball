package me.androidbox.data.mockdata

import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.data.entities.PlayerEntity

object PlayerFactory {

    fun createPlayerEntity(): PlayerEntity {
        return PlayerEntity(
            RandomDataFactory.int(),
            RandomDataFactory.string(),
            RandomDataFactory.string(),
            RandomDataFactory.string(),
            RandomDataFactory.int(),
            RandomDataFactory.int(),
            RandomDataFactory.int()
        )
    }

    fun createPlayerDataEntity(): PlayerDataEntity {
        return PlayerDataEntity(
            listOf(
                createPlayerEntity(),
                createPlayerEntity(),
                createPlayerEntity())
        )
    }
}
