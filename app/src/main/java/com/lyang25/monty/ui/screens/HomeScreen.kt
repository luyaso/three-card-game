package com.lyang25.monty.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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