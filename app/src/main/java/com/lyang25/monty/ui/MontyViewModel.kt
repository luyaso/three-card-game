package com.lyang25.monty.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MontyViewModel(app: Application) : AndroidViewModel(app) {

    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState

    init {
        //do stuff
    }

    fun newGame() {
        val myList = when (_gameState.value.twist) {
            4 -> mutableListOf(true, false, false, false)
            5 -> mutableListOf(true, false, false, false, false)
            else -> mutableListOf(true, false, false)
        }
        myList.shuffle()

        _gameState.value = _gameState.value.copy(
            cards = myList
        )
    }

    fun changeTwist(index: Int) {
        _gameState.value = _gameState.value.copy(
            twist = index
        )
    }

    fun endGame(win: Boolean) {
        val newWon = if (win) {
            _gameState.value.gamesWon + 1
        } else {
            _gameState.value.gamesWon
        }
        val newPlayed = _gameState.value.gamesPlayed + 1

        _gameState.value = _gameState.value.copy(
            gamesWon = newWon,
            gamesPlayed = newPlayed
        )
    }
}

data class GameState(
    val temp: String = "",
    val twist: Int = 3,
    val cards: List<Boolean> = emptyList(),
    val gamesWon: Int = 0,
    val gamesPlayed: Int = 0,
)