package com.lyang25.monty.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lyang25.monty.R
import com.lyang25.monty.ui.NavDestination

object StatDestination : NavDestination {
    override val route = "STAT"
    override val titleId = R.string.stat
}


@Composable
fun StatScreen(
    modifier: Modifier = Modifier,
    navToHomeScreen: () -> Unit = {},
) {

}