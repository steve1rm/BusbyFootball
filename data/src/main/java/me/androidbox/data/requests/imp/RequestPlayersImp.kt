package me.androidbox.data.requests.imp

import kotlinx.coroutines.withTimeout
import me.androidbox.data.BuildConfig
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.data.service.FootballServices
import me.androidbox.domain.entities.PlayerEntity
import me.androidbox.domain.interactors.PlayersInteractor
import javax.inject.Inject

class RequestPlayersImp @Inject constructor(
        private val footballServices: FootballServices,
        private val domainMapper: DomainMapperEntityToDomain
) : PlayersInteractor {

    override suspend fun getListOfPlayersByCountryId(countryId: Int): List<PlayerEntity> {
        return withTimeout(10_000) {
            val playerDataModel = footballServices.getListOfPlayersByCountryId(BuildConfig.SPORTDATA_API_KEY, 42)

            domainMapper.mapToDomain(playerDataModel)
        }
    }
}
