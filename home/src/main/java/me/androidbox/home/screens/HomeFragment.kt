package me.androidbox.home.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import me.androidbox.di.viewmodels.ViewModelFactory
import me.androidbox.home.components.inject
import me.androidbox.home.databinding.FragmentHomeBinding
import me.androidbox.home.listitems.ListItemPlayerController
import me.androidbox.home.state.HomeViewState
import me.androidbox.home.viewmodels.HomeViewModel
import javax.inject.Inject

class HomeFragment : Fragment() {

    private lateinit var ListItemPlayerController: ListItemPlayerController
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        inject()

        ListItemPlayerController = ListItemPlayerController()

        with(fragmentHomeBinding.rvFootballList) {
            adapter = ListItemPlayerController.adapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        }

        homeViewModel.homeViewStateLiveData.observe(viewLifecycleOwner, { homeViewState: HomeViewState ->
            when(homeViewState) {
                HomeViewState.HomeViewStateLoading -> {
                    Log.d(HomeFragment::class.simpleName, "Loading")
                }
                is HomeViewState.HomeViewStateLoaded -> {
                    ListItemPlayerController.setData(homeViewState.listOfPlayers)
                }
                is HomeViewState.HomeViewStateError -> {
                    Log.d(HomeFragment::class.simpleName, homeViewState.message)
                }
            }
        })
    }
}
