package me.androidbox.domain.models

data class PlayerEntity(
    val playerId: Int,
    val firstName: String,
    val lastName: String,
    val birthday: String,
    val age: Int,
    val weight: Int,
    val height: Int,
)
