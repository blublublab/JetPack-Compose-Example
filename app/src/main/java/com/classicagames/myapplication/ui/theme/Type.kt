package com.classicagames.myapplication.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.classicagames.myapplication.R

// Set of Material typography styles to start with

private val Rubik = FontFamily(
    Font(R.font.rubik_regular),
    Font(
        R.font.rubik_medium,
        weight = FontWeight.Medium
    ),
    Font(
        R.font.rubik_bold,
        weight = FontWeight.Bold
    )

)

val Typography = Typography(
    defaultFontFamily = Rubik,
    h1 = TextStyle(
        fontWeight =  FontWeight.Bold,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    h4 = TextStyle(
        fontWeight =  FontWeight.Bold,
        fontSize = 34.sp,
        letterSpacing = (-1.5).sp,
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Thin,
        fontSize = 20.sp,
        letterSpacing = (0.5).sp
    )
)