package me.androidbox.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PlayerModel(
        @Json(name = "player_id")
        val playerId: Int,
        @Json(name = "firstname")
        val firstName: String?,
        @Json(name = "lastname")
        val lastName: String?,
        val birthday: String?,
        val age: Int?,
        val weight: Int?,
        val height: Int?,
)
