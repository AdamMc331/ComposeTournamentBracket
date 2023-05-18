package com.adammcneilly.tournament.bracket

/**
 * A [BracketRound] is a collection of [matches] that take place in the same portion
 * of the bracket. For example, semifinals and quarterfinals. The [name] property
 * represents the user friendly explanation of this round.
 */
data class BracketRound(
    val name: String,
    val matches: List<BracketMatchDisplayModel>,
)
