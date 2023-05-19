package com.adammcneilly.tournament.bracket

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
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
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        BracketRoundTabs(pagerState, rounds, coroutineScope)

        HorizontalPager(
            pageCount = rounds.size,
            modifier = Modifier
                .weight(1F),
            contentPadding = PaddingValues(16.dp),
            pageSpacing = 16.dp,
            pageSize = object : PageSize {
                override fun Density.calculateMainAxisPageSize(availableSpace: Int, pageSpacing: Int): Int {
                    return availableSpace - (2 * pageSpacing)
                }
            },
            state = pagerState,
        ) { pageIndex ->

            val isCurrentOrPreviousPage = pageIndex <= pagerState.currentPage
            val roundSize = rounds[pageIndex].matches.size
            val previousRoundSize = rounds.getOrNull(pageIndex - 1)?.matches?.size
            val sameSizeAsLastRound = roundSize == previousRoundSize
            val itemHeight = if (isCurrentOrPreviousPage || sameSizeAsLastRound) {
                BRACKET_ITEM_HEIGHT
            } else {
                val fullHeight = BRACKET_ITEM_HEIGHT * 2
                val diffByOffset = (fullHeight - BRACKET_ITEM_HEIGHT) * pagerState.currentPageOffsetFraction
                val heightToRender = (fullHeight - diffByOffset)
                heightToRender
            }

            RoundMatchList(
                matches = rounds[pageIndex].matches,
                itemHeight = itemHeight,
            )
        }
    }
}

@Composable
private fun RoundMatchList(
    matches: List<BracketMatchDisplayModel>,
    itemHeight: Dp,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(),
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
    coroutineScope: CoroutineScope,
) {
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
