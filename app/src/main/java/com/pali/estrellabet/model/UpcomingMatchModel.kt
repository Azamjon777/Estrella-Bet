package com.pali.estrellabet.model

import java.io.Serializable

class UpcomingMatchModel(
    val team1Name: String,
    val team2Name: String,
    val team1Img: String,
    val team2Img: String,
    val dateOfMatch: String
) : Serializable