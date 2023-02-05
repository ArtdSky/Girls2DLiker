package com.example.girls2dliker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

)

@Composable
fun Girls2DLikerTheme(
    content: @Composable () -> Unit
) {
    val isDarkThemeEnabled = isSystemInDarkTheme() || Girls2DLikerThemeSettings.isDarkThemeEnabled

    val colors = if (isDarkThemeEnabled) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

object Girls2DLikerThemeSettings {
    var isDarkThemeEnabled by mutableStateOf(false)
}