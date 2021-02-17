package me.androidbox.data.mappers.imp

import com.google.common.truth.Truth.assertThat
import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.data.mockdata.PlayerFactory
import org.junit.Before
import org.junit.Test

class DomainMapperImpTest {

    private lateinit var domainMapperImp: DomainMapperImp

    @Before
    fun setUp() {
        domainMapperImp = DomainMapperImp()
    }

    @Test
    fun `should return a list of empty list of playerModel when there are no player entities`() {
        // Arrange
        val playerDataEntity = PlayerDataEntity(emptyList())

        // Act
        val actualPlayerModel = domainMapperImp.mapToDomain(playerDataEntity)

        // Assert
        assertThat(actualPlayerModel).isEmpty()
    }

    @Test
    fun `should return a list of playerModel when there are player entities`() {
        // Arrange
        val playerDataEntity = PlayerFactory.createPlayerDataEntity()

        // Act
        val actualPlayerModel = domainMapperImp.mapToDomain(playerDataEntity)

        // Assert
        assertThat(actualPlayerModel.count()).isEqualTo(3)
        assertThat(actualPlayerModel.first().playerId).isEqualTo(playerDataEntity.data.first().playerId)
        assertThat(actualPlayerModel.first().firstname).isEqualTo(playerDataEntity.data.first().firstName)
        assertThat(actualPlayerModel.first().lastname).isEqualTo(playerDataEntity.data.first().lastName)
        assertThat(actualPlayerModel.first().birthday).isEqualTo(playerDataEntity.data.first().birthday)
        assertThat(actualPlayerModel.first().age).isEqualTo(playerDataEntity.data.first().age)
        assertThat(actualPlayerModel.first().weight).isEqualTo(playerDataEntity.data.first().weight)
        assertThat(actualPlayerModel.first().height).isEqualTo(playerDataEntity.data.first().height)
    }

    @Test
    fun `should return a list of empty list of playerModel when there are player entities `() {
        // Arrange
        val playerDataEntity = PlayerFactory.createPlayerDataEntityNullValues()

        // Act
        val actualPlayerModel = domainMapperImp.mapToDomain(playerDataEntity)

        // Assert
        assertThat(actualPlayerModel.count()).isEqualTo(3)
        assertThat(actualPlayerModel.first().playerId).isEqualTo(playerDataEntity.data.first().playerId)
        assertThat(actualPlayerModel.first().firstname).isEmpty()
        assertThat(actualPlayerModel.first().lastname).isEmpty()
        assertThat(actualPlayerModel.first().birthday).isEmpty()
        assertThat(actualPlayerModel.first().age).isEqualTo(0)
        assertThat(actualPlayerModel.first().weight).isEqualTo(0)
        assertThat(actualPlayerModel.first().height).isEqualTo(0)
    }
}