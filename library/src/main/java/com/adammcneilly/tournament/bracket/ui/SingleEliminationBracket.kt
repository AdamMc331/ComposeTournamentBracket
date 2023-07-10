package com.adammcneilly.tournament.bracket.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.adammcneilly.tournament.bracket.displaymodels.BracketDisplayModel
import com.adammcneilly.tournament.bracket.internal.Bracket
import kotlinx.coroutines.launch

/**
 * A wrapper around a [Bracket] component for a single elimination bracket. This is different
 * from [MultiEliminationBracket] in that there is only one [bracket] shown, and the tabs associated
 * with it.
 */
@ExperimentalFoundationApi
@Composable
fun SingleEliminationBracket(
    bracket: BracketDisplayModel,
    modifier: Modifier = Modifier,
    colors: BracketColors = BracketDefaults.bracketColors(),
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Bracket(
        bracket = bracket,
        selectedRound = bracket.rounds[pagerState.currentPage],
        pagerState = pagerState,
        onSelectedRoundChanged = { round ->
            coroutineScope.launch {
                pagerState.animateScrollToPage(bracket.rounds.indexOf(round))
            }
        },
        modifier = modifier,
        colors = colors,
    )
}
