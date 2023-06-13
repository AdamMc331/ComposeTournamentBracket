package com.adammcneilly.tournament.bracket.displaymodels

object TestDisplayModels {

    val winningTeam = BracketTeamDisplayModel(
        name = "Winning Team",
        isWinner = true,
        score = "7",
    )

    val losingTeam = BracketTeamDisplayModel(
        name = "Losing Team",
        isWinner = false,
        score = "0",
    )

    val tbdTeam = BracketTeamDisplayModel(
        name = "TBD",
        isWinner = false,
        score = "",
    )

    val matchWithTopWinner = BracketMatchDisplayModel(
        topTeam = winningTeam,
        bottomTeam = losingTeam,
    )

    val matchWithBottomWinner = BracketMatchDisplayModel(
        topTeam = losingTeam,
        bottomTeam = winningTeam,
    )

    val matchWithNoWinner = BracketMatchDisplayModel(
        topTeam = tbdTeam,
        bottomTeam = tbdTeam,
    )
}
