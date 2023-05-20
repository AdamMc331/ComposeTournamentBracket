package com.adammcneilly.tournament.bracket.internal

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.adammcneilly.tournament.bracket.displaymodels.BracketMatchDisplayModel

/**
 * Defines an item that is used to represent a [match] inside of a bracket.
 * This just renders two teams in a vertical column, highlighting the winner in bold.
 *
 * A future improvement of this library would be to provide additional customization about how these
 * match items appear.
 */
@Composable
internal fun BracketMatchItem(
    match: BracketMatchDisplayModel,
    modifier: Modifier = Modifier,
    contentColor: Color = LocalContentColor.current,
) {
    Box(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = contentColor,
                )
                .align(Alignment.Center),
        ) {
            TeamRow(
                team = match.topTeam,
                color = contentColor,
            )

            Divider()

            TeamRow(
                team = match.bottomTeam,
                color = contentColor,
            )
        }
    }
}
