package me.androidbox.home.state

import me.androidbox.home.items.PlayerItem

sealed class HomeViewState {
    object HomeViewStateLoading : HomeViewState()
    class HomeViewStateLoaded(val listOfPlayers: List<PlayerItem>) : HomeViewState()
    class HomeViewStateError(val message: String): HomeViewState()
}
