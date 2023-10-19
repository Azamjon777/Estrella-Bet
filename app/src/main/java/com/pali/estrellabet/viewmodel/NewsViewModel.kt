package com.pali.estrellabet.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pali.estrellabet.R
import com.pali.estrellabet.model.NewsModel

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _newsList = MutableLiveData<List<NewsModel>>()
    val newsList: LiveData<List<NewsModel>> = _newsList

    init {
        val newsTitles = arrayOf(
            application.getString(R.string.news_1),
            application.getString(R.string.news_2),
            application.getString(R.string.news_3),
            application.getString(R.string.news_4),
            application.getString(R.string.news_5),
            application.getString(R.string.news_6),
            application.getString(R.string.news_7),
            application.getString(R.string.news_8),
            application.getString(R.string.news_9),
            application.getString(R.string.news_10)
        )

        val newsImages = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
        )

        val initialNews = newsTitles.mapIndexed { index, title ->
            NewsModel(newsImages[index], title)
        }.toMutableList()
        _newsList.value = initialNews
    }
}
