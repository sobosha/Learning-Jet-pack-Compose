package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn {
                itemsIndexed(
                    listOf(
                        "Sobhan",
                        "Sobham2",
                        "Sobhan3",
                        "Sobhan4",
                        "Sobhan5"
                    )
                ) { _, string ->
                    Text(
                        text = string,
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(12.dp),
                    )
                }
            }
        }
    }
}


