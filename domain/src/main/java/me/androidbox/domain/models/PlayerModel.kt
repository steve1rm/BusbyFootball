package me.androidbox.domain.models

data class PlayerModel(
    val playerId: Int,
    val firstname: String,
    val lastname: String,
    val birthday: String,
    val age: Int,
    val weight: Int,
    val height: Int,
)
