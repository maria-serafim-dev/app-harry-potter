package com.example.appharrypotter.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.appharrypotter.core.State
import com.example.appharrypotter.databinding.FragmentCharacterListBinding
import com.example.appharrypotter.presentation.adapter.CharacterListAdapter
import com.example.appharrypotter.presentation.viewModel.CharacterViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val viewModel: CharacterViewModel by viewModel()
    private val adapter: CharacterListAdapter by inject()

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
        viewModel.state.observe(viewLifecycleOwner){ state ->
           if(state == State.EMPTY) setMessageEmptyList()
        }

        viewModel.characterList.observe(viewLifecycleOwner) { characterList ->
            adapter.submitList(characterList)
            stopShimmer()
        }

        viewModel.messageError.observe(viewLifecycleOwner){ message ->
            stopShimmer()
            Toast.makeText(context, message, Toast.LENGTH_LONG)
                .show()
        }
    }

    private fun setMessageEmptyList(){
        stopShimmer()
        binding.imgLogo.isVisible = true
        binding.tvMessage.isVisible = true
    }

    private fun setAdapter() {
        binding.recyclerCharacterList.adapter = adapter
    }

    private fun stopShimmer() {
        binding.shimmerViewContainer.stopShimmer()
        binding.shimmerViewContainer.visibility = View.GONE
    }

    private fun startShimmer() {
        binding.shimmerViewContainer.startShimmer()
    }
}