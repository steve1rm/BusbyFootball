package me.androidbox.data.mappers

interface EntityMapper<in D, out E> {
    fun mapToEntity(domain: D) : E
}
