package me.androidbox.data.mockdata

import java.util.*
import kotlin.random.Random

object RandomDataFactory {

    fun string(): String = UUID.randomUUID().toString()

    fun int(): Int = Random.nextInt()

    fun float(): Float = Random.nextFloat()

    fun boolean(): Boolean = Random.nextBoolean()
}
