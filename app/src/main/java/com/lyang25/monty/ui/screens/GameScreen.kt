package com.lyang25.monty.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lyang25.monty.R
import com.lyang25.monty.game.Monty
import com.lyang25.monty.ui.GameState
import com.lyang25.monty.ui.NavDestination
import com.lyang25.monty.ui.parts.CardView
import com.lyang25.monty.ui.theme.MontyTheme
import kotlinx.coroutines.delay

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
    onCardTap: (Int) -> Unit,
    checkForMatch: () -> Unit,
) {
    LaunchedEffect(key1 = gameState) {
        delay(Monty.CHECK_MATCH_DELAY)
        checkForMatch()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(6f)
                .padding(16.dp)
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(gameState.cards) { item ->
                    CardView(
                        card = item,
                        onTap = onCardTap,
                        cardScale = when (gameState.twist) {
                            5 -> 0.75f
                            else -> 0.95f
                        }
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .weight(2f)
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = navToHomeScreen
            ) {
                Text(stringResource(id = R.string.back))
            }

            Button(
                onClick = resetScreen
            ) {
                Text(stringResource(id = R.string.reset))
            }
        }
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
            navToStatScreen = {},
            onCardTap = {},
            checkForMatch = {},
        )
    }
}