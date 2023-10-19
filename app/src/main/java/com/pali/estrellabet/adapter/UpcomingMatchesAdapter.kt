package com.pali.estrellabet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pali.estrellabet.databinding.ItemUpcomingMatchBinding
import com.pali.estrellabet.model.UpcomingMatchModel
import kotlin.math.min

class UpcomingMatchesAdapter(
    private val dataList: List<UpcomingMatchModel>,
    private val visibleItemCount: Int,
    private val clickListener: UpcomingMatchClickListener
) : RecyclerView.Adapter<UpcomingMatchesAdapter.UpcomingMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMatchViewHolder {
        val binding =
            ItemUpcomingMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingMatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingMatchViewHolder, position: Int) {
        if (position < visibleItemCount) {
            val match = dataList[position]
            holder.bind(match)
        } else {
            holder.hide()
        }
    }

    override fun getItemCount(): Int {
        return min(visibleItemCount, dataList.size)
    }

    inner class UpcomingMatchViewHolder(private val binding: ItemUpcomingMatchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = dataList[position]
                    clickListener.onUpcomingMatchClick(clickedItem)
                }
            }
        }

        fun bind(match: UpcomingMatchModel) {
            binding.team1NameTextView.text = match.team1Name
            binding.team2NameTextView.text = match.team2Name

            Glide.with(binding.root)
                .load(match.team1Img)
                .into(binding.team1ImageView)

            Glide.with(binding.root)
                .load(match.team2Img)
                .into(binding.team2ImageView)
        }

        fun hide() {
            binding.root.visibility = View.GONE
        }
    }
}

interface UpcomingMatchClickListener {
    fun onUpcomingMatchClick(match: UpcomingMatchModel)
}
