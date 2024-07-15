package ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource

@Composable
fun Picture(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    image: ImageSource,
    colorFilter: ColorFilter? = image.colorFilter,
    alpha: Float = 1f,
    scale: ContentScale = ContentScale.Fit,
    placeholderScale: ContentScale = ContentScale.Fit,
    useDefaultPreview: Boolean = false
) {
    when (image) {
        is ImageSource.ResIdSrc -> {
            Image(
                modifier = modifier,
                painter = painterResource(image.resId),
                contentDescription = contentDescription,
                contentScale = scale,
                alpha = alpha,
                colorFilter = colorFilter
            )
        }
        else -> Unit
//        is ImageSource.UrlSrc -> {
//            val previewImage = image.previewImageRes //todo if (useDefaultPreview) R.drawable.app_icon_mono else null
//            GlideImage(
//                modifier = modifier,
//                imageModel = { image.url },
//                imageOptions = ImageOptions(
//                    contentScale = scale,
//                    alpha = alpha,
//                    colorFilter = colorFilter
//                ),
//                previewPlaceholder = previewImage ?: 0,
//                loading = {
//                    if (previewImage != null) {
//                        Image(
//                            modifier = modifier,
//                            painter = painterResource(previewImage),
//                            contentDescription = contentDescription,
//                            alpha = alpha,
//                            contentScale = placeholderScale,
//                            colorFilter = colorFilter
//                        )
//                    }
//                },
//                failure = {
//                    if (previewImage != null) {
//                        Image(
//                            modifier = modifier,
//                            painter = painterResource(previewImage),
//                            contentDescription = contentDescription,
//                            alpha = alpha,
//                            contentScale = placeholderScale,
//                            colorFilter = colorFilter
//                        )
//                    }
//                }
//            )
//        }
    }
}