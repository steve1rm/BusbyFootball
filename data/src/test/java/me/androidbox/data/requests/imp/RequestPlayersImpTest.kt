package me.androidbox.data.requests.imp


import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Single
import me.androidbox.data.BuildConfig
import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.data.mappers.DomainMapper
import me.androidbox.data.mappers.imp.DomainMapperImp
import me.androidbox.data.service.FootballServices
import me.androidbox.domain.models.PlayerModel
import org.junit.Before
import org.junit.Test

class RequestPlayersImpTest {

    private lateinit var requestPlayersImp: RequestPlayersImp
    private val footballServices: FootballServices = mock()
    private lateinit var domainMapper: DomainMapper<PlayerDataEntity, List<PlayerModel>>

    @Before
    fun setUp() {
        domainMapper = DomainMapperImp()
        requestPlayersImp = RequestPlayersImp(footballServices, domainMapper)
    }

    @Test
    fun `should return a list of player models when footballs has no player data`() {
        // Arrange
        whenever(footballServices.getListOfPlayersByCountryId(BuildConfig.SPORTDATA_API_KEY, 42))
                .thenReturn(Single.just(PlayerDataEntity(data = emptyList())))

        // Act
        val actualPlayerModel = requestPlayersImp.invoke()
                .test()

        // Assert
        actualPlayerModel.assertComplete()
        assertThat(actualPlayerModel.values().first()).isEmpty()
    }
}
