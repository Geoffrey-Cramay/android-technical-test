package com.etx.technical.test.ui.theme

import android.app.Activity
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val LightColorScheme = Colors(
    primary = Purple500,
    primaryVariant = Purple200,
    secondary = Teal700,
    secondaryVariant = Teal200,
    background = White,
    surface = White,
    error = NegativeRed,
    onPrimary = White,
    onSecondary = White,
    onBackground = Purple500,
    onSurface = Purple500,
    onError = White,
    isLight = true
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = LightColorScheme.primary.toArgb()
        }
    }

    MaterialTheme(
        colors = LightColorScheme,
        content = content
    )
}