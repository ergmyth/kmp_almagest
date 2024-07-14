package ui.tokens

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColors = staticCompositionLocalOf<AlmagestColors> {
    error("Colors not provided")
}

interface AlmagestColors {
    val contentPrimary: Color
    val contentSecondary: Color
    val contentDisabled: Color
    val contentPlaceholder: Color
    val backgroundPrimary: Color
    val backgroundSecondary: Color
    val backgroundTertiary: Color
    val backgroundDisabled: Color
    val backgroundWarning: Color
    val backgroundOverlay: Color
    val backgroundOverlayInvert: Color
    val bordersDefault: Color
    val bordersActive: Color
    val callToActionDefault: Color
    val callToActionHover: Color
    val callToActionPressed: Color
    val systemBackground: Color
    val systemSwipeIndicator: Color
    val systemSuccess: Color
    val systemWarning: Color
    val staticBackground: Color
    val staticContent: Color
    val contrastPrimary: Color
    val contrastSecondary: Color
    val contrastContent: Color
    val accentBlue: Color
    val accentPink: Color
    val accentMint: Color
    val accentPurple: Color
    val accentYellow: Color
    val bannersDecorative1: Color
    val bannersDecorative2: Color
    val bannersDecorative3: Color
    val bannersDecorative4: Color
    val bannersDecorative5: Color
    val bannersDecorative6: Color
    val chartsDefaultChart1: Color
    val chartsDefaultChart2: Color
    val chartsDefaultChart3: Color
    val chartsDefaultChart4: Color
    val chartsDefaultChart5: Color
    val chartsDefaultChart6: Color
    val chartsDefaultChart7: Color
    val chartsDefaultChart8: Color
    val chartsDefaultChart9: Color
    val chartsActiveChart1Active: Color
    val chartsActiveChart2Active: Color
    val chartsActiveChart3Active: Color
    val chartsActiveChart4Active: Color
    val chartsActiveChart6Active: Color
    val chartsActiveChart7Active: Color
    val chartsActiveChart8Active: Color
    val chartsActiveChart9Active: Color
    val switchersLock: Color
    val transparent: Color
    val dialogShadow: Color
}

object AlmagestColorsImpl : AlmagestColors {
    override val contentPrimary = Color(0xFFFFFFFF)
    override val contentSecondary = Color(0xFFBEBEC9)
    override val contentDisabled = Color(0xFF727281)
    override val contentPlaceholder = Color(0xFF727281)
    override val backgroundPrimary = Color(0xFF2C2D37)
    override val backgroundSecondary = Color(0xFF363B4A)
    override val backgroundTertiary = Color(0xFF191C22)
    override val backgroundDisabled = Color(0xFF363B4A)
    override val backgroundWarning = Color(0xFF462621)
    override val backgroundOverlay = Color(0xCC08080A)
    override val backgroundOverlayInvert = Color(0x80F9F9F9)
    override val bordersDefault = Color(0xFF434856)
    override val bordersActive = Color(0xFFFFFFFF)
    override val callToActionDefault = Color(0xFFFFE632)
    override val callToActionHover = Color(0xFFFFD93A)
    override val callToActionPressed = Color(0xFFFFC800)
    override val systemBackground = Color(0xFF191C22)
    override val systemSwipeIndicator = Color(0xFF8E8E9F)
    override val systemSuccess = Color(0xFF0BCE73)
    override val systemWarning = Color(0xFFF45151)
    override val staticBackground = Color(0xFF191C22)
    override val staticContent = Color(0xFFFFFFFF)
    override val contrastPrimary = Color(0xFFFFFFFF)
    override val contrastSecondary = Color(0xFF727281)
    override val contrastContent = Color(0xFF191C22)
    override val accentBlue = Color(0xFF1790FF)
    override val accentPink = Color(0xFFE6008C)
    override val accentMint = Color(0xFF1EBEAA)
    override val accentPurple = Color(0xFF6432C8)
    override val accentYellow = Color(0xFFFFD93A)
    override val bannersDecorative1 = Color(0xFF4F4105)
    override val bannersDecorative2 = Color(0xFF534004)
    override val bannersDecorative3 = Color(0xFF7A1904)
    override val bannersDecorative4 = Color(0xFF7A0249)
    override val bannersDecorative5 = Color(0xFF47278E)
    override val bannersDecorative6 = Color(0xFF094D44)
    override val chartsDefaultChart1 = Color(0xFF6F6032)
    override val chartsDefaultChart2 = Color(0xFF705A29)
    override val chartsDefaultChart3 = Color(0xFF2A7870)
    override val chartsDefaultChart4 = Color(0xFF298152)
    override val chartsDefaultChart5 = Color(0xFF2D5E9F)
    override val chartsDefaultChart6 = Color(0xFF1E46A7)
    override val chartsDefaultChart7 = Color(0xFF562FA4)
    override val chartsDefaultChart8 = Color(0xFF8F275F)
    override val chartsDefaultChart9 = Color(0xFF9D321A)
    override val chartsActiveChart1Active = Color(0xFF433C2B)
    override val chartsActiveChart2Active = Color(0xFF443A27)
    override val chartsActiveChart3Active = Color(0xFF285754)
    override val chartsActiveChart4Active = Color(0xFF285D41)
    override val chartsActiveChart6Active = Color(0xFF253B83)
    override val chartsActiveChart7Active = Color(0xFF472C81)
    override val chartsActiveChart8Active = Color(0xFF672849)
    override val chartsActiveChart9Active = Color(0xFF712D1E)
    override val switchersLock = Color(0xFFC29553)
    override val transparent = Color(0x00000000)
    override val dialogShadow = Color(0xE6000000)
}

