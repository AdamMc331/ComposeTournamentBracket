package com.adammcneilly.tournament.bracket.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.adammcneilly.tournament.bracket.displaymodels.BracketDisplayModel
import com.adammcneilly.tournament.bracket.displaymodels.BracketRoundDisplayModel
import com.adammcneilly.tournament.bracket.internal.BracketRoundTabRow
import com.adammcneilly.tournament.bracket.internal.BracketRoundsPager
import kotlinx.coroutines.launch

/**
 * The main component of a bracket. Given a [bracket], convert the [BracketDisplayModel.rounds]
 * into pages within a horizontal pager, with each page showing the matches for
 * that round. This also includes a tab bar at the top with each round so users can
 * quickly jump to a specific one.
 */
@ExperimentalFoundationApi
@Composable
fun Bracket(
    bracket: BracketDisplayModel,
    selectedRound: BracketRoundDisplayModel,
    modifier: Modifier = Modifier,
    onSelectedRoundChanged: (BracketRoundDisplayModel) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        BracketRoundTabRow(
            rounds = bracket.rounds,
            selectedRound = selectedRound,
            onRoundSelected = { round ->
                onSelectedRoundChanged.invoke(round)

                coroutineScope.launch {
                    pagerState.animateScrollToPage(bracket.rounds.indexOf(selectedRound))
                }
            },
        )

        BracketRoundsPager(
            rounds = bracket.rounds,
            pagerState = pagerState,
            modifier = Modifier
                .weight(1F),
        )
    }
}
