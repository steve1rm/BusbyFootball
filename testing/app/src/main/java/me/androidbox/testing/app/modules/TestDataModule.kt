package me.androidbox.testing.app.modules

import dagger.Binds
import dagger.Module
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.data.mappers.imp.DomainMapperImp
import me.androidbox.data.service.FootballServices
import me.androidbox.testing.app.data.FakeFootballServices

@Module
interface TestDataModule {

    @Binds
    fun bindsFakeFootballServices(fakeFootballServices: FakeFootballServices): FootballServices

    @Binds
    fun provideDomainMapper(domainMapperImp: DomainMapperImp): DomainMapperEntityToDomain
}
