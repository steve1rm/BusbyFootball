package me.androidbox.data.mockdata

import me.androidbox.data.entities.PlayerDataModel
import me.androidbox.data.entities.PlayerModel

object PlayerFactory {

    fun createPlayerEntity(): PlayerModel {
        return PlayerModel(
            RandomDataFactory.int(),
            RandomDataFactory.string(),
            RandomDataFactory.string(),
            RandomDataFactory.string(),
            RandomDataFactory.int(),
            RandomDataFactory.int(),
            RandomDataFactory.int()
        )
    }

    fun createPlayerEntityNullValues(): PlayerModel {
        return PlayerModel(
                RandomDataFactory.int(),
                null,
                null,
                null,
                null,
                null,
                null
        )
    }

    fun createPlayerDataEntity(): PlayerDataModel {
        return PlayerDataModel(
            listOf(
                createPlayerEntity(),
                createPlayerEntity(),
                createPlayerEntity())
        )
    }

    fun createPlayerDataEntityNullValues(): PlayerDataModel {
        return PlayerDataModel(
                listOf(
                        createPlayerEntityNullValues(),
                        createPlayerEntityNullValues(),
                        createPlayerEntityNullValues())
        )
    }
}
