package com.pali.estrellabet.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pali.estrellabet.adapter.NewsAdapter
import com.pali.estrellabet.adapter.NewsItemClickListener
import com.pali.estrellabet.databinding.FragmentNewsBinding
import com.pali.estrellabet.model.NewsModel
import com.pali.estrellabet.presentation.NewsActivity
import com.pali.estrellabet.viewmodel.NewsViewModel

class NewsFragment : Fragment(), NewsItemClickListener {

    private lateinit var binding: FragmentNewsBinding
    private lateinit var newsAdapter: NewsAdapter
    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewsBinding.bind(view)
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())

        newsViewModel.newsList.observe(viewLifecycleOwner) { newsList ->
            newsAdapter = NewsAdapter(newsList, this)
            binding.rvNews.adapter = newsAdapter
        }
    }

    override fun onNewsItemClick(newsItem: NewsModel) {
        val intent = Intent(requireActivity(), NewsActivity::class.java)
        intent.putExtra("newsItem", newsItem)
        startActivity(intent)
    }

}
