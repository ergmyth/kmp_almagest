package ui.tokens

interface AlmagestDesignTokens {
    val icons: AlmagestIcons
    val colors: AlmagestColors
    val typography: AlmagestTypography
}

object AlmagestDesignTokensImpl : AlmagestDesignTokens {
    override val icons: AlmagestIcons = AlmagestIconsImpl
    override val colors: AlmagestColors = AlmagestColorsImpl
    override val typography: AlmagestTypography = AlmagestTypographyImpl
}