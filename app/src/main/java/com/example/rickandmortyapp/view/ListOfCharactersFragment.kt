package com.example.rickandmortyapp.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapp.databinding.FragmentListOfCharactersBinding
import com.example.rickandmortyapp.model.CharactersModel
import com.example.rickandmortyapp.view.adapters.PagedListAdapterRickAndMorty
import com.example.rickandmortyapp.viewmodel.ListOfCharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListOfCharactersFragment : Fragment() {
    private lateinit var binding: FragmentListOfCharactersBinding
    private val groupOfCharacters = arrayListOf<CharactersModel>()
    private val viewModel: ListOfCharactersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListOfCharactersBinding.inflate(inflater, container, false)

        initViewModel()

        return binding.root
    }

    private fun initViewModel(){
        viewModel.initViewModel()
        observeListOfCharacters()

    }
    private fun populateRecyclerView() {
        binding.recyclerviewListOfCharacters.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = getAdapterRecyclerView()
        }
    }

    private fun getAdapterRecyclerView(): PagedListAdapterRickAndMorty {
        return PagedListAdapterRickAndMorty(groupOfCharacters, activity?.applicationContext as Context)
    }

    private fun observeListOfCharacters() {
        viewModel.pagedList.observe(viewLifecycleOwner) {
            with(groupOfCharacters) {
                clear()
                addAll(it)
            }
            populateRecyclerView()

        }
    }
}