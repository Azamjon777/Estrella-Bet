package com.pali.estrellabet.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.pali.estrellabet.R
import com.pali.estrellabet.model.FinishedModel
import com.pali.estrellabet.model.UpcomingMatchModel

class MainViewModel(context: Context) : ViewModel() {

    val finishedGamesList: List<FinishedModel> = listOf(
        FinishedModel(
            context.getString(R.string.bernli),
            context.getString(R.string.mc),
            "0 - 3",
            "",
            "Холанд, Холанд, Родри",
            4,
            12,
            1,
            8,
            35,
            65,
            0,
            0,
            1,
            0,
            6,
            5
        ), FinishedModel(
            context.getString(R.string.arsenal),
            context.getString(R.string.nottingam),
            "2 - 1",
            "Нкетиа, Сака",
            "Авонийи",
            10,
            5,
            7,
            2,
            78,
            22,
            2,
            2,
            0,
            0,
            8,
            3
        ), FinishedModel(
            context.getString(R.string.al_hilal),
            context.getString(R.string.al_nasr),
            "1 - 2",
            "Майкл",
            "Роналду, Роналду",
            17,
            16,
            4,
            10,
            56,
            44,
            2,
            5,
            0,
            2,
            8,
            5
        )
    )

    val upcomingMatchesList = mutableListOf(
        UpcomingMatchModel(
            "Арсенал",
            "Манчестер Юнайтед",
            team1Img = context.getString(R.string.arsenal),
            team2Img = context.getString(R.string.mu),
            dateOfMatch = "2023-09-03"
        ),
        UpcomingMatchModel(
            "Ливерпуль",
            "Вест Хэм",
            team1Img = context.getString(R.string.liver),
            team2Img = context.getString(R.string.west_ham),
            dateOfMatch = "2023-08-24"
        ),
        UpcomingMatchModel(
            "Манчестер Сити",
            "Ньюкасл Юнайтед",
            team1Img = context.getString(R.string.mc),
            team2Img = context.getString(R.string.new_castle),
            dateOfMatch = "2023-08-20"
        ),
        UpcomingMatchModel(
            "Арсенал",
            "Манчестер Сити",
            team1Img = context.getString(R.string.arsenal),
            team2Img = context.getString(R.string.mc),
            dateOfMatch = "2023-10-07"
        ),
        UpcomingMatchModel(
            "Атлетико",
            "Севилья",
            team1Img = context.getString(R.string.atletico),
            team2Img = context.getString(R.string.sevilla),
            dateOfMatch = "2023-09-03"
        ),
        UpcomingMatchModel(
            "Атлетико",
            "Реал Мадрид",
            team1Img = context.getString(R.string.atletico),
            team2Img = context.getString(R.string.real),
            dateOfMatch = "2023-08-20"
        ),
        UpcomingMatchModel(
            "Рома",
            "Милан",
            team1Img = context.getString(R.string.roma),
            team2Img = context.getString(R.string.milan),
            dateOfMatch = "2023-09-01"
        ),
        UpcomingMatchModel(
            "Ювентус",
            "Лацио",
            team1Img = context.getString(R.string.juve),
            team2Img = context.getString(R.string.latsio),
            dateOfMatch = "2023-08-20"
        ),
        UpcomingMatchModel(
            "Интер",
            "Милан",
            team1Img = context.getString(R.string.inter),
            team2Img = context.getString(R.string.milan),
            dateOfMatch = "2023-08-20"
        ),
        UpcomingMatchModel(
            "Аль-Фатех",
            "Аль-Наср",
            team1Img = context.getString(R.string.fatekh),
            team2Img = context.getString(R.string.al_nasr),
            dateOfMatch = "2023-08-20"
        ),
    )
}
