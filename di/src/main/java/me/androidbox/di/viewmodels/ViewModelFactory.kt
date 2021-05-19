package me.androidbox.di.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Provider


class ViewModelFactory @Inject constructor(
    private val classToViewModel: @JvmSuppressWildcards Map<Class<out  ViewModel>, Provider<ViewModel>>)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return classToViewModel[modelClass]?.get() as? T ?: throw Exception("Cannot find model class ${modelClass.name}")
    }
}