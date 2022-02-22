package com.example.wormhole.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.wormhole.R
import com.example.wormhole.databinding.FragmentFinishBinding
import com.example.wormhole.databinding.FragmentGameBinding
import com.example.wormhole.viewModel.FinishViewModel
import com.example.wormhole.viewModel.GameViewModel

class FinishFragment : Fragment() {

    private lateinit var _viewModel: FinishViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val score = arguments?.getInt("score")
        val binding: FragmentFinishBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_finish, container, false)
        _viewModel = activity?.let { FinishViewModel(
            it.application,
            score!!,
            it.findNavController(R.id.main_nav_host)
        )}!!
        binding.viewmodel = _viewModel
        return binding.root
    }
}