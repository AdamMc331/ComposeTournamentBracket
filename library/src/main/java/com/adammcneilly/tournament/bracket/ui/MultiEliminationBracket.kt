package com.adammcneilly.tournament.bracket.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.adammcneilly.tournament.bracket.displaymodels.BracketDisplayModel

/**
 * An extension on [Bracket] that is meant to support multiple elimination rounds, such a double elimination
 * tournament. We do this by taking in multiple [brackets], and setting up an [ExposedDropdownMenuBox] to switch
 * between each bracket.
 */
@ExperimentalMaterial3Api
@ExperimentalFoundationApi
@Composable
fun MultiEliminationBracket(
    brackets: List<BracketDisplayModel>,
    modifier: Modifier = Modifier,
) {
    val expanded = remember { mutableStateOf(false) }
    val selectedBracket = remember { mutableStateOf(brackets.first()) }

    Column {
        ExposedDropdownMenuBox(
            expanded = expanded.value,
            onExpandedChange = {
                expanded.value = !expanded.value
            },
        ) {
            TextField(
                value = selectedBracket.value.name,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor(),
            )

            ExposedDropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
            ) {
                brackets.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item.name) },
                        onClick = {
                            selectedBracket.value = item
                            expanded.value = false
                        },
                    )
                }
            }
        }

        Bracket(
            bracket = selectedBracket.value,
            modifier = modifier,
        )
    }
}
