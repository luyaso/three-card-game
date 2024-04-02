package com.lyang25.monty.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.lyang25.monty.ui.parts.SettingsRadio

object SettingDestination : NavDestination {
    override val route = "SETTINGS"
    override val titleId = R.string.settings
}

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    navToHomeScreen: () -> Unit = {},
    gameState: GameState,
    onAnswer: (Int) -> Unit = {},
) {

    var answerIdx by remember { mutableIntStateOf(1) }

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(48.dp)
            .fillMaxSize(),
    ) {
        Column(
            modifier.weight(1f)
        ) {
            Text(
                text = stringResource(R.string.question),
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 24.sp
                ),
                modifier = modifier
            )
        }

        Column(
            modifier = Modifier.weight(2f)
        ) {
            SettingsRadio(
                gameState = gameState,
                solutions = listOf(3,4,5)
            ) {
                answerIdx = it
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.weight(2f)
        ) {
            Button(
                enabled = answerIdx != -1,
                onClick = {
                    onAnswer(answerIdx+3)
                }) {
                Text(stringResource(id = R.string.save))
            }

            Button(
                onClick = navToHomeScreen
            ) {
                Text(stringResource(id = R.string.back))
            }
        }
    }
}
