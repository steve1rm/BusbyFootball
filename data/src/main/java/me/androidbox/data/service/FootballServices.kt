package me.androidbox.data.service

import io.reactivex.rxjava3.core.Single
import me.androidbox.data.models.PlayerDataModel
import me.androidbox.data.models.PlayerModel
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random.Default.nextBoolean
import kotlin.random.Random.Default.nextFloat
import kotlin.random.Random.Default.nextInt

interface FootballServices {

    @GET(Endpoints.PLAYERS_BY_COUNTY_ID)
    fun getListOfPlayersByCountryId(
            @Query("apikey") apiKey: String,
            @Query("counter_id") countryId: Int) : PlayerDataModel
}

@Singleton
class MockFootballServices @Inject constructor() : FootballServices {
    override fun getListOfPlayersByCountryId(
        apiKey: String,
        countryId: Int
    ): PlayerDataModel {
        return PlayerFactory.createPlayerDataModel()
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

    fun int(): Int = nextInt()

    fun float(): Float = nextFloat()

    fun boolean(): Boolean = nextBoolean()
}
