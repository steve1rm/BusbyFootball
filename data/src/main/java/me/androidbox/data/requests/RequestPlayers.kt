package me.androidbox.data.requests

import me.androidbox.data.entities.PlayerEntity

interface RequestPlayers {
    fun requestPlayers(): List<PlayerEntity>
}
