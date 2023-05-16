package com.adammcneilly.tournament.bracket

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adammcneilly.tournament.bracket.theme.BracketTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BracketPager(
    rounds: List<BracketRound>,
    modifier: Modifier = Modifier,
    bracketItemHeight: Dp = 100.dp,
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        BracketRoundTabs(pagerState, rounds, coroutineScope)

        HorizontalPager(
            pageCount = 3,
            modifier = modifier
                .fillMaxWidth()
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

            val itemHeight = if (pageIndex <= pagerState.currentPage) {
                bracketItemHeight
            } else {
                val fullHeight = bracketItemHeight * 2
                val diffByOffset = (fullHeight - bracketItemHeight) * pagerState.currentPageOffsetFraction
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
    matches: List<Match>,
    itemHeight: Dp,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
    ) {
        matches.forEach { match ->
            BracketMatchItem(
                match = match,
                modifier = Modifier
                    .height(itemHeight),
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun BracketRoundTabs(
    pagerState: PagerState,
    rounds: List<BracketRound>,
    coroutineScope: CoroutineScope,
) {
    TabRow(selectedTabIndex = pagerState.currentPage) {
        rounds.forEachIndexed { index, bracketRound ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            ) {
                Text(
                    text = bracketRound.roundName,
                    modifier = Modifier.padding(8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun BracketPagerPreview() {
    BracketTheme {
        Surface {
            BracketPager(
                rounds = listOf(
                    BracketRound("Quarterfinals", quarterfinals),
                    BracketRound("Semifinals", semiFinals),
                    BracketRound("Grand Final", grandFinals),
                )
            )
        }
    }
}
