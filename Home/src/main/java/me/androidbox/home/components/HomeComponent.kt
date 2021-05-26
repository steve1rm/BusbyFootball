package me.androidbox.home.components

import dagger.Component
import me.androidbox.appdependencies.ApplicationDependencies
import me.androidbox.appdependencies.getApplicationDependencies
import me.androidbox.home.modules.HomeModule
import me.androidbox.home.screens.HomeFragment

@Component(dependencies = [ApplicationDependencies::class], modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(applicationDependencies: ApplicationDependencies): HomeComponent
    }
}

fun HomeFragment.inject() {
    DaggerHomeComponent.factory()
        .create(requireContext().getApplicationDependencies())
        .inject(this)
}
