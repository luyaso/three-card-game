package com.lyang25.monty.ui.parts

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lyang25.monty.R
import com.lyang25.monty.game.GameCard
import com.lyang25.monty.game.Monty

@Composable
fun CardView(
    card: GameCard,
    onTap: (Int) -> Unit,
    cardScale: Float,
) {
    val flip by animateFloatAsState(
        targetValue = if (card.faceUp) 180f else 0f,
        animationSpec = tween(Monty.FLIP_DURATION, easing = FastOutSlowInEasing),
        label = "flip"
    )

    val showFront by animateFloatAsState(
        targetValue = if (card.faceUp) 0f else 1f,
        animationSpec = tween(Monty.FLIP_DURATION, easing = FastOutSlowInEasing),
        label = "showFront"
    )

    val showBack by animateFloatAsState(
        targetValue = if (card.faceUp) 1f else 0f,
        animationSpec = tween(Monty.FLIP_DURATION, easing = FastOutSlowInEasing),
        label = "showBack"
    )

    Box(
        Modifier
            .fillMaxSize(),
//            .alpha(if (card.solved) 0f else 1f),
        contentAlignment = Alignment.Center
    ) {
        Card(
            Modifier
                .fillMaxSize(cardScale)
                .graphicsLayer {
                    rotationY = flip
                }
                .clickable {
                    onTap(card.index)
                },
//            shape = RoundedCornerShape(21.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(2.dp)
                ) {

                    Image(
                        painter = if (card.faceUp) {
                            if (card.value) painterResource(id = R.drawable.ace_spades)
                            else painterResource(id = R.drawable.blank_card)
                        } else painterResource(id = R.drawable.card_back),
                        modifier = Modifier
                            .graphicsLayer {
                                alpha = if (card.faceUp) showBack else showFront
                                rotationY = if (card.faceUp) 180f else 0f
                            },
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CardViewPreview() {
    CardView(
        card = GameCard(index = 0, value = false, faceUp = false),
        onTap = {},
        cardScale = 0.95f)
}