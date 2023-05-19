package com.adammcneilly.tournament.bracket

object TestData {
    private val singleEliminationQuarterFinals = listOf(
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

    private val singleEliminationSemiFinals = listOf(
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

    private val singleEliminationGrandFinals = listOf(
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

    val singleEliminationBracketRounds = listOf(
        BracketRound(
            name = "Quarter Finals",
            matches = singleEliminationQuarterFinals,
        ),
        BracketRound(
            name = "Semi Finals",
            matches = singleEliminationSemiFinals,
        ),
        BracketRound(
            name = "Grand Finals",
            matches = singleEliminationGrandFinals,
        ),
    )

    private val upperBracketRound1 = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "FaZe Clan",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "hey bro",
                isWinner = false,
                score = "0",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Spacestation",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "M80",
                isWinner = false,
                score = "0",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "FURIA",
                isWinner = false,
                score = "1",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Dignitas",
                isWinner = false,
                score = "1",
            ),
            BracketTeamDisplayModel(
                name = "NRG",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Complexity",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "Zero2One",
                isWinner = false,
                score = "0",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Version1",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "Shopify Rebellion",
                isWinner = false,
                score = "0",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "G2 Esports",
                isWinner = false,
                score = "2",
            ),
            BracketTeamDisplayModel(
                name = "sup",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "OpTic Gaming",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "KOI",
                isWinner = false,
                score = "1",
            ),
        ),
    )

    private val upperBracketQuarterfinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "FaZe Clan",
                isWinner = false,
                score = "2",
            ),
            BracketTeamDisplayModel(
                name = "Spacestation",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "NRG",
                isWinner = false,
                score = "0",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Complexity",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "Version1",
                isWinner = false,
                score = "0",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "sup",
                isWinner = false,
                score = "0",
            ),
            BracketTeamDisplayModel(
                name = "OpTic Gaming",
                isWinner = true,
                score = "3",
            ),
        ),
    )

    private val upperBracketSemiFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Spacestation",
                isWinner = false,
                score = "1",
            ),
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
                score = "4",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Complexity",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "OpTic Gaming",
                isWinner = false,
                score = "1",
            ),
        ),
    )

    private val upperBracketFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = false,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "Complexity",
                isWinner = true,
                score = "4",
            ),
        ),
    )

    private val doubleEliminationGrandFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Complexity",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = false,
                score = "2",
            ),
        ),
    )

    private val lowerBracketRound1 = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "hey bro",
                isWinner = false,
                score = "1",
            ),
            BracketTeamDisplayModel(
                name = "M80",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "FURIA",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "Dignitas",
                isWinner = false,
                score = "0",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Zero2One",
                isWinner = false,
                score = "0",
            ),
            BracketTeamDisplayModel(
                name = "Shopify Rebellion",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "G2 Esports",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "KOI",
                isWinner = false,
                score = "2",
            ),
        ),
    )

    val lowerBracketRound2 = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "sup",
                isWinner = true,
                score = "3",
            ),
            BracketTeamDisplayModel(
                name = "M80",
                isWinner = false,
                score = "2",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Version1",
                isWinner = false,
                score = "0",
            ),
            BracketTeamDisplayModel(
                name = "FURIA",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "NRG",
                isWinner = false,
                score = "1",
            ),
            BracketTeamDisplayModel(
                name = "Shopify Rebellion",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "FaZe Clan",
                isWinner = false,
                score = "0",
            ),
            BracketTeamDisplayModel(
                name = "G2 Esports",
                isWinner = true,
                score = "3",
            ),
        ),
    )

    val lowerBracketRound3 = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "sup",
                isWinner = false,
                score = "0",
            ),
            BracketTeamDisplayModel(
                name = "FURIA",
                isWinner = true,
                score = "3",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Shopify Rebellion",
                isWinner = false,
                score = "0",
            ),
            BracketTeamDisplayModel(
                name = "G2 Esports",
                isWinner = true,
                score = "3",
            ),
        ),
    )

    val lowerBracketQuarterFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Spacestation",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "FURIA",
                isWinner = false,
                score = "2",
            ),
        ),
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "OpTic Gaming",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "G2 Esports",
                isWinner = false,
                score = "2",
            ),
        ),
    )

    val lowerBracketSemiFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Spacestation",
                isWinner = false,
                score = "2",
            ),
            BracketTeamDisplayModel(
                name = "OpTic Gaming",
                isWinner = true,
                score = "4",
            ),
        ),
    )

    val lowerBracketFinals = listOf(
        BracketMatchDisplayModel(
            BracketTeamDisplayModel(
                name = "Gen.G Mobil1 Racing",
                isWinner = true,
                score = "4",
            ),
            BracketTeamDisplayModel(
                name = "OpTic Gaming",
                isWinner = false,
                score = "1",
            ),
        ),
    )

    val upperBracketRounds = listOf(
        BracketRound("UB Round 1", upperBracketRound1),
        BracketRound("UB Quarterfinals", upperBracketQuarterfinals),
        BracketRound("UB Semifinals", upperBracketSemiFinals),
        BracketRound("UB Final", upperBracketFinals),
        BracketRound("Grand Final", doubleEliminationGrandFinals),
    )

    val lowerBracketRounds = listOf(
        BracketRound("LB Round 1", lowerBracketRound1),
        BracketRound("LB Round 2", lowerBracketRound2),
        BracketRound("LB Round 3", lowerBracketRound3),
        BracketRound("LB Quarterfinals", lowerBracketQuarterFinals),
        BracketRound("LB Semifinal", lowerBracketSemiFinals),
        BracketRound("LB Final", lowerBracketFinals),
    )
}
