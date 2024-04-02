package com.lyang25.monty.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.lyang25.monty.game.GameCard
import com.lyang25.monty.game.Monty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MontyViewModel(app: Application) : AndroidViewModel(app) {

    private val monty = Monty()

    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState

//    init {
//        newGame()
//    }

    private fun updateState() {
        _gameState.value = _gameState.value.copy(
            cards = monty.cards,
            twist = monty.twist,
        )
    }

    fun newGame() {
        monty.newGame()
        updateState()
    }

    fun changeTwist(index: Int) {
        monty.twist = index
        updateState()
    }

    fun onTap(index: Int) {
        monty.evaluateClick(index)

        _gameState.value = _gameState.value.copy(
            gamesWon = if (monty.win) _gameState.value.gamesWon + 1 else _gameState.value.gamesWon,
            gamesPlayed = _gameState.value.gamesPlayed + 1
        )
        updateState()
    }

    fun checkForMatch() {
        monty.checkForMatch()
        updateState()
    }
}

data class GameState(
    val temp: String = "",
    val twist: Int = 3,
    val cards: List<GameCard> = emptyList(),
    val gamesWon: Int = 0,
    val gamesPlayed: Int = 0,
)