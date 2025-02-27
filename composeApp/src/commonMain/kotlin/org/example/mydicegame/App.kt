package org.example.mydicegame

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dicegame.composeapp.generated.resources.Res
import dicegame.composeapp.generated.resources.compose_multiplatform
import dicegame.composeapp.generated.resources.dice_1
import dicegame.composeapp.generated.resources.dice_2
import dicegame.composeapp.generated.resources.dice_3
import dicegame.composeapp.generated.resources.dice_4
import dicegame.composeapp.generated.resources.dice_5
import dicegame.composeapp.generated.resources.dice_6
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val isPlayer1 = remember { mutableStateOf(true) }
        val playerScore = remember { mutableStateOf(Array(2) { 0 }) }
        val diceImages = remember {
            listOf(
                Res.drawable.dice_1,
                Res.drawable.dice_2,
                Res.drawable.dice_3,
                Res.drawable.dice_4,
                Res.drawable.dice_5,
                Res.drawable.dice_6,
            )
        }
        val currentDiceImage = remember { mutableStateOf(Res.drawable.compose_multiplatform) }
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(modifier = Modifier.size(50.dp))
            Text(
                text = "Welcome to Dice Rolling game ",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(currentDiceImage.value),
                contentDescription = null,
                modifier = Modifier.size(250.dp).align(Alignment.CenterHorizontally)
            )
            OutlinedButton(
                onClick = {
                    val randomNumber = (1..6).random()
                    currentDiceImage.value = diceImages.get(randomNumber - 1)
                    if (isPlayer1.value) {
                        playerScore.value[0] += randomNumber
                    } else
                        playerScore.value[1] += randomNumber
                    isPlayer1.value = !isPlayer1.value
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                if (isPlayer1.value)
                    Text(text = "Roll the dice for player 1")
                else
                    Text(text = "Roll the dice for player 2  ")
                //Text(text = "Roll the dice")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
            ) {
                Text(
                    text = "Player one score\n ${playerScore.value.get(0)}",
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Text(
                    text = "Player two score\n ${playerScore.value.get(1)}",
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(30.dp))


        }

    }
}