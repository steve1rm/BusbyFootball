package me.androidbox.testing.app.data

import me.androidbox.data.models.PlayerDataModel
import me.androidbox.data.models.PlayerModel
import me.androidbox.data.service.FootballServices
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextFloat
import kotlin.random.Random.Default.nextInt

@Singleton
class FakeFootballServices @Inject constructor() : FootballServices {

    var playerDataModel: PlayerDataModel = PlayerDataModel(emptyList()) //PlayerFactory.createPlayerDataModel()

    override fun getListOfPlayersByCountryId(apiKey: String, countryId: Int): PlayerDataModel {
        return playerDataModel
    }
}

/** Only for mocking the data remove after */
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

object RandomDataFactory {

    fun string(): String = UUID.randomUUID().toString()

    fun int(): Int = nextInt(from = 10, until = 1000)

    fun float(): Float = nextFloat()

    fun boolean(): Boolean = nextBoolean()
}
