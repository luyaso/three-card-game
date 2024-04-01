package com.lyang25.monty.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyang25.monty.R
import com.lyang25.monty.ui.NavDestination

object SettingDestination : NavDestination {
    override val route = "SETTINGS"
    override val titleId = R.string.settings
}

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    navToHomeScreen: () -> Unit = {},
) {

}