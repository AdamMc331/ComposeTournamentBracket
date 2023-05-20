package com.adammcneilly.tournament.bracket

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

private val BRACKET_ITEM_HEIGHT = 100.dp

/**
 * The main component of a bracket. Given some number of [rounds], convert them
 * into pages within a horizontal pager, with each page showing the matches for
 * that round. This also includes a tab bar at the top with each round so users can
 * quickly jump to a specific one.
 */
@ExperimentalFoundationApi
@Composable
fun BracketPager(
    rounds: List<BracketRoundDisplayModel>,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState()
    val lazyListStates = List(rounds.size) {
        rememberLazyListState()
    }

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        BracketRoundTabs(pagerState, rounds)

        HorizontalPager(
            pageCount = rounds.size,
            modifier = Modifier
                .weight(1F),
            contentPadding = PaddingValues(16.dp),
            pageSpacing = 16.dp,
            pageSize = BracketPageSize,
            state = pagerState,
        ) { pageIndex ->
            val round = rounds[pageIndex]
            val previousRound = rounds.getOrNull(pageIndex - 1)

            val itemHeight = calculateItemHeight(pageIndex, pagerState, round, previousRound)

            SyncLazyListStates(lazyListStates, pageIndex)

            RoundMatchList(
                matches = round.matches,
                itemHeight = itemHeight,
                lazyListState = lazyListStates[pageIndex],
            )
        }
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

@Composable
private fun RoundMatchList(
    matches: List<BracketMatchDisplayModel>,
    itemHeight: Dp,
    lazyListState: LazyListState,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(),
        state = lazyListState,
    ) {
        items(matches) { match ->
            BracketMatchItem(
                match = match,
                modifier = Modifier
                    .height(itemHeight),
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun BracketRoundTabs(
    pagerState: PagerState,
    rounds: List<BracketRoundDisplayModel>,
) {
    val coroutineScope = rememberCoroutineScope()

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 16.dp,
    ) {
        rounds.forEachIndexed { index, bracketRound ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
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
