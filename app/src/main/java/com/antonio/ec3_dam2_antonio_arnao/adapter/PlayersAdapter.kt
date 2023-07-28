package com.antonio.ec3_dam2_antonio_arnao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.antonio.ec3_dam2_antonio_arnao.R
import com.antonio.ec3_dam2_antonio_arnao.databinding.ItemPlayerBinding
import com.antonio.ec3_dam2_antonio_arnao.model.Player
import com.bumptech.glide.Glide

class PlayersAdapter : RecyclerView.Adapter<PlayersAdapter.ViewHolder>() {
    var players = listOf<Player>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class ViewHolder(val binding: ItemPlayerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = players[position]
        holder.binding.nombrejugador.text = "Nombre: " + "${player.first_name}" + "${player.last_name}"
        holder.binding.posicion.text = "Posicion: " + player.position
        holder.binding.equipo.text = "Equipo: " + player.team.full_name
        Glide.with(holder.itemView)
            .load(R.drawable.basket)
            .into(holder.binding.imgJugador)
    }

    override fun getItemCount() = players.size
}

