package com.example.wormhole.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.wormhole.R
import com.example.wormhole.databinding.FragmentGameBinding
import com.example.wormhole.viewModel.GameViewModel


class GameFragment : Fragment() {
    private lateinit var _viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGameBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_game, container, false)
        _viewModel = activity?.let { GameViewModel(
            it.application,
            it.findNavController(R.id.main_nav_host),
            binding.constraintLayout
        ) }!!
        binding.viewmodel = _viewModel
        return binding.root
    }

}