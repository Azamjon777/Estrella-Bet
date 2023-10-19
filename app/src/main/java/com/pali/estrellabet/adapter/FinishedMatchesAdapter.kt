package com.pali.estrellabet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pali.estrellabet.R
import com.pali.estrellabet.databinding.ItemFinishedLayoutBinding
import com.pali.estrellabet.model.FinishedModel

interface FinishedMatchClickListener {
    fun onFinishedMatchClicked(match: FinishedModel)
}

class FinishedMatchesAdapter(
    private val data: List<FinishedModel>,
    private val clickListener: FinishedMatchClickListener
) : RecyclerView.Adapter<FinishedMatchesAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemFinishedLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = data[position] // Получаем элемент по позиции
                    clickListener.onFinishedMatchClicked(clickedItem)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFinishedLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]

        Glide.with(holder.binding.root.context)
            .load(currentItem.firstTeamImgUrl)
            .error(R.drawable.test)
            .into(holder.binding.firstTeamImg)

        Glide.with(holder.binding.root.context)
            .load(currentItem.secondTeamImgUrl)
            .error(R.drawable.test)
            .into(holder.binding.secondTeamImg)

        holder.binding.scorersFirstTeam.text = currentItem.scorersFirstTeam
        holder.binding.scorersSecondTeam.text = currentItem.scorersSecondTeam
        holder.binding.totalScore.text = currentItem.totalScore
    }

    override fun getItemCount() = data.size
}
//package:com.pali.estrellabet это для logcat