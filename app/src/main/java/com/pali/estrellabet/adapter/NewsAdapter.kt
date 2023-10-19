package com.pali.estrellabet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pali.estrellabet.databinding.ItemNewsBinding
import com.pali.estrellabet.model.NewsModel

class NewsAdapter(
    private val newsList: List<NewsModel>,
    private val clickListener: NewsItemClickListener
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.bind(newsItem)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedItem = newsList[position]
                    clickListener.onNewsItemClick(clickedItem)
                }
            }
        }

        fun bind(newsItem: NewsModel) {
            binding.tvNewsItem.text = newsItem.newsText
            binding.itemImg.setImageResource(newsItem.img)
        }
    }
}

interface NewsItemClickListener {
    fun onNewsItemClick(newsItem: NewsModel)
}