package me.androidbox.data.requests.imp

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Single
import me.androidbox.data.BuildConfig
import me.androidbox.data.models.PlayerDataModel
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.data.mappers.imp.DomainMapperImp
import me.androidbox.data.mockdata.PlayerFactory
import me.androidbox.data.service.FootballServices
import org.junit.Before
import org.junit.Test

class RequestPlayersImpTest {

    private lateinit var requestPlayersImp: RequestPlayersImp
    private val footballServices: FootballServices = mock()
    private lateinit var domainMapper: DomainMapperEntityToDomain

    @Before
    fun setUp() {
        domainMapper = DomainMapperImp()
        requestPlayersImp = RequestPlayersImp(footballServices, domainMapper)
    }

    @Test
    fun `should return a list of empty player models when endpoint has no player data`() {
        // Arrange
        whenever(footballServices.getListOfPlayersByCountryId(BuildConfig.SPORTDATA_API_KEY, 42))
                .thenReturn(Single.just(PlayerDataModel(data = emptyList())))

        // Act
        val actualPlayerModel = requestPlayersImp.invoke(42)
                .test()

        // Assert
        actualPlayerModel.assertComplete()
        assertThat(actualPlayerModel.values().first()).isEmpty()
    }

    @Test
    fun `should return a list of player models when endpoint has player data`() {
        // Arrange
        val playerDataEntity = PlayerFactory.createPlayerDataModel()

        whenever(footballServices.getListOfPlayersByCountryId(BuildConfig.SPORTDATA_API_KEY, 42))
            .thenReturn(Single.just(playerDataEntity))

        // Act
        val actualPlayerModel = requestPlayersImp.invoke(42)
            .test()

        // Assert
        actualPlayerModel.assertComplete()
        val actualPlayerResults = actualPlayerModel.values().first()
        assertThat(actualPlayerResults[0].playerId).isEqualTo(playerDataEntity.data[0].playerId)
    }
}
