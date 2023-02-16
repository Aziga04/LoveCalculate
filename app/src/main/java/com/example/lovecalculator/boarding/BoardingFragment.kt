package com.example.lovecalculator.boarding


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.boarding.adapter.BoardingAdapter
import com.example.lovecalculator.databinding.FragmentBoardingBinding
import dagger.hilt.android.AndroidEntryPoint


class  BoardingFragment : Fragment() {

    private lateinit var binding: FragmentBoardingBinding
    private lateinit var adapter: BoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = BoardingAdapter(this::onClick,requireContext())
        binding.viewPager.adapter = adapter
    }

    private fun onClick(){
        findNavController().navigateUp()
    }

}