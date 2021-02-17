package me.androidbox.data.mappers.imp

import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.data.entities.PlayerEntity
import me.androidbox.data.mappers.DomainMapper
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.domain.models.PlayerModel
import javax.inject.Inject

class DomainMapperImp @Inject constructor(): DomainMapperEntityToDomain {

    override fun mapToDomain(entity: PlayerDataEntity): List<PlayerModel> {
        val listOfPlayers = mutableListOf<PlayerModel>()

        entity.data.map {
            listOfPlayers.add(entityToModel(it))
        }

        return listOfPlayers.toList()
    }

    private fun entityToModel(playerEntity: PlayerEntity): PlayerModel {
        return PlayerModel(
            playerEntity.playerId,
            playerEntity.firstName ?: "",
            playerEntity.lastName ?: "",
            playerEntity.birthday ?: "",
            playerEntity.age ?: 0,
            playerEntity.weight ?: 0,
            playerEntity.height ?: 0
        )
    }

    /** Usage:
     *  return entity.data.map(::entityToModelList).first() */
    private fun entityToModelList(playerEntity: PlayerEntity): List<PlayerModel> {
        val listOfPlayers = mutableListOf<PlayerModel>()

         listOfPlayers.add(PlayerModel(
            playerEntity.playerId,
            playerEntity.firstName ?: "",
            playerEntity.lastName ?: "",
            playerEntity.birthday ?: "",
            playerEntity.age ?: 0,
            playerEntity.weight ?: 0,
            playerEntity.height ?: 0
        ))

        return listOfPlayers.toList()
    }
}
