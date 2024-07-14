package ui.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val LocalTypography = staticCompositionLocalOf<AlmagestTypography> {
    error("Typography not provided")
}

interface AlmagestTypography {
    val titleM: TextStyle
    val titleS: TextStyle
    val headBold: TextStyle
    val headMed: TextStyle
    val bodyMMed: TextStyle
    val bodyMReg: TextStyle
    val bodySMed: TextStyle
    val bodySReg: TextStyle
    val calloutMed: TextStyle
    val calloutReg: TextStyle
    val captionMed: TextStyle
    val captionReg: TextStyle
}

object AlmagestTypographyImpl : AlmagestTypography {
    override val titleM: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 32.sp, lineHeight = 36.sp)
    override val titleS: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 24.sp, lineHeight = 28.sp)
    override val headBold: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Bold, fontSize = 20.sp, lineHeight = 24.sp)
    override val headMed: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 20.sp, lineHeight = 24.sp)
    override val bodyMMed: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 18.sp, lineHeight = 24.sp)
    override val bodyMReg: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 18.sp, lineHeight = 24.sp)
    override val bodySMed: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 20.sp)
    override val bodySReg: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 20.sp)
    override val calloutMed: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 16.sp)
    override val calloutReg: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 16.sp)
    override val captionMed: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp)
    override val captionReg: TextStyle =
        TextStyle(fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp)

}

