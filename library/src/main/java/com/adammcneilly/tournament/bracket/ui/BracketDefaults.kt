package com.adammcneilly.tournament.bracket.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable

/**
 * Provides various helper functions for default behaviors of bracket configurations.
 */
object BracketDefaults {

    /**
     * Default value of [BracketColors] class.
     */
    @Composable
    fun bracketColors(): BracketColors {
        return BracketColors(
            tabColors = BracketColors.TabColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary,
            ),
            matchColors = BracketColors.MatchColors(
                contentColor = MaterialTheme.colorScheme.onSurface,
                borderColor = MaterialTheme.colorScheme.outline,
                dividerColor = MaterialTheme.colorScheme.outlineVariant,
            ),
            dropdownColors = BracketColors.DropdownColors(
                textFieldColors = TextFieldDefaults.colors(),
                menuItemColors = MenuDefaults.itemColors(),
            ),
        )
    }
}
