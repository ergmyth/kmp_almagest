package ui.components.label

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.tokens.AlmagestTheme

/**
 * Компонент [Label] для отображения текста, альтернатива [TextView]
 *
 * Преимущество: поддержка базовых html тэгов (пр. [ru.beeline.designsystem.storybook.samples.LabelSample])
 * Список поддерживаемых html тегов находится в [ru.beeline.designsystem.foundation.label.HtmlConstants]
 *
 * @param textResId айдишник строки в ресурсах,
 * напр: R.string.app_name
 * @param modifier параметр отображения вьюшки в компоузе,
 * напр: modifier.size(5.dp)
 * @param color цвет текста
 * (может передаваться только в компоуз функциях)
 * @param fontStyle стиль шрифта (normal, italic etc.)
 * @param letterSpacing расстояние между символами текста
 * напр: 5.sp
 * @param textDecoration декорация для текста
 * напр: UnderLine (подчеркнутый текст) LineThrough (перечеркнутый текст)
 * @param textAlign расположение текста
 * напр: Center, Left, End
 * @param lineHeight высота линии
 * работает аналогично одновременному заданному paddingTop и paddingBottom
 * @param overflow параметр для урезания текста, который не вмещается в Label
 * напр: TextOverflow.Ellipsis добавляет троеточние в конец текста...
 * @param softWrap флаг для выравнивания текста при разрывах
 * @param maxLines количество строк в Label
 * @param inlineContent определяет дополнительный @Composable UI который можно встроить в текст
 * определяет @Composable функцию которую можно расположить в текста через buildAnnotatedString {}
 * @param onTextLayout колбек который вызывается после отрисовки лэаута текста
 * может быть использован для добавления дополнительного оформления, например нарисовать выделение
 * @param style стиль текста = шрифт + размер шрифта + стиль шрифта
 * рекомендуется использовать только те, которые содержатся в NectarTheme.typography
 */
@Composable
fun Label(
    textRes: StringResource,
    modifier: Modifier = Modifier,
    color: Color = AlmagestTheme.colors.contentPrimary,
    fontSize: TextUnit? = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit? = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Unspecified,
    lineHeight: TextUnit? = TextUnit.Unspecified,
    overflow: LabelOverflow = LabelOverflow.Clip,
    softWrap: Boolean? = true,
    maxLines: Int? = Int.MAX_VALUE,
    onTextLayout: ((TextLayoutResult) -> Unit)? = {},
    style: TextStyle? = LocalTextStyle.current,
) {
    Label(
        text = stringResource(textRes),
        modifier = modifier,
        color = color,
        fontSize = fontSize ?: TextUnit.Unspecified,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing ?: TextUnit.Unspecified,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight ?: TextUnit.Unspecified,
        overflow = overflow,
        softWrap = softWrap ?: true,
        maxLines = maxLines ?: Int.MAX_VALUE,
        onTextLayout = onTextLayout ?: {},
        style = style ?: LocalTextStyle.current,
    )
}

/**
 * Компонент [Label] для отображения текста, альтернатива [TextView]
 * Преимущество: поддержка базовых html тэгов
 *
 * @param text текст в формате [String]
 * @param modifier параметр отображения вьюшки в компоузе,
 * напр: modifier.size(5.dp)
 * @param color цвет текста
 * (может передаваться только в компоуз функциях)
 * @param fontSize размер шрифта
 * (не рекомендуется явно прописывать, необходимо передавать через параметр [style])
 * @param fontStyle стиль шрифта (bold, italic etc.)
 * (не рекомендуется явно прописывать, необходимо передавать через параметр [style])
 * @param fontFamily шрифт текста
 * (не рекомендуется явно прописывать, необходимо передавать через параметр [style])
 * @param letterSpacing расстояние между символами текста
 * напр: 5.sp
 * @param textDecoration декорация для текста
 * напр: UnderLine (подчеркнутый текст) LineThrough (перечеркнутый текст)
 * @param textAlign расположение текста
 * напр: Center, Left, End
 * @param lineHeight высота линии
 * работает аналогично одновременному заданному paddingTop и paddingBottom
 * @param overflow параметр для урезания текста, который не вмещается в Label
 * @param softWrap флаг для выравнивания текста при разрывах
 * @param maxLines количество строк в Label
 * @param inlineContent определяет дополнительный @Composable UI который можно встроить в текст
 * определяет @Composable функцию которую можно расположить в текста через buildAnnotatedString {}
 * @param onTextLayout колбек который вызывается после отрисовки лэаута текста
 * может быть использован для добавления дополнительного оформления, например нарисовать выделение
 * @param style стиль текста = шрифт + размер шрифта + стиль шрифта
 * рекомендуется использовать только те, которые содержатся в NectarTheme.typography
 */
@Composable
fun Label(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AlmagestTheme.colors.contentPrimary,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: LabelOverflow = LabelOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
) {
    BasicLabel(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = style,
    )
}

@Composable
fun Label(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    color: Color = AlmagestTheme.colors.contentPrimary,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: LabelOverflow = LabelOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    inlineContent: Map<String, InlineTextContent> = emptyMap(),
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current
) {
    BasicLabel(
        text = text,
        color = color,
        style = style,
        modifier = modifier,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = lineHeight,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        inlineContent = inlineContent,
        onTextLayout = onTextLayout
    )
}



@Preview
@Composable
private fun AnnotatedLabelPreview() {
    AlmagestTheme {
        Label(
            text = buildAnnotatedString {
                append("текст текст ")
                withStyle(
                    style = SpanStyle(
                        color = AlmagestTheme.colors.contentSecondary,
                        textDecoration = TextDecoration.LineThrough
                    )
                ) {
                    append("скидка")
                }
                append(" текст")
            },
            modifier = Modifier.padding(20.dp),
            style = AlmagestTheme.typography.bodySReg
        )
    }
}
