package com.adammcneilly.tournament.bracket.internal

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PageSize
import androidx.compose.ui.unit.Density

/**
 * A custom implementation of [PageSize] that shows the current page, subtracting the page spacing
 * so we can see a peak into the next page.
 */
@OptIn(ExperimentalFoundationApi::class)
internal object BracketPageSize : PageSize {
    override fun Density.calculateMainAxisPageSize(availableSpace: Int, pageSpacing: Int): Int {
        return availableSpace - (2 * pageSpacing)
    }
}
