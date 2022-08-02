package com.example.appharrypotter.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.appharrypotter.databinding.ItemCharacterBinding
import com.example.appharrypotter.core.extensions.loadImage
import com.example.appharrypotter.data.model.Character

class CharacterListAdapter :
    ListAdapter<Character, CharacterListAdapter.CharacterListViewHolder>(CharacterCallback()) {

    private lateinit var binding: ItemCharacterBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val character = getItem(position)
        holder.onBind(character)
    }


    inner class CharacterListViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(character: Character) {
            with(binding) {
                tvHome.text = character.house
                tvName.text = character.name
                imgCharacter.loadImage(character.image)
            }
        }
    }
}

class CharacterCallback : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

}
