package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraints = ConstraintSet{
                val redBox = createRefFor("red_box")
                val blueBox = createRefFor("blue_box")

                constrain(redBox){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(50.dp)
                    height = Dimension.value(200.dp)
                }

                constrain(blueBox){
                    top.linkTo(parent.top)
                    start.linkTo(redBox.end)
                    width = Dimension.value(200.dp)
                    height = Dimension.value(200.dp)
                }
                createHorizontalChain(redBox , blueBox , chainStyle = ChainStyle.Packed)
            }

            ConstraintLayout(modifier = Modifier.fillMaxSize(), constraintSet = constraints) {
                Box(modifier = Modifier.background(Color.Red).layoutId("red_box"))
                Box(modifier = Modifier.background(Color.Blue).layoutId("blue_box"))
            }
        }
    }
}


