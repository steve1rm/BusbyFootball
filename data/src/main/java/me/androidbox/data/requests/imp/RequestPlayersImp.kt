package me.androidbox.data.requests.imp

import io.reactivex.rxjava3.core.Single
import me.androidbox.data.BuildConfig
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.data.service.FootballServices
import me.androidbox.domain.interactors.PlayersInteractor
import me.androidbox.domain.models.PlayerEntity
import javax.inject.Inject

class RequestPlayersImp @Inject constructor(
        private val footballServices: FootballServices,
        private val domainMapper: DomainMapperEntityToDomain
) : PlayersInteractor {

    override fun invoke(countryId: Int): Single<List<PlayerEntity>> {
        return footballServices.getListOfPlayersByCountryId(BuildConfig.SPORTDATA_API_KEY, 42)
                .map { playerDataModel ->
                    domainMapper.mapToDomain(playerDataModel)
                }
    }
}
