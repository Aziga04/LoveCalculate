package com.example.lovecalculator.boarding


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.boarding.adapter.BoardingAdapter
import com.example.lovecalculator.databinding.FragmentBoardingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardingFragment : Fragment() {
    private lateinit var binding: FragmentBoardingBinding
    private lateinit var adapter: BoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardingBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}