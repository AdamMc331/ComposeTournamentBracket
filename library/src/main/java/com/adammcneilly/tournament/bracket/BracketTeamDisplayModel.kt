package com.adammcneilly.tournament.bracket

/**
 * Defines a team to be displayed inside of a bracket.
 *
 * @property[name] The user friendly name for this team.
 * @property[isWinner] True if this team is the winner of the match up
 * the entity is being used in.
 */
data class BracketTeamDisplayModel(
    val name: String,
    val isWinner: Boolean,
)
