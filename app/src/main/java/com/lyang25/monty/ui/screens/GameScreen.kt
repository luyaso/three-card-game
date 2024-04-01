package com.lyang25.monty.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lyang25.monty.R
import com.lyang25.monty.ui.GameState
import com.lyang25.monty.ui.NavDestination
import com.lyang25.monty.ui.parts.CardLayout
import com.lyang25.monty.ui.theme.MontyTheme

object GameDestination : NavDestination {
    override val route = "GAME"
    override val titleId = R.string.game
}

@Composable
fun GameScreen(
    modifier: Modifier = Modifier.padding(16.dp),
    gameState: GameState,
    navToHomeScreen: () -> Unit = {},
    navToStatScreen: () -> Unit = {},
    resetScreen: () -> Unit = {},
) {
    Column() {
        CardLayout(cards = gameState.cards)
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    MontyTheme {
        GameScreen(
            modifier = Modifier.fillMaxSize(),
            gameState = GameState(),
            navToHomeScreen = {},
            navToStatScreen = {}
        )
    }
}