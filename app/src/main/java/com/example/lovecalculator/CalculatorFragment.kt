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
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentCalculatorBinding
import retrofit2.Response



class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding

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
                RetrofitService().api.calculateLove(
                    firstNameEd.text.toString(),
                    secondNameEd.text.toString()
                )
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful) {
                                findNavController().navigate(R.id.resultFragment, bundleOf("key" to (response.body()?.percentage
                                        )))
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.e("ololo", "OnFailure ${t.message}")
                        }

                    })
            }
        }
    }

}