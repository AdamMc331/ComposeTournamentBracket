package com.adammcneilly.tournament.bracket.internal

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adammcneilly.tournament.bracket.displaymodels.BracketRoundDisplayModel
import com.adammcneilly.tournament.bracket.ui.BracketColors

private val BRACKET_ITEM_HEIGHT = 100.dp

/**
 * An implementation of [HorizontalPager] that paginates through a list of [rounds]. Each round
 * is displayed in a [BracketRoundMatchList].
 */
@ExperimentalFoundationApi
@Composable
internal fun BracketRoundsPager(
    rounds: List<BracketRoundDisplayModel>,
    pagerState: PagerState,
    colors: BracketColors,
    modifier: Modifier = Modifier,
) {
    val lazyListStates = List(rounds.size) {
        rememberLazyListState()
    }

    HorizontalPager(
        pageCount = rounds.size,
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        pageSpacing = 16.dp,
        pageSize = BracketPageSize,
        state = pagerState,
    ) { pageIndex ->
        val round = rounds[pageIndex]
        val previousRound = rounds.getOrNull(pageIndex - 1)

        val itemHeight = calculateItemHeight(pageIndex, pagerState, round, previousRound)

        SyncLazyListStates(lazyListStates, pageIndex)

        BracketRoundMatchList(
            matches = round.matches,
            itemHeight = itemHeight,
            lazyListState = lazyListStates[pageIndex],
            colors = colors,
        )
    }
}

/**
 * Syncs the lazy list state of the current [pageIndex] and the next one.
 */
@Composable
private fun SyncLazyListStates(
    lazyListStates: List<LazyListState>,
    pageIndex: Int,
) {
    val currentLazyListState = lazyListStates[pageIndex]
    val nextLazyListState = lazyListStates.getOrNull(pageIndex + 1)

    if (nextLazyListState != null) {
        currentLazyListState.SyncLazyListState(otherState = nextLazyListState)
    }
}

/**
 * Calculates the height of an item based on our [pageIndex]. For current or previous pages, we'll default
 * to the [BRACKET_ITEM_HEIGHT].
 *
 * For future pages, we simulate the bracket UI by making each item double the [BRACKET_ITEM_HEIGHT]
 * (and centering it), which ultimately gives the appearance of a tree.
 *
 * Additionally, we calculate the [PagerState.currentPageOffsetFraction] of our current page so we can tweak
 * the height of the item to simulate an animation that the bracket is shrinking or growing as user
 * swipes between tabs.
 */
@OptIn(ExperimentalFoundationApi::class)
private fun calculateItemHeight(
    pageIndex: Int,
    pagerState: PagerState,
    currentRound: BracketRoundDisplayModel,
    previousRound: BracketRoundDisplayModel?,
): Dp {
    val isCurrentOrPreviousPage = pageIndex <= pagerState.currentPage
    val roundSize = currentRound.matches.size
    val previousRoundSize = previousRound?.matches?.size
    val sameSizeAsLastRound = roundSize == previousRoundSize
    val itemHeight = if (isCurrentOrPreviousPage || sameSizeAsLastRound) {
        BRACKET_ITEM_HEIGHT
    } else {
        val fullHeight = BRACKET_ITEM_HEIGHT * 2
        val diffByOffset = (fullHeight - BRACKET_ITEM_HEIGHT) * pagerState.currentPageOffsetFraction
        val heightToRender = (fullHeight - diffByOffset)
        heightToRender
    }
    return itemHeight
}
