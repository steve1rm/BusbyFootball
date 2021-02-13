package me.androidbox.data.mappers

interface DomainMapper<in E, out D> {
    fun mapToDomain(entity: E): D
}
