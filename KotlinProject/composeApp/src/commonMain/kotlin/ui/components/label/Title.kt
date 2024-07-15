package ui.components.label

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.components.HorizontalSpacer
import ui.components.ImageSource
import ui.components.Picture
import ui.components.VerticalSpacer
import ui.components.modifier.noRippleClickable
import ui.tokens.AlmagestTheme

enum class TitleSize {
    L, M, S, XS
}

/**
 * Заголовок.
 * @param title основной текст заголовка
 * @param subtitle опциональный подзаголовок
 * @param size размер заголовка
 * @param titleMaxLines максимально число строк заголовка
 * @param subtitleMaxLines максимальное число строк подзаголовка
 * @param titleOverflow вид обрезания заголовка при переполнении
 * @param subtitleOverflow вид обрезания подзаголовка при переполнении
 * @param textAlign выравнивание заголовка и подзаголовка
 * @param rightText текст у кнопки справа
 * @param rightIcon иконка у кнопки срава
 * @param rightIconSize размер иконки у кнопки справа
 * @param rightContentTint цвет кнопки справа
 * @param onRightContentClick колбэк при клике на кнопку справа
 */
@Composable
fun Title(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String = "",
    size: TitleSize,
    titleMaxLines: Int = Int.MAX_VALUE,
    subtitleMaxLines: Int = Int.MAX_VALUE,
    titleOverflow: LabelOverflow = LabelOverflow.EllipsisEnd,
    subtitleOverflow: LabelOverflow = LabelOverflow.EllipsisEnd,
    textAlign: TextAlign = TextAlign.Start,
    rightText: String = "",
    rightIcon: ImageSource? = null,
    rightIconSize: Dp = Dp.Unspecified,
    rightContentTint: Color? = null,
    onRightContentClick: () -> Unit = {}
) {
    val style = when (size) {
        TitleSize.L -> AlmagestTheme.typography.titleM
        TitleSize.M -> AlmagestTheme.typography.titleS
        TitleSize.S -> AlmagestTheme.typography.headMed
        TitleSize.XS -> AlmagestTheme.typography.bodyMReg
    }
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Label(
                modifier = Modifier.weight(1f),
                style = style,
                textAlign = textAlign,
                text = title,
                maxLines = titleMaxLines,
                overflow = titleOverflow
            )
            if (rightText.isNotEmpty() || rightIcon != null) {
                HorizontalSpacer(dp = 12)
                TitleRightContent(
                    onRightContentClick = onRightContentClick,
                    rightText = rightText,
                    rightContentTint = rightContentTint,
                    rightIcon = rightIcon,
                    rightIconSize = rightIconSize
                )
            }
        }
        if (subtitle.isNotEmpty()) {
            VerticalSpacer(dp = 8)
            Label(
                style = AlmagestTheme.typography.bodyMReg,
                text = subtitle,
                color = AlmagestTheme.colors.contentSecondary,
                maxLines = subtitleMaxLines,
                overflow = subtitleOverflow
            )
        }
    }
}

@Composable
private fun TitleRightContent(
    modifier: Modifier = Modifier,
    rightText: String,
    rightIcon: ImageSource?,
    rightIconSize: Dp,
    rightContentTint: Color?,
    onRightContentClick: () -> Unit
) {
    Row(
        modifier = modifier.noRippleClickable(onClick = onRightContentClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (rightText.isNotEmpty()) {
            Label(
                text = rightText,
                color = rightContentTint ?: AlmagestTheme.colors.contentPrimary,
                style = AlmagestTheme.typography.bodySMed
            )
        }
        if (rightText.isNotEmpty() && rightIcon != null) {
            HorizontalSpacer(dp = 4)
        }
        if (rightIcon != null) {
            Picture(
                image = rightIcon,
                colorFilter = rightContentTint?.let(ColorFilter::tint),
                modifier = Modifier.size(
                    when {
                        rightIconSize.isSpecified -> rightIconSize
                        rightText.isNotEmpty() -> 20.dp
                        else -> 24.dp
                    }
                )
            )
        }
    }
}

@Preview
@Composable
fun TitlePreview() {
    AlmagestTheme {
        Column(modifier = Modifier.padding(20.dp)) {
            Title(
                title = "Title",
                size = TitleSize.L,
                rightText = "More",
                rightIcon = ImageSource.PainterSrc(AlmagestTheme.icons.draft),
                rightContentTint = AlmagestTheme.colors.contentSecondary
            )
            VerticalSpacer(dp = 32)
            Title(
                title = "Text text",
                size = TitleSize.S,
                textAlign = TextAlign.Center,
                titleMaxLines = 2,
                rightIcon = ImageSource.PainterSrc(AlmagestTheme.icons.draft)
            )
        }
    }
}