package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import retrofit2.Callback
import retrofit2.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentCalculatorBinding
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import com.example.lovecalculator.viewmodel.LoveViewModel
import retrofit2.Response



class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private val viewModel : LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculatorBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                viewModel.getLiveLove(firstNameEd.text.toString(),secondNameEd.text.toString()).observe(
                    viewLifecycleOwner, Observer {
                        findNavController().navigate(R.id.resultFragment, bundleOf("key" to (it?.percentage
                                )))
                    }
                )
            }
        }
    }

}