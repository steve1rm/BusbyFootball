package me.androidbox.home.components

import dagger.Component
import me.androidbox.appdependencies.ApplicationDependencies
import me.androidbox.appdependencies.getApplicationDependencies
import me.androidbox.di.components.getComponent
import me.androidbox.di.scope.ScreenScope
import me.androidbox.home.modules.HomeModule
import me.androidbox.home.screens.HomeFragment

@ScreenScope
@Component(dependencies = [ApplicationDependencies::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(applicationDependencies: ApplicationDependencies): HomeComponent
    }
}

fun HomeFragment.inject() {
    getComponent {
        DaggerHomeComponent.factory()
            .create(requireContext().getApplicationDependencies())
    }.inject(this)
}
