package com.lyang25.monty.ui

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lyang25.monty.ui.screens.GameDestination
import com.lyang25.monty.ui.screens.GameScreen
import com.lyang25.monty.ui.screens.HomeDestination
import com.lyang25.monty.ui.screens.HomeScreen
import com.lyang25.monty.ui.screens.SettingDestination
import com.lyang25.monty.ui.screens.SettingScreen
import com.lyang25.monty.ui.screens.StatDestination
import com.lyang25.monty.ui.screens.StatScreen

interface NavDestination {
    val route: String
    val titleId: Int
}

@Composable
fun MontyNavHost(
    viewModel: MontyViewModel,
    gameState: GameState,
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {

        composable(
            route = HomeDestination.route
        ) {
            HomeScreen(
                navToGameScreen = {
                    viewModel.newGame()
                    navController.navigate(GameDestination.route)
                },
                navToStatScreen = {
                    navController.navigate(StatDestination.route)
                },
                navToSettingScreen = {
                    navController.navigate(SettingDestination.route)
                },
            )
        }

        composable(
            route = GameDestination.route
        ) {
            GameScreen(
                gameState = gameState,
                navToHomeScreen = {
                    navController.navigate(HomeDestination.route)
                },
                navToStatScreen = {
                    //viewModel.answerQuestion(index = it)
                    navController.navigate(StatDestination.route)
                },
                resetScreen = {
                    viewModel.newGame()
                    navController.navigate(GameDestination.route)
                },
                onCardTap = {
                    viewModel.onTap(index = it)
                },
                checkForMatch = {
                    viewModel.checkForMatch()
                }
            )
        }

        composable(
            route = SettingDestination.route
        ) {
            SettingScreen(
                navToHomeScreen = {
                    navController.navigate(HomeDestination.route)
                },
                gameState = gameState,
                onAnswer = {
                    viewModel.changeTwist(it)
                }
            )
        }

        composable(
            route = StatDestination.route
        ) {
            StatScreen(
                navToHomeScreen = {
                    navController.navigate(HomeDestination.route)
                },
                gameState = gameState,
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyMontyApp(
    navController: NavHostController = rememberNavController(),
    viewModel: MontyViewModel,
    gameState: GameState
) {
    MontyNavHost(
        viewModel = viewModel(),
        gameState = gameState,
        navController = navController
    )
}