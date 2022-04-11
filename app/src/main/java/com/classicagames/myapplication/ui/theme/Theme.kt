package com.classicagames.myapplication.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



private val LightColorPalette = lightColors(
    primary = Yellow400,
    primaryVariant = Yellow500,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    secondary = Blue700,
    secondaryVariant = Blue800,
)

private val DarkColorPalette = darkColors(
    primary = DarkBlue900,
    primaryVariant = DarkBlue700,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    secondary = Yellow400,
    secondaryVariant = Yellow500
)


@Composable
fun YellowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content : @Composable () -> Unit,
){
    MaterialTheme(
        colors = if(darkTheme)  DarkColorPalette else LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}