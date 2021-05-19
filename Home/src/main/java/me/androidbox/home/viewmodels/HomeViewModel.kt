package me.androidbox.home.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import me.androidbox.domain.interactors.PlayersInteractor
import me.androidbox.home.items.PlayerItem
import me.androidbox.home.state.HomeViewState
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val playersInteractor: PlayersInteractor) : ViewModel() {

    private val homeViewStateMutableLiveData = MutableLiveData<HomeViewState>(HomeViewState.HomeViewStateLoading)
    val homeViewStateLiveData : LiveData<HomeViewState> = homeViewStateMutableLiveData

    init {
        playersInteractor.getListOfPlayersByCountryId(42)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateLoading
            }
            .subscribeBy(
                onSuccess = { listOfPlayerEntity ->
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

                    homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateLoaded(listOfPlayerItems)
                },
                onError = {
                    homeViewStateMutableLiveData.value = HomeViewState.HomeViewStateError(it.localizedMessage ?: "")
                }
            )
    }
}