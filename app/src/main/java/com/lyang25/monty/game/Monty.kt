package com.lyang25.monty.game

class Monty() {

    companion object {
        const val CHECK_MATCH_DELAY = 1200L
        const val FLIP_DURATION = 400
    }

    var cards: List<GameCard> = emptyList()
    var win = false
    var twist = 3

    fun newGame() {
        win = false
        val tempCards: MutableList<GameCard> = ArrayList()
        tempCards.add(GameCard(index = 1, value = true))
        for (i in 1 until twist) {
            tempCards.add(GameCard(index = i+1))
        }
        tempCards.shuffle()

        cards = tempCards
    }

    fun evaluateClick(index: Int) {
        for (card in cards) {
            if (card.index == index) {
                card.faceUp = true
            }
        }

        checkForMatch()
    }
    fun checkForMatch() {
        for (card in cards) {
            if (card.value && card.faceUp) win = true
        }
    }
}