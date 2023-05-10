package com.adammcneilly.tournament.bracket

data class BracketRound(
    val roundName: String,
    val matches: List<Match>,
)
