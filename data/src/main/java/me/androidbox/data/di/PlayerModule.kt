package me.androidbox.data.di

import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import me.androidbox.data.BuildConfig
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.data.mappers.imp.DomainMapperImp
import me.androidbox.data.requests.imp.RequestPlayersImp
import me.androidbox.data.service.Endpoints
import me.androidbox.data.service.FootballServices
import me.androidbox.data.service.MockFootballServices
import me.androidbox.domain.interactors.PlayersInteractor
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
interface PlayerModule {

    @Binds
    fun provideRequestPlayersImp(requestPlayersImp: RequestPlayersImp): PlayersInteractor

/*
    @Binds
    fun provideFootballServices(mockFootballServices: MockFootballServices): FootballServices
*/

    @Binds
    fun provideDomainMapper(domainMapperImp: DomainMapperImp): DomainMapperEntityToDomain

    @Module
    companion object {
        /* Static providers to go here */
    }
}
