package me.androidbox.data.mockdata

import me.androidbox.data.models.PlayerDataModel
import me.androidbox.data.models.PlayerModel

object PlayerFactory {

    fun createPlayerModel(): PlayerModel {
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

    fun createPlayerModelNullValues(): PlayerModel {
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

    fun createPlayerDataModel(): PlayerDataModel {
        return PlayerDataModel(
            listOf(
                createPlayerModel(),
                createPlayerModel(),
                createPlayerModel())
        )
    }

    fun createPlayerDataModelNullValues(): PlayerDataModel {
        return PlayerDataModel(
                listOf(
                        createPlayerModelNullValues(),
                        createPlayerModelNullValues(),
                        createPlayerModelNullValues())
        )
    }
}
