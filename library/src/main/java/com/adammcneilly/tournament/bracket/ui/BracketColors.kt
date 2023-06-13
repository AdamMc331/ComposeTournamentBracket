package com.adammcneilly.tournament.bracket.ui

import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.ui.graphics.Color

/**
 * Defines all of the colors that are required when rendering a tournament bracket.
 *
 * This base class defines each grouping of colors that are relevant throughout the various
 * bracket components.
 */
data class BracketColors(
    val tabColors: TabColors,
    val matchColors: MatchColors,
    val dropdownColors: DropdownColors,
) {

    /**
     * Color information for a tab row inside of a bracket component.
     */
    data class TabColors(
        val containerColor: Color,
        val contentColor: Color,
    )

    /**
     * Color information for a match inside of a bracket component.
     */
    data class MatchColors(
        val contentColor: Color,
        val borderColor: Color,
        val dividerColor: Color,
    )

    /**
     * Color information for the dropdown inside a multi elimination bracket.
     *
     * Since this is a compose component (for now: https://github.com/AdamMc331/ComposeTournamentBracket/issues/17),
     * we're just gonna proxy this through to material colors, but we should be able to pull out
     * exactly what information we do want.
     */
    data class DropdownColors(
        val textFieldColors: TextFieldColors,
        val menuItemColors: MenuItemColors,
    )
}
