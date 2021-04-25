package me.androidbox.data.mappers.imp

import me.androidbox.data.entities.PlayerDataModel
import me.androidbox.data.entities.PlayerModel
import me.androidbox.data.mappers.DomainMapperEntityToDomain
import me.androidbox.domain.models.PlayerEntity
import javax.inject.Inject

class DomainMapperImp @Inject constructor(): DomainMapperEntityToDomain {

    override fun mapToDomain(model: PlayerDataModel): List<PlayerEntity> {
        val listOfPlayers = mutableListOf<PlayerEntity>()

        model.data.map {
            listOfPlayers.add(modelToEntity(it))
        }

        return listOfPlayers.toList()
    }

    private fun modelToEntity(playerModel: PlayerModel): PlayerEntity {
        return PlayerEntity(
            playerModel.playerId,
            playerModel.firstName ?: "",
            playerModel.lastName ?: "",
            playerModel.birthday ?: "",
            playerModel.age ?: 0,
            playerModel.weight ?: 0,
            playerModel.height ?: 0
        )
    }

    /** Usage:
     *  return entity.data.map(::entityToModelList).first()
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
    */
}
