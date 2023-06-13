package com.adammcneilly.tournament.bracket.internal

import app.cash.paparazzi.Paparazzi
import com.adammcneilly.tournament.bracket.displaymodels.TestDisplayModels
import com.adammcneilly.tournament.bracket.ui.BracketDefaults
import org.junit.Rule
import org.junit.Test

class TeamRowPaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun renderWinningTeamRow() {
        paparazzi.snapshot {
            TeamRow(
                team = TestDisplayModels.winningTeam,
                colors = BracketDefaults.bracketColors().matchColors,
            )
        }
    }

    @Test
    fun renderLosingTeamRow() {
        paparazzi.snapshot {
            TeamRow(
                team = TestDisplayModels.losingTeam,
                colors = BracketDefaults.bracketColors().matchColors,
            )
        }
    }
}
