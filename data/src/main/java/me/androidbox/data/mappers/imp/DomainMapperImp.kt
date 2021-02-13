package me.androidbox.data.mappers.imp

import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.data.mappers.DomainMapper
import me.androidbox.domain.models.PlayerModel

class DomainMapperImp : DomainMapper<PlayerDataEntity, List<PlayerModel>> {

    override fun mapToDomain(entity: PlayerDataEntity): List<PlayerModel> {
        val listOfPlayers = mutableListOf<PlayerModel>()

        entity.data.map {
            listOfPlayers.add(PlayerModel(
                    it.playerId,
                    it.firstName ?: "",
                    it.lastName ?: "",
                    it.birthday ?: "",
                    it.age ?: 0,
                    it.weight ?: 0,
                    it.height ?: 0
            ))
        }

        return listOfPlayers.toList()
    }
}
