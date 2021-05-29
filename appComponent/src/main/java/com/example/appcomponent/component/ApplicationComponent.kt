package me.androidbox.appcomponent.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.androidbox.appdependencies.ApplicationDependencies
import me.androidbox.data.di.PlayerModule
import javax.inject.Singleton

@Singleton
@Component(modules = [PlayerModule::class])
interface ApplicationComponent : ApplicationDependencies {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }
}