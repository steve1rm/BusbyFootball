package me.androidbox.data.mappers

import me.androidbox.data.entities.PlayerDataEntity
import me.androidbox.domain.models.PlayerModel

interface DomainMapperEntityToDomain : DomainMapper<PlayerDataEntity, List<PlayerModel>>
