package com.adammcneilly.tournament.bracket.internal

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.tournament.bracket.displaymodels.BracketDisplayModel
import com.adammcneilly.tournament.bracket.displaymodels.BracketRoundDisplayModel
import com.adammcneilly.tournament.bracket.ui.BracketColors

/**
 * The main component of a bracket. Given a [bracket], convert the [BracketDisplayModel.rounds]
 * into pages within a horizontal pager, with each page showing the matches for
 * that round. This also includes a tab bar at the top with each round so users can
 * quickly jump to a specific one.
 */
@ExperimentalFoundationApi
@Composable
internal fun Bracket(
    bracket: BracketDisplayModel,
    selectedRound: BracketRoundDisplayModel,
    pagerState: PagerState,
    onSelectedRoundChanged: (BracketRoundDisplayModel) -> Unit,
    modifier: Modifier = Modifier,
    colors: BracketColors,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        BracketRoundTabRow(
            rounds = bracket.rounds,
            selectedRound = selectedRound,
            onRoundSelected = { round ->
                onSelectedRoundChanged.invoke(round)
            },
            colors = colors.tabColors,
        )

        BracketRoundsPager(
            rounds = bracket.rounds,
            pagerState = pagerState,
            modifier = Modifier
                .weight(1F),
            colors = colors,
        )
    }
}
