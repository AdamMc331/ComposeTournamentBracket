package com.adammcneilly.tournament.bracket.internal

import app.cash.paparazzi.Paparazzi
import com.adammcneilly.tournament.bracket.displaymodels.TestDisplayModels
import com.adammcneilly.tournament.bracket.ui.BracketDefaults
import org.junit.Rule
import org.junit.Test

class BracketMatchItemPaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun renderWinningTeamOnTop() {
        paparazzi.snapshot {
            BracketMatchItem(
                match = TestDisplayModels.matchWithTopWinner,
                colors = BracketDefaults.bracketColors().matchColors,
            )
        }
    }

    @Test
    fun renderWinningTeamOnBottom() {
        paparazzi.snapshot {
            BracketMatchItem(
                match = TestDisplayModels.matchWithBottomWinner,
                colors = BracketDefaults.bracketColors().matchColors,
            )
        }
    }

    @Test
    fun renderUnplayedMatch() {
        paparazzi.snapshot {
            BracketMatchItem(
                match = TestDisplayModels.matchWithNoWinner,
                colors = BracketDefaults.bracketColors().matchColors,
            )
        }
    }
}
