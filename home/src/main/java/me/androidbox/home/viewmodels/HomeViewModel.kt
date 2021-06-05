package me.androidbox.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch
import me.androidbox.di.scope.ScreenScope
import me.androidbox.domain.interactors.PlayersInteractor
import me.androidbox.home.items.PlayerItem
import me.androidbox.home.state.HomeViewState
import javax.inject.Inject


/** TODO Write unit test 25 */
@ScreenScope
class HomeViewModel @Inject constructor(playersInteractor: PlayersInteractor) : ViewModel() {

    private val homeViewStateMutableLiveData = MutableLiveData<HomeViewState>(HomeViewState.HomeViewStateLoading)
    val homeViewStateLiveData : LiveData<HomeViewState> = homeViewStateMutableLiveData

    init {
        viewModelScope.launch {
            homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateLoading
            try {
                val listOfPlayerEntity = playersInteractor.getListOfPlayersByCountryId(42)
                val listOfPlayerItems = mutableListOf<PlayerItem>()

                listOfPlayerEntity.map { playerEntity ->
                    listOfPlayerItems.add(PlayerItem(
                        playerEntity.playerId,
                        playerEntity.firstName,
                        playerEntity.lastName,
                        playerEntity.birthday,
                        playerEntity.age,
                        playerEntity.weight,
                        playerEntity.height))
                }

                homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateLoaded(listOfPlayerItems)
            }
            catch (exception: Exception) {
                homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateError(exception.localizedMessage ?: "Unknown")
            }
        }
/*

        playersInteractor.getListOfPlayersByCountryId(42)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateLoading
            }
            .subscribeBy(
                onSuccess = { listOfPlayerEntity ->
                    val listOfPlayerItems = mutableListOf<PlayerItem>()

                    listOfPlayerEntity.map { playerEntity ->
                        listOfPlayerItems.add(PlayerItem(
                            playerEntity.playerId,
                            playerEntity.firstName,
                            playerEntity.lastName,
                            playerEntity.birthday,
                            playerEntity.age,
                            playerEntity.weight,
                            playerEntity.height))
                    }

                    homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateLoaded(listOfPlayerItems)
                },
                onError = {
                    homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateError(it.localizedMessage ?: "")
                }
            )
*/
    }
}

/* FIXME Not creating a list
                    val listOfPlayerItems = generateSequence {
                        listOfPlayerEntity.map { playerEntity ->
                            PlayerItem(
                                playerEntity.playerId,
                                playerEntity.firstName,
                                playerEntity.lastName,
                                playerEntity.birthday,
                                playerEntity.age,
                                playerEntity.weight,
                                playerEntity.height)
                        }
                    }.toList().flatten()
*/
