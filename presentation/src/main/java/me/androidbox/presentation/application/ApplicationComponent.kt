package me.androidbox.presentation.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.androidbox.data.di.PlayerModule
import me.androidbox.data.requests.imp.RequestPlayersImp
import javax.inject.Singleton

@Singleton
@Component(modules = [PlayerModule::class])
interface ApplicationComponent {

    fun requestPlayersImp(): RequestPlayersImp

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}