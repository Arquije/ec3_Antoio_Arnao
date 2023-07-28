package com.antonio.ec3_dam2_antonio_arnao.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.antonio.ec3_dam2_antonio_arnao.adapter.PlayersAdapter
import com.antonio.ec3_dam2_antonio_arnao.databinding.FragmentBasketballBinding
import com.antonio.ec3_dam2_antonio_arnao.model.BasketballViewModel
import com.antonio.ec3_dam2_antonio_arnao.model.BasketballViewModelFactory
import com.antonio.ec3_dam2_antonio_arnao.repository.BasketballRepository
import com.antonio.ec3_dam2_antonio_arnao.retrofit.BasketballApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BasketballFragment : Fragment() {
    private lateinit var binding: FragmentBasketballBinding
    private val apiService = Retrofit.Builder()
        .baseUrl("https://www.balldontlie.io/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BasketballApiService::class.java)
    private val repository = BasketballRepository(apiService)
    private val viewModel by viewModels<BasketballViewModel> { BasketballViewModelFactory(repository) }
    private val playersAdapter = PlayersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBasketballBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.playersRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.playersRecyclerView.adapter = playersAdapter
        viewModel.players.observe(viewLifecycleOwner) { players ->
            playersAdapter.players = players
        }
        viewModel.getPlayers()
    }
}




