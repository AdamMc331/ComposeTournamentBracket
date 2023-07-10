package com.adammcneilly.tournament.bracket.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import app.cash.paparazzi.Paparazzi
import com.adammcneilly.tournament.bracket.TestData
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
class MultiEliminationBracketPaparazziTest {

    @get:Rule
    val paparazzi = Paparazzi()

    @Test
    fun renderDoubleEliminationBracket() {
        paparazzi.snapshot {
            MultiEliminationBracket(
                brackets = TestData.doubleEliminationBrackets,
            )
        }
    }
}
