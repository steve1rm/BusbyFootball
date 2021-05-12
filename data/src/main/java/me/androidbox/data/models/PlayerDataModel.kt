package me.androidbox.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class PlayerDataModel(
        val data: List<PlayerModel>
)
