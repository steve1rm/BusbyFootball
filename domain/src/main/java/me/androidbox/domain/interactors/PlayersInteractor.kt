package me.androidbox.domain.interactors

import io.reactivex.rxjava3.core.Single
import me.androidbox.domain.entities.PlayerEntity

interface PlayersInteractor {
    fun getListOfPlayersByCountryId(countryId: Int): Single<List<PlayerEntity>>
}
