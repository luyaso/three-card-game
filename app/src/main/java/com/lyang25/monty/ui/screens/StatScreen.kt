package com.lyang25.monty.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyang25.monty.R
import com.lyang25.monty.ui.GameState
import com.lyang25.monty.ui.NavDestination

object StatDestination : NavDestination {
    override val route = "STAT"
    override val titleId = R.string.stat
}


@Composable
fun StatScreen(
    modifier: Modifier = Modifier,
    gameState: GameState,
    navToHomeScreen: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.weight(2f).padding(24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.statscreen),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp
                ),
            )
        }

        Column(
            modifier = Modifier.weight(4f),
//            verticalArrangement = Arrangement.Center
        ) {
            Row() {
                Text(
                    text = stringResource(R.string.gamesplayed),
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp
                    ),
                )
                Text(
                    text = "${gameState.gamesPlayed}",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp
                    )
                )
            }
            Row() {
                Text(
                    text = stringResource(R.string.gameswon),
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp
                    )
                )
                Text(
                    text = "${gameState.gamesWon}",
                    style = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp
                    )
                )
            }
        }
        
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Button(onClick = navToHomeScreen) {
                Text(text = stringResource(id = R.string.back))
            }
        }
    }
}