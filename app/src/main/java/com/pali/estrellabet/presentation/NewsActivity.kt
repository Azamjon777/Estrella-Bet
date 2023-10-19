package com.pali.estrellabet.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pali.estrellabet.databinding.ActivityNewsBinding
import com.pali.estrellabet.model.NewsModel

class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
    }

    private fun setupViews() {
        val newsItem = intent.getSerializableExtra("newsItem") as? NewsModel
        newsItem?.let {
            binding.imageRounded.setImageResource(it.img)
            binding.tvNewsInActivity.text = it.newsText
        }
    }
}




