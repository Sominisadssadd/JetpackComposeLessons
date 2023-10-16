package com.example.jetpackcomposelessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimesTable()
        }
    }
}


@Preview
@Composable
fun TimesTable() {
    ProfileCard()
}

@Composable
fun ProfileCard() {

    Card(
        shape = RoundedCornerShape(
            topStart = 5.dp,
            topEnd = 5.dp,
        ),
        modifier = Modifier.background(Color.White),
        border = BorderStroke(1.dp, Color.Black),
    ) {
        val rowHeight = 100
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(rowHeight.dp),
            horizontalArrangement = Arrangement.Center

        ) {

            val boxHeight = 50
            val boxWidth = 50

            Box(

                modifier = Modifier
                    .background(Color.Green)
                    .width(boxWidth.dp)
                    .align(Alignment.CenterVertically)
                    .height(boxHeight.dp)


            )

            for (i in 0 until 3) {

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    contentAlignment = Alignment.Center,


                    ) {
                    val textSizeNumbers = 80
                    val textSizeDescription = 60

                    when (i) {
                        0 -> {
                            Text(
                                text = "Posts",
                                modifier = Modifier

                                    .wrapContentHeight()
                                    .size(textSizeDescription.dp),
                                textAlign = TextAlign.Center

                            )
                        }
                        1 -> {
                            Text(
                                text = "Followers",
                                modifier = Modifier


                                    .size(textSizeDescription.dp),
                                textAlign = TextAlign.Center
                            )

                        }
                        2 -> {
                            Text(
                                text = "Following",
                                modifier = Modifier

                                    .size(textSizeDescription.dp)
                            )

                        }
                    }

                    if (i == 1) {
                        Text(
                            text = randomNumber(true),
                            modifier = Modifier
                                .size(textSizeNumbers.dp)
                                .wrapContentHeight(),
                            textAlign = TextAlign.Center
                        )
                    } else {
                        Text(
                            text = randomNumber(false),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(textSizeNumbers.dp)
                                .wrapContentHeight(),
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }


        }
    }


}

private fun randomNumber(isFollowers: Boolean): String {
    if (isFollowers) {
        return Random().nextInt(500).toString() + "M"
    } else {
        return Random().nextInt(50_000).toString()
    }
}







