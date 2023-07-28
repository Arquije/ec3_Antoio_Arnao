package com.antonio.ec3_dam2_antonio_arnao.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.antonio.ec3_dam2_antonio_arnao.R
import com.antonio.ec3_dam2_antonio_arnao.databinding.FragmentFavoritBinding
import com.antonio.ec3_dam2_antonio_arnao.model.BasketballViewModel
import com.antonio.ec3_dam2_antonio_arnao.model.BasketballViewModelFactory
import com.antonio.ec3_dam2_antonio_arnao.repository.BasketballRepository
import com.antonio.ec3_dam2_antonio_arnao.retrofit.BasketballApiService
import com.bumptech.glide.Glide
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FavoritFragment : Fragment() {
    private var _binding: FragmentFavoritBinding? = null
    private val binding get() = _binding!!

    private val BASE_URL = "https://www.balldontlie.io/api/v1/"

    private val basketballApiService: BasketballApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BasketballApiService::class.java)
    }

    private val basketballRepository: BasketballRepository by lazy {
        BasketballRepository(apiService = basketballApiService)
    }

    private val basketballViewModel: BasketballViewModel by viewModels {
        BasketballViewModelFactory(basketballRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        basketballViewModel.getPlayers()

        basketballViewModel.players.observe(viewLifecycleOwner) { players ->

            if (players.isNotEmpty()) {
                val player = players[0]
                binding.nombrejugador.text = "Nombre: ${player.first_name} ${player.last_name}"
                binding.posicion.text = "Posicion: " + player.position
                binding.equipo.text = "Equipo: " + player.team.full_name

                Glide.with(this).load(R.drawable.basket2).into(binding.imgJugador)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
