package me.androidbox.data.di

import dagger.Binds
import dagger.Module
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.data.mappers.imp.DomainMapperImp
import me.androidbox.data.requests.imp.RequestPlayersImp
import me.androidbox.domain.interactors.PlayersInteractor

@Module
interface PlayerModule {

    @Binds
    fun provideRequestPlayersImp(requestPlayersImp: RequestPlayersImp): PlayersInteractor

    @Binds
    fun provideDomainMapper(domainMapperImp: DomainMapperImp): DomainMapperEntityToDomain

    @Module
    companion object {
        /* Static providers to go here */
    }
}
