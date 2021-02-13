package me.androidbox.domain.interactors

import io.reactivex.rxjava3.core.Single
import me.androidbox.domain.models.PlayerModel

interface PlayersInteractor {
    operator fun invoke(): Single<List<PlayerModel>>
}
