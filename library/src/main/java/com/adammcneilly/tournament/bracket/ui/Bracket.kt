package com.adammcneilly.tournament.bracket.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.adammcneilly.tournament.bracket.displaymodels.BracketDisplayModel
import com.adammcneilly.tournament.bracket.internal.BracketRoundTabRow
import com.adammcneilly.tournament.bracket.internal.BracketRoundsPager
import kotlinx.coroutines.launch

/**
 * The main component of a bracket. Given some number of [rounds], convert them
 * into pages within a horizontal pager, with each page showing the matches for
 * that round. This also includes a tab bar at the top with each round so users can
 * quickly jump to a specific one.
 */
@ExperimentalFoundationApi
@Composable
fun Bracket(
    bracket: BracketDisplayModel,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val selectedRound = remember { mutableStateOf(bracket.rounds.first()) }

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        BracketRoundTabRow(
            rounds = bracket.rounds,
            selectedRound = selectedRound.value,
            onRoundSelected = { round ->
                selectedRound.value = round

                coroutineScope.launch {
                    pagerState.animateScrollToPage(bracket.rounds.indexOf(selectedRound.value))
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
