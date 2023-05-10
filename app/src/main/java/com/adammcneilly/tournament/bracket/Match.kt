package com.adammcneilly.tournament.bracket

data class Match(
    val teamOne: String,
    val teamTwo: String,
)

val quarterfinals = listOf(
    Match(
        "Karmine Corp",
        "Moist Esports",
    ),
    Match(
        "Team Secret",
        "Version1",
    ),
    Match(
        "Oxygen Esports",
        "FaZe Clan",
    ),
    Match(
        "Gen.G Mobil1 Racing",
        "Team Liquid",
    ),
)

val semiFinals = listOf(
    Match(
        "Moist Esports",
        "Team Secret",
    ),
    Match(
        "FaZe Clan",
        "Gen.G Mobil1 Racing",
    ),
)

val grandFinals = listOf(
    Match(
        "Moist Esports",
        "Gen.G Mobil1 Racing",
    ),
)
