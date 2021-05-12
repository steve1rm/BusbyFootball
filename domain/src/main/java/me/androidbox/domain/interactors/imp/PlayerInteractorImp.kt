package me.androidbox.domain.interactors.imp

import io.reactivex.rxjava3.core.Single
import me.androidbox.domain.interactors.PlayersInteractor
import me.androidbox.domain.entities.PlayerEntity

class PlayerInteractorImp(private val requestPlayerImp: Int) : PlayersInteractor {
    override fun invoke(countryId: Int): Single<List<PlayerEntity>> {
        TODO()
    }
}