package com.pali.estrellabet.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pali.estrellabet.databinding.ActivityFinishedMatchesBinding
import com.pali.estrellabet.model.FinishedModel

class FinishedMatchesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishedMatchesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishedMatchesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedMatch = intent.getSerializableExtra("selectedMatch") as? FinishedModel

        if (selectedMatch != null) {
            binding.team1Shoot.text = selectedMatch.team1Shoot.toString()
            binding.team2Shoot.text = selectedMatch.team2Shoot.toString()
            binding.team1ShootOnTarget.text = selectedMatch.team1ShootOnTarget.toString()
            binding.team2ShootOnTarget.text = selectedMatch.team2ShootOnTarget.toString()
            binding.team1BallPossession.text = selectedMatch.team1Possession.toString()
            binding.team2BallPossession.text = selectedMatch.team2Possession.toString()
            binding.team1YellowCard.text = selectedMatch.team1YellowCard.toString()
            binding.team2YellowCard.text = selectedMatch.team2YellowCard.toString()
            binding.team1RedCard.text = selectedMatch.team1RedCard.toString()
            binding.team2RedCard.text = selectedMatch.team2RedCard.toString()
            binding.team1CornerKick.text = selectedMatch.team1CornerKick.toString()
            binding.team2CornerKick.text = selectedMatch.team2CornerKick.toString()

            binding.team1Scorers.text = selectedMatch.scorersFirstTeam
            binding.team2Scorers.text = selectedMatch.scorersSecondTeam

            Glide.with(binding.root.context)
                .load(selectedMatch.firstTeamImgUrl)
                .into(binding.team1Img)
            Glide.with(binding.root.context)
                .load(selectedMatch.secondTeamImgUrl)
                .into(binding.team2Img)

            binding.scoreOfMatch.text = selectedMatch.totalScore

            binding.backImg.setOnClickListener {
                finish()
            }
        }
    }
}
