package me.androidbox.home.modules

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.androidbox.data.requests.imp.RequestPlayersImp
import me.androidbox.di.annotations.ViewModelKey
import me.androidbox.domain.interactors.PlayersInteractor
import me.androidbox.home.viewmodels.HomeViewModel

@Module
interface HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    fun bindPlayersInteractor(requestPlayersImp: RequestPlayersImp): PlayersInteractor

    companion object {
        /** provide methods go here */
    }
}
