package com.adammcneilly.tournament.bracket

object TestData {
    private val quarterFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Karmine Corp",
                isWinner = false,
            ),
            BracketTeamDisplayModel(
                name = "Moist Esports",
                isWinner = true,
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Team Secret",
                isWinner = true,
            ),
            BracketTeamDisplayModel(
                name = "Version1",
                isWinner = false,
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Oxygen Esports",
                isWinner = false,
            ),
            BracketTeamDisplayModel(
                name = "FaZe Clan",
                isWinner = true,
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
            ),
            BracketTeamDisplayModel(
                name = "Team Liquid",
                isWinner = false,
            ),
        ),
    )

    private val semiFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Moist Esports",
                isWinner = true,
            ),
            BracketTeamDisplayModel(
                name = "Team Secret",
                isWinner = false,
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel("FaZe Clan", false),
            BracketTeamDisplayModel("Gen.G Mobil1 Racing", true),
        ),
    )

    private val grandFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Moist Esports",
                isWinner = false,
            ),
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
            ),
        ),
    )

    val bracketRounds = listOf(
        BracketRound(
            name = "Quarter Finals",
            matches = quarterFinals,
        ),
        BracketRound(
            name = "Semi Finals",
            matches = semiFinals,
        ),
        BracketRound(
            name = "Grand Finals",
            matches = grandFinals,
        ),
    )
}
