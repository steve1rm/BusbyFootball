package me.androidbox.data.mappers

import me.androidbox.data.entities.PlayerDataModel
import me.androidbox.domain.models.PlayerEntity

interface DomainMapperEntityToDomain : DomainMapper<PlayerDataModel, List<PlayerEntity>>
