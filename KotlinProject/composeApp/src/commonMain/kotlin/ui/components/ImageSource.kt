package ui.components

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.DrawableResource

sealed class ImageSource(val colorFilter: ColorFilter? = null) {

    class UrlSrc(val url: String, val previewImageRes: DrawableResource? = null, colorFilter: ColorFilter? = null) : ImageSource(colorFilter)

    class ResIdSrc(val resId: DrawableResource, colorFilter: ColorFilter? = null) :
        ImageSource(colorFilter)

    class PainterSrc(val painter: Painter) : ImageSource()



    companion object {
        fun create(
            url: String? = null,
            resId: DrawableResource? = null,
            painter: Painter? = null,
            colorFilter: ColorFilter? = null
        ) = when {
            !url.isNullOrEmpty() -> UrlSrc(url)
            resId != null -> ResIdSrc(resId, colorFilter)
            painter != null -> PainterSrc(painter)
            else -> null
        }

        fun create(resId: DrawableResource): ImageSource = ResIdSrc(resId)
        fun create(url: String): UrlSrc = UrlSrc(url)
        fun create(painter: Painter): ImageSource = PainterSrc(painter)
    }
}