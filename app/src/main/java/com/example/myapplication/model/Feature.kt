package com.example.myapplication.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val name: String,
    @DrawableRes val icon: Int,
    val color: Color
)
