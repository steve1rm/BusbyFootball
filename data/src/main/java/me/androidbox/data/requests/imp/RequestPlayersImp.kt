package me.androidbox.data.requests.imp

import io.reactivex.rxjava3.core.Single
import me.androidbox.data.BuildConfig
import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.data.mappers.DomainMapper
import me.androidbox.data.service.FootballServices
import me.androidbox.domain.models.PlayerModel
import me.androidbox.domain.interactors.PlayersInteractor
import javax.inject.Inject

class RequestPlayersImp @Inject constructor(private val footballServices: FootballServices,
                        private val domainMapper: DomainMapper<PlayerDataEntity, List<PlayerModel>>
) : PlayersInteractor {

    override fun invoke(): Single<List<PlayerModel>> {
        return footballServices.getListOfPlayersByCountryId(BuildConfig.SPORTDATA_API_KEY, 42)
                .map {
                    domainMapper.mapToDomain(it)
                }
    }
}
