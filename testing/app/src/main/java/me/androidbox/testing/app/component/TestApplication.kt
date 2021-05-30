package me.androidbox.testing.app.component

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import me.androidbox.appdependencies.ApplicationDependencies
import me.androidbox.appdependencies.HasApplicationDependencies

class TestApplication : Application(), HasApplicationDependencies {

    companion object {
        val testApplicationComponent: TestApplicationComponent
        get() = (InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApplication).testApplicationComponent
    }

    private lateinit var testApplicationComponent: TestApplicationComponent

    override fun onCreate() {
        super.onCreate()
        testApplicationComponent = DaggerTestApplicationComponent.factory().create(this)
    }

    override fun getApplicationDependencies(): ApplicationDependencies {
        return testApplicationComponent
    }
}