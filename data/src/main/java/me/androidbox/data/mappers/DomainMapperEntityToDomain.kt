package me.androidbox.data.mappers

import me.androidbox.data.models.PlayerDataModel
import me.androidbox.domain.entities.PlayerEntity

interface DomainMapperEntityToDomain : DomainMapper<PlayerDataModel, List<PlayerEntity>>
