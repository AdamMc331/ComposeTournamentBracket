package com.adammcneilly.tournament.bracket.internal

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.adammcneilly.tournament.bracket.displaymodels.BracketTeamDisplayModel
import com.adammcneilly.tournament.bracket.ui.BracketColors

/**
 * Component to render a [team] inside of a [BracketMatchItem].
 */
@Composable
internal fun TeamRow(
    team: BracketTeamDisplayModel,
    colors: BracketColors.MatchColors,
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
            color = colors.contentColor,
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
            color = colors.contentColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(8.dp),
        )
    }
}
