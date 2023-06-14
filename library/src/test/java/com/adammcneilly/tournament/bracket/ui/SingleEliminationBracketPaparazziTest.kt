package com.adammcneilly.tournament.bracket.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import app.cash.paparazzi.Paparazzi
import com.adammcneilly.tournament.bracket.TestData
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalFoundationApi::class)
class SingleEliminationBracketPaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun renderSingleEliminationBracket() {
        paparazzi.snapshot {
            SingleEliminationBracket(
                bracket = TestData.singleEliminationBracket,
            )
        }
    }
}
