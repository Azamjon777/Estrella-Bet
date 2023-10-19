package com.pali.estrellabet.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pali.estrellabet.R
import com.pali.estrellabet.databinding.FragmentOnBoard1Binding

class OnBoard1Fragment : Fragment() {
    private lateinit var binding: FragmentOnBoard1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoard1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skip.setOnClickListener {
            findNavController().navigate(R.id.action_onBoard1Fragment_to_onBoard2Fragment)
        }
    }
}
