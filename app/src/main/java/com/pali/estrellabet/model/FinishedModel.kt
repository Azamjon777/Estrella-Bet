package com.pali.estrellabet.model

import java.io.Serializable

class FinishedModel(
    val firstTeamImgUrl: String,
    val secondTeamImgUrl: String,
    val totalScore: String,
    val scorersFirstTeam: String,
    val scorersSecondTeam: String,
    val team1Shoot: Int,
    val team2Shoot: Int,
    val team1ShootOnTarget: Int,
    val team2ShootOnTarget: Int,
    val team1Possession: Int,
    val team2Possession: Int,
    val team1YellowCard: Int,
    val team2YellowCard: Int,
    val team1RedCard: Int,
    val team2RedCard: Int,
    val team1CornerKick: Int,
    val team2CornerKick: Int
) : Serializable