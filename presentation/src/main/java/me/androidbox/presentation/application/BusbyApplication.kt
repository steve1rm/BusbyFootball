package me.androidbox.presentation.application

import android.app.Application
import me.androidbox.appdependencies.ApplicationDependencies
import me.androidbox.appdependencies.HasApplicationDependencies

class BusbyApplication : Application(), HasApplicationDependencies {

    private val applicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun getApplicationDependencies(): ApplicationDependencies {
        return applicationComponent
    }
}