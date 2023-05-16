package com.adammcneilly.tournament.bracket

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.tournament.bracket.theme.BracketTheme

@Composable
fun BracketMatchItem(
    match: Match,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .border(1.dp, LocalContentColor.current),
        ) {
            Text(
                text = match.teamOne,
                modifier = Modifier
                    .padding(8.dp),
            )

            Divider()

            Text(
                text = match.teamTwo,
                modifier = Modifier
                    .padding(8.dp),
            )
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
private fun BracketMatchItemPreview() {
    BracketTheme {
        Surface {
            BracketMatchItem(
                match = Match(
                    teamOne = "Karmine Corp",
                    teamTwo = "Moist Esports",
                ),
                modifier = Modifier
                    .height(131.dp)
                    .padding(16.dp),
            )
        }
    }
}
