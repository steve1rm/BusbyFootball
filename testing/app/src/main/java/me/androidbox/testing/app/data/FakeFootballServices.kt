package me.androidbox.testing.app.data

import io.reactivex.rxjava3.core.Single
import me.androidbox.data.models.PlayerDataModel
import me.androidbox.data.service.FootballServices
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FakeFootballServices @Inject constructor() : FootballServices {

    var playerDataModel: PlayerDataModel = PlayerDataModel(emptyList())

    override fun getListOfPlayersByCountryId(apiKey: String, countryId: Int): Single<PlayerDataModel> {
        return Single.just(playerDataModel)
    }
}
