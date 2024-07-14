package ui.tokens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.painter.Painter
import ergmyth.almagest.dota.resources.Res
import ergmyth.almagest.dota.resources.ic_draft
import ergmyth.almagest.dota.resources.ic_settings
import org.jetbrains.compose.resources.painterResource

val LocalIcons = staticCompositionLocalOf<AlmagestIcons> {
    error("Icons not provided")
}

interface AlmagestIcons {
    @get:Composable
    val draft: Painter

    @get:Composable
    val live: Painter

    @get:Composable
    val settings: Painter
}

object AlmagestIconsImpl : AlmagestIcons {
    override val draft: Painter
        @Composable get() = painterResource(Res.drawable.ic_draft)

    override val live: Painter
        @Composable get() = painterResource(Res.drawable.ic_draft)

    override val settings: Painter
        @Composable get() = painterResource(Res.drawable.ic_settings)
}