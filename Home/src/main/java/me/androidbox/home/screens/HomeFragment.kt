package me.androidbox.home.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import me.androidbox.appdependencies.ApplicationDependencies
import me.androidbox.appdependencies.HasApplicationDependencies
import me.androidbox.di.viewmodels.ViewModelFactory
import me.androidbox.domain.entities.PlayerEntity
import me.androidbox.home.components.inject
import me.androidbox.home.listitems.ListItemPlayerController
import me.androidbox.home.databinding.FragmentHomeBinding
import me.androidbox.home.viewmodels.HomeViewModel
import javax.inject.Inject

class HomeFragment : Fragment(), HasApplicationDependencies {

    private lateinit var ListItemPlayerController: ListItemPlayerController
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
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

        val listOfPlayers = listOf(PlayerEntity(1, "steve", "mason", "23033", 34, 45, 65))

        ListItemPlayerController.setData(listOfPlayers)
    }

    override fun getApplicationDependencies(): ApplicationDependencies {
        TODO("Not yet implemented")
    }
}
