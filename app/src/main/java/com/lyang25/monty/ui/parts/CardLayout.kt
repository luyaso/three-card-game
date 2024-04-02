package com.lyang25.monty.ui.parts

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lyang25.monty.R
import com.lyang25.monty.game.GameCard
import com.lyang25.monty.ui.theme.MontyTheme

@Composable
fun CardRow(
    segCard: List<GameCard>
) {

    var imgResource = R.drawable.card_back

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (card in segCard) {
            if (card.value) {
                Image(
                    painterResource(
                        id = imgResource
                    ),
                    modifier = Modifier
                        .width(144.dp)
                        .clickable {
                            imgResource = R.drawable.ace_spades
                        },
                    contentDescription = null
                )
            } else {
                Image(
                    painterResource(
                        id = R.drawable.blank_card
                    ),
                    modifier = Modifier.width(144.dp),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun CardLayout(
    cards: List<GameCard>,
) {
    Column() {
        Box (
            modifier = Modifier.weight(1f)
        ) {
            CardRow(
                segCard = cards.subList(0,2)
            )
        }

        Box (
            modifier = Modifier.weight(1f)
        ) {
            when (cards.count()) {
                3 -> CardRow(
                    segCard = cards.subList(2,3)
                )
                else -> CardRow(
                    segCard = cards.subList(2,4)
                )
            }
        }

        if (cards.count() > 4) {
            Box (
                modifier = Modifier.weight(1f)
            ) {
                CardRow(
                    segCard = cards.subList(4,5)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardLayoutPreview() {
    MontyTheme {
//        CardLayout(
//              cards = listOf(true, false, false, false, false)
//        )
    }
}