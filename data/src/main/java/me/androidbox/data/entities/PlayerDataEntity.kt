package me.androidbox.data.entities

import com.squareup.moshi.JsonClass
import javax.inject.Inject

@JsonClass(generateAdapter = true)
class PlayerDataEntity(
        val data: List<PlayerEntity>
)
