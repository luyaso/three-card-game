package com.lyang25.monty.ui.parts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lyang25.monty.ui.GameState
import com.lyang25.monty.ui.theme.MontyTheme

@Composable
fun SettingsRadio (
    gameState: GameState,
    solutions: List<Int>,
    onAnswer: (Int) -> Unit = {},
) {

    var selectedAnswer by remember { mutableStateOf(gameState.twist) }

    Column {
        solutions.forEachIndexed { i, answer ->

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                RadioButton(
                    selected = selectedAnswer == answer,
                    onClick = {
                        selectedAnswer = answer
                        onAnswer(i)
                    })
                Text(
                    text = "$answer",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsRadioPreview() {
    MontyTheme {
        SettingsRadio (
            solutions = listOf(3,4,5),
            gameState = GameState()
        )
    }
}