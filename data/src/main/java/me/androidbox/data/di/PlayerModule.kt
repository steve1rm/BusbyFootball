package me.androidbox.data.di

import dagger.Binds
import dagger.Module
import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.data.mappers.DomainMapper
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.data.mappers.imp.DomainMapperImp
import me.androidbox.data.requests.imp.RequestPlayersImp
import me.androidbox.data.service.FootballServices
import me.androidbox.data.service.MockFootballServices
import me.androidbox.domain.interactors.PlayersInteractor
import me.androidbox.domain.models.PlayerModel

@Module
interface PlayerModule {

    @Binds
    fun provideRequestPlayersImp(requestPlayersImp: RequestPlayersImp): PlayersInteractor

    @Binds
    fun provideFootballServices(mockFootballServices: MockFootballServices): FootballServices

    @Binds
    fun provideDomainMapper(domainMapperImp: DomainMapperImp): DomainMapperEntityToDomain
}
