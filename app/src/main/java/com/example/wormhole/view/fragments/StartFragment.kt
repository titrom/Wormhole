package com.example.wormhole.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.wormhole.R
import com.example.wormhole.databinding.FragmentStartBinding
import com.example.wormhole.viewModel.StartViewModel

class StartFragment : Fragment() {

    private lateinit var _viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentStartBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_start, container, false)
        _viewModel = activity?.let { StartViewModel(it.application,
            it.findNavController(R.id.main_nav_host)) }!!
        binding.viewmodel = _viewModel
        return binding.root
    }
}