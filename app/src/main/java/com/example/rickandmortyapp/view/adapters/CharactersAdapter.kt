package com.example.rickandmortyapp.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.CharacterCardInfoBinding
import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.utils.CharacterInformationUtils
import com.example.rickandmortyapp.utils.CharacterStatusManagerImplementation
import com.squareup.picasso.Picasso

class CharactersAdapter(
    private val groupOfCharacters:List<CharactersModel>,
    private val context: Context
):RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private val binding = CharacterCardInfoBinding.bind(itemView)

        fun bindViewHolder(character:CharactersModel) {
            binding.tvCharacterCardName.text = character.name
            binding.tvCharacterCardGender.text = character.gender
            binding.tvCharacterCardSpecie.text = character.species

            binding.ivCharacterCardStatus.setImageDrawable(
                context.getDrawable(statusToIcon(character.status))
            )

            Picasso.get()
                .load(character.image)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .into(binding.ivCharacterCardIcon)
        }

        private fun statusToIcon(status:String):Int =
            CharacterInformationUtils(CharacterStatusManagerImplementation())
                .getCharacterStatusIcon(status.uppercase())
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_card_info, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewHolder(groupOfCharacters[position])
    }

    override fun getItemCount(): Int = groupOfCharacters.size
}