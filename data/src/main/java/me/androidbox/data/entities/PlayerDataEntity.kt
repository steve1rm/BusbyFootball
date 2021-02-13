package me.androidbox.data.entities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PlayerDataEntity(
        val data: List<PlayerEntity>
)
