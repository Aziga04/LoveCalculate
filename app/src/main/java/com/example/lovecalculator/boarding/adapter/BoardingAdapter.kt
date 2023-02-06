package com.example.lovecalculator.boarding.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.lovecalculator.Prefs
import com.example.lovecalculator.boarding.OnBoard
import com.example.lovecalculator.databinding.ItemBoardingBinding


class BoardingAdapter(
    private val onClick: () -> Unit
) : RecyclerView.Adapter<BoardingAdapter.OnBoardingViewHolder>() {


    private val list = arrayListOf(
        OnBoard("", "Have a Good time"),
        OnBoard("", "Cherishing love"),
        OnBoard("", "Have a breakup?"),
        OnBoard("", "Test your love")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class OnBoardingViewHolder(val binding: ItemBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            binding.ivBoarding.load( onBoard.image)
            binding.tvSkip.setOnClickListener{
                onClick()
            }
        }

    }
}