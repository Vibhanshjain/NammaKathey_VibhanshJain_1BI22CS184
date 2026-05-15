package com.example.nammakathey.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = BrandOrange,
    secondary = BrandBrown,
    tertiary = BrandGreen,
    background = BrandBeige,
    surface = BrandBeige,
    onPrimary = androidx.compose.ui.graphics.Color.White,
    onSecondary = androidx.compose.ui.graphics.Color.White,
    onTertiary = androidx.compose.ui.graphics.Color.White,
    onBackground = BrandBrown,
    onSurface = BrandBrown,
)

private val DarkColorScheme = androidx.compose.material3.darkColorScheme(
    primary = BrandOrange,
    secondary = BrandBrown,
    tertiary = BrandGreen,
    background = androidx.compose.ui.graphics.Color(0xFF121212),
    surface = androidx.compose.ui.graphics.Color(0xFF1E1E1E),
    onPrimary = androidx.compose.ui.graphics.Color.White,
    onSecondary = androidx.compose.ui.graphics.Color.White,
    onTertiary = androidx.compose.ui.graphics.Color.White,
    onBackground = BrandBeige,
    onSurface = BrandBeige,
)

@Composable
fun NammaKatheyTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content
    )
}
