package com.example.appharrypotter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.appharrypotter.adapter.CharacterListAdapter
import com.example.appharrypotter.databinding.FragmentCharacterListBinding
import com.example.appharrypotter.viewModel.CharacterViewModel

class CharacterListFragment : Fragment() {

    private lateinit var binding : FragmentCharacterListBinding
    private val viewModel : CharacterViewModel by viewModels()
    private val adapter : CharacterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startShimmer()
        observeChanges()
        setAdapter()
    }

    private fun observeChanges() {
        viewModel.characterList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setAdapter() {
        binding.recyclerCharacterList.adapter = adapter
        stopShimmer()
    }

    private fun stopShimmer() {
        binding.shimmerViewContainer.stopShimmer()
        binding.shimmerViewContainer.visibility = View.GONE
    }

    private fun startShimmer() {
        binding.shimmerViewContainer.startShimmer()
    }
}