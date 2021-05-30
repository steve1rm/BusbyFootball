package me.androidbox.testing.app.runner

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import me.androidbox.testing.app.component.TestApplication

class BusbyFootballTestRunner : AndroidJUnitRunner() {
    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {
        return super.newApplication(cl, TestApplication::class.java.name, context)
    }
}