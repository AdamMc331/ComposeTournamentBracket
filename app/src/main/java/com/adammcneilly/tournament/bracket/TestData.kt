package com.adammcneilly.tournament.bracket

object TestData {
    private val quarterFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Karmine Corp",
                isWinner = false,
                score = "1",
            ),
            BracketTeamDisplayModel(
                name = "Moist Esports",
                isWinner = true,
                score = "4",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Team Secret",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "Version1",
                isWinner = false,
                score = "1",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Oxygen Esports",
                isWinner = false,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "FaZe Clan",
                isWinner = true,
                score = "4",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "Team Liquid",
                isWinner = false,
                score = "3",
            ),
        ),
    )

    private val semiFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Moist Esports",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "Team Secret",
                isWinner = false,
                score = "2",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "FaZe Clan",
                isWinner = false,
                score = "1",
            ),
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
                score = "4",
            ),
        ),
    )

    private val grandFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Moist Esports",
                isWinner = false,
                score = "2",
            ),
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
                score = "4",
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
