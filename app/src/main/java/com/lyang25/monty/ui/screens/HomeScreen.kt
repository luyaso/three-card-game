package com.lyang25.monty.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lyang25.monty.R
import com.lyang25.monty.ui.NavDestination
import com.lyang25.monty.ui.theme.MontyTheme

object HomeDestination : NavDestination {
    override val route = "HOME"
    override val titleId = R.string.home
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navToGameScreen: () -> Unit = {},
    navToStatScreen: () -> Unit = {},
    navToSettingScreen: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(48.dp)
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(16.dp)
                .weight(4f)
        ) {
            Image(
                painterResource(
                    id = R.drawable.monteicon
                ),
                contentDescription = null,
                modifier = Modifier.height(256.dp).fillMaxSize()
            )

            Text(
                text = stringResource(id = R.string.app_name),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 42.sp
                ),
            )
        }
        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = navToGameScreen
            ) {
                Text(stringResource(id = R.string.play))
            }

            Button(
                onClick = navToSettingScreen
            ) {
                Text(stringResource(id = R.string.settings))
            }

            Button(
                onClick = navToStatScreen
            ) {
                Text(stringResource(id = R.string.statistics))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MontyTheme {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            navToGameScreen = {},
            navToStatScreen = {},
            navToSettingScreen = {},
        )
    }
}