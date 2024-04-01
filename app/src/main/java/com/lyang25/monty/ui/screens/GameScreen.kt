package com.lyang25.monty.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyang25.monty.R
import com.lyang25.monty.ui.GameState
import com.lyang25.monty.ui.NavDestination

object GameDestination : NavDestination {
    override val route = "GAME"
    override val titleId = R.string.game
}

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    gameState: GameState,
    navToHomeScreen: () -> Unit = {},
    navToStatScreen: (Int) -> Unit = {},
) {

}