package com.adammcneilly.tournament.bracket.internal

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.tournament.bracket.displaymodels.BracketRoundDisplayModel

@Composable
internal fun BracketRoundTabRow(
    rounds: List<BracketRoundDisplayModel>,
    selectedRound: BracketRoundDisplayModel,
    onRoundSelected: (BracketRoundDisplayModel) -> Unit,
) {
    val selectedRoundIndex = rounds.indexOf(selectedRound)

    ScrollableTabRow(
        selectedTabIndex = selectedRoundIndex,
        edgePadding = 16.dp,
    ) {
        rounds.forEach { bracketRound ->
            Tab(
                selected = bracketRound == selectedRound,
                onClick = {
                    onRoundSelected.invoke(bracketRound)
                },
                modifier = Modifier
                    .height(48.dp),
            ) {
                Text(
                    text = bracketRound.name,
                    modifier = Modifier
                        .padding(
                            horizontal = 8.dp,
                        ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}
