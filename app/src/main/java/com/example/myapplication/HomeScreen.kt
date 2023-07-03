package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Feature


@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
    ) {
        GreetingSection()
        ChooseSection(chips = listOf("Sweet Dream", "Insomnia", "Depression"))
        PlayMusicSection(musicName = "Sobhan")
        FeatureSection(
            features = listOf(
                Feature(
                    "Music String", R.drawable
                        .ic_play_circle, Color.Green
                )
            )
        )
    }
}

@Composable
fun GreetingSection(
    name: String = "Sobhan"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.White
            )
            Text(
                text = "We wish you have good day;",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.White
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search",
            tint = Color.White
        )
    }
}

@Composable
fun ChooseSection(
    chips: List<String>
) {
    var selectChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(contentPadding = PaddingValues(12.dp, 12.dp)) {
        itemsIndexed(chips) { index, string ->
            Box(modifier = Modifier
                .width(64.dp)
                .height(48.dp)
                .background(
                    if (selectChipIndex == index) Color.Magenta else Color.Gray
                )
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .clickable {
                    selectChipIndex = index
                }
                .padding(15.dp)
            ) {
                Text(
                    text = string,
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun PlayMusicSection(
    musicName: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Red)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = musicName, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Media . 3:10", style = MaterialTheme.typography.headlineSmall)
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_play_circle),
            contentDescription = "Play"
        )
    }
}

@Composable
fun FeatureSection(
    features: List<Feature>
) {
    Column {
        Text(
            text = "Features",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                Feature(feature = features[it])
            }
        }
    }
}

@Composable
fun Feature(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .background(feature.color)
    ) {
        Text(
            text = feature.name,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.align(
                Alignment.TopStart
            )
        )
        Icon(
            painter = painterResource(id = feature.icon),
            contentDescription = "Feature Icon",
            tint = Color.White,
            modifier = Modifier.align(Alignment.BottomStart)
        )
        Text(
            text = "Start",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
                .align(
                    Alignment.BottomEnd
                )
                .background(Color.DarkGray)
                .padding(4.dp)
                .clip(RoundedCornerShape(12.dp))
        )
    }
}