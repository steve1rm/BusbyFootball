package me.androidbox.domain.interactors

import io.reactivex.rxjava3.core.Single
import me.androidbox.domain.models.PlayerEntity

interface PlayersInteractor {
    operator fun invoke(countryId: Int): Single<List<PlayerEntity>>
}
