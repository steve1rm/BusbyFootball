package me.androidbox.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import me.androidbox.domain.entities.PlayerEntity
import me.androidbox.home.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var ListItemPlayerController: ListItemPlayerController
    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ListItemPlayerController= ListItemPlayerController()

        with(fragmentHomeBinding.rvFootballList) {
            adapter = ListItemPlayerController.adapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
        }

        val listOfPlayers = listOf(PlayerEntity(1, "steve", "mason", "23033", 34, 45, 65))

        ListItemPlayerController.setData(listOfPlayers)
    }
}
