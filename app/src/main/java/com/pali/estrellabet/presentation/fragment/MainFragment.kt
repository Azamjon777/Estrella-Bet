package com.pali.estrellabet.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pali.estrellabet.R
import com.pali.estrellabet.adapter.FinishedMatchClickListener
import com.pali.estrellabet.adapter.FinishedMatchesAdapter
import com.pali.estrellabet.adapter.UpcomingMatchClickListener
import com.pali.estrellabet.adapter.UpcomingMatchesAdapter
import com.pali.estrellabet.databinding.FragmentMainBinding
import com.pali.estrellabet.model.FinishedModel
import com.pali.estrellabet.model.UpcomingMatchModel
import com.pali.estrellabet.presentation.FinishedMatchesActivity
import com.pali.estrellabet.presentation.UpcomingMatchesActivity
import com.pali.estrellabet.viewmodel.MainViewModel
import com.pali.estrellabet.viewmodel.MainViewModelFactory

class MainFragment : Fragment(), FinishedMatchClickListener, UpcomingMatchClickListener {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataList: List<FinishedModel> = viewModel.finishedGamesList
        val adapter = FinishedMatchesAdapter(dataList, this)

        binding.rvFinishedMatches.adapter = adapter
        binding.rvFinishedMatches.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val upcomingMatchesAdapter = UpcomingMatchesAdapter(viewModel.upcomingMatchesList, 3, this)
        binding.rvUpcomingMatches.adapter = upcomingMatchesAdapter
        binding.rvUpcomingMatches.layoutManager = LinearLayoutManager(requireContext())

        binding.btnSeeAllNews.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_newsFragment)
        }
        binding.btnSeeAll.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_upcomingMatchesFragment)
        }
        binding.itemImg.setImageResource(R.drawable.image1)
        binding.tvNewsItem.text = context?.getString(R.string.news_1) ?: "News"
    }

    override fun onFinishedMatchClicked(match: FinishedModel) {
        val intent = Intent(requireContext(), FinishedMatchesActivity::class.java)
        intent.putExtra("selectedMatch", match)
        startActivity(intent)
    }

    override fun onUpcomingMatchClick(match: UpcomingMatchModel) {
        val intent = Intent(requireActivity(), UpcomingMatchesActivity::class.java)
        intent.putExtra("upcoming_matches", match)
        startActivity(intent)
    }

}
