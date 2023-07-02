package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.net.ContentHandler

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageCard(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                description = "Sobhan is here"
            )
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    description: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.3f)
            .padding(12.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f),
                painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black),
                            startY = 0.2f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(1f)
                    .padding(8.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = description, style = TextStyle(Color.White, fontSize = 16.sp))
            }
        }
    }
}

