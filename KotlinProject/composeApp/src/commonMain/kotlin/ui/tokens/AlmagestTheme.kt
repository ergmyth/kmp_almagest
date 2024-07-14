package ui.tokens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AlmagestTheme(
    tokens: AlmagestDesignTokens = AlmagestDesignTokensImpl,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalIcons provides tokens.icons,
        content = content
    )
}


object AlmagestTheme {
    val icons: AlmagestIcons
        @Composable
        get() = LocalIcons.current
    val typography: AlmagestTypography
        @Composable
        get() = LocalTypography.current
    val colors: AlmagestColors
        @Composable
        get() = LocalColors.current
}