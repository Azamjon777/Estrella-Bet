package com.pali.estrellabet.presentation.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pali.estrellabet.adapter.UpcomingMatchClickListener
import com.pali.estrellabet.adapter.UpcomingMatchesAdapter
import com.pali.estrellabet.databinding.FragmentUpcomingMatchesBinding
import com.pali.estrellabet.model.UpcomingMatchModel
import com.pali.estrellabet.presentation.UpcomingMatchesActivity
import com.pali.estrellabet.viewmodel.MainViewModel
import com.pali.estrellabet.viewmodel.MainViewModelFactory

class UpcomingMatchesFragment : Fragment(), UpcomingMatchClickListener {

    private lateinit var binding: FragmentUpcomingMatchesBinding
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUpcomingMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = UpcomingMatchesAdapter(viewModel.upcomingMatchesList, 10, this)
        binding.rvUpcomingMatches.adapter = adapter
        binding.rvUpcomingMatches.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onUpcomingMatchClick(match: UpcomingMatchModel) {
        val intent = Intent(requireActivity(), UpcomingMatchesActivity::class.java)
        intent.putExtra("upcoming_matches", match)
        startActivity(intent)
    }
}
