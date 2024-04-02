package com.lyang25.monty.game

class Monty() {

    companion object {
//        const val NUM_CARDS = 16
//        const val SCORE_INCREMENT = 4
        const val CHECK_MATCH_DELAY = 1200L
        const val FLIP_DURATION = 400

//        const val BACK_FACE = R.drawable.card_back
//        val BACK_COLOR: Color = Color(0xF000490A)
//        val FRONT_COLOR: Color = Color(0xF0FCEFE1)
    }

    var cards: List<GameCard> = emptyList()
    var win = false
    var twist = 3

    fun newGame() {
        win = false
//        cards = when (index) {
//            4 -> listOf(true, false, false, false)
//            5 -> listOf(true, false, false, false, false)
//            else -> listOf(true, false, false)
//        }
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
    }
    fun checkForMatch() {
        for (card in cards) {
            if (card.value && card.faceUp) win = true
        }
//        cards[index].let{
//            if (it.value) win = true
//            it.faceUp = true
//        }
//        val card = cards[index]
//        card.faceUp = true
//        if (card.value) win = true
    }

}