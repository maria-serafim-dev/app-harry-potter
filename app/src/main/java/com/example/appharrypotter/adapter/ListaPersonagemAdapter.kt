package com.example.appharrypotter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appharrypotter.R
import com.example.appharrypotter.databinding.ItemPersonagensBinding
import com.example.appharrypotter.model.Personagem

class ListaPersonagemAdapter :
    ListAdapter<Personagem, ListaPersonagemAdapter.ListaPersonagemViewHolder>(PersonagemCallback()) {

    private lateinit var binding: ItemPersonagensBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaPersonagemViewHolder {
        binding = ItemPersonagensBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaPersonagemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListaPersonagemViewHolder, position: Int) {
        val personagem = getItem(position)
        holder.onBind(personagem)
    }


    inner class ListaPersonagemViewHolder(private val binding: ItemPersonagensBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(personagem: Personagem) {
            with(binding) {
                tvCasa.text = personagem.house
                tvNome.text = personagem.name
                if (personagem.image.isEmpty()) {
                    binding.imgPersonagem.setImageResource(R.drawable.ic_imagem_quebrada)
                } else {
                    Glide.with(binding.imgPersonagem.context).load(personagem.image).into(binding.imgPersonagem)
                }
            }
        }
    }
}

class PersonagemCallback : DiffUtil.ItemCallback<Personagem>() {
    override fun areItemsTheSame(oldItem: Personagem, newItem: Personagem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Personagem, newItem: Personagem): Boolean {
        return oldItem.name == newItem.name
    }

}
