package com.adammcneilly.tournament.bracket

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * Defines an item that is used to represent a [match] inside of a bracket.
 * This just renders two teams in a vertical column, highlighting the winner in bold.
 *
 * A future improvement of this library would be to provide additional customization about how these
 * match items appear.
 */
@Composable
fun BracketMatchItem(
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

@Composable
private fun TeamRow(
    team: BracketTeamDisplayModel,
    color: Color,
) {
    val fontWeight: FontWeight? = if (team.isWinner) {
        FontWeight.Bold
    } else {
        null
    }

    Row {
        Text(
            text = team.name,
            fontWeight = fontWeight,
            color = color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(8.dp)
                .weight(1F),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = team.score,
            fontWeight = fontWeight,
            color = color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(8.dp),
        )
    }
}
