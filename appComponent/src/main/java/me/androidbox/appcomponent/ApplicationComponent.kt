package me.androidbox.appcomponent

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.androidbox.appdependencies.ApplicationDependencies
import me.androidbox.data.di.NetworkModule
import me.androidbox.data.di.PlayerModule
import javax.inject.Singleton

@Singleton
@Component(modules = [PlayerModule::class, NetworkModule::class])
interface ApplicationComponent : ApplicationDependencies {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}