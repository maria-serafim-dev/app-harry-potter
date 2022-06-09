package com.example.appharrypotter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.appharrypotter.adapter.ListaPersonagemAdapter
import com.example.appharrypotter.databinding.FragmentListaPersonagensBinding
import com.example.appharrypotter.viewModel.PersonagensViewModel

class ListaPersonagensFragment : Fragment() {

    private var _binding : FragmentListaPersonagensBinding? = null
    private val binding get() = _binding!!
    private val viewModel : PersonagensViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaPersonagensBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarRecycler()
    }

    private fun iniciarRecycler() {
        viewModel.listaPersonagens.observe(viewLifecycleOwner) {
            val adapter = ListaPersonagemAdapter()
            adapter.submitList(it)
            binding.recyclerListaPersonagens.adapter = adapter
        }
    }
}