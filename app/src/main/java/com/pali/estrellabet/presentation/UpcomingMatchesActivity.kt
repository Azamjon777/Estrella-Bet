package com.pali.estrellabet.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pali.estrellabet.databinding.ActivityUpcomingMatchesBinding
import com.pali.estrellabet.model.UpcomingMatchModel

class UpcomingMatchesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityUpcomingMatchesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val upcomingMatch = intent.getSerializableExtra("upcoming_matches") as? UpcomingMatchModel

        if (upcomingMatch != null) {
            Glide.with(this)
                .load(upcomingMatch.team1Img)
                .into(binding.team1ImgUpcoming)
            Glide.with(this)
                .load(upcomingMatch.team2Img)
                .into(binding.team2ImgUpcoming)
            binding.dateOfUpcomingMatches.text = upcomingMatch.dateOfMatch
            binding.team1Name.text = upcomingMatch.team1Name
            binding.team2Name.text = upcomingMatch.team2Name
            binding.backImgUpcoming.setOnClickListener { finish() }
        }
    }
}
