package me.androidbox.testing.app.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.androidbox.appcomponent.ApplicationComponent
import me.androidbox.testing.app.modules.TestDataModule
import javax.inject.Singleton

@Singleton
@Component(modules = [TestDataModule::class])
interface TestApplicationComponent : ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): TestApplicationComponent
    }
}