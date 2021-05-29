package me.androidbox.appdependencies

import android.content.Context
import me.androidbox.data.requests.imp.RequestPlayersImp

interface ApplicationDependencies {
    fun getRequestPlayers(): RequestPlayersImp
}

fun Context.getApplicationDependencies(): ApplicationDependencies {
    return (applicationContext as? HasApplicationDependencies)?.getApplicationDependencies()
        ?: throw IllegalStateException("Application must implement `HasApplicationDependencies`")
}
