package me.androidbox.domain.entities

data class PlayerEntity(
    val playerId: Int,
    val firstName: String,
    val lastName: String,
    val birthday: String,
    val age: Int,
    val weight: Int,
    val height: Int,
)
