package ui.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ui.components.colorAnimation
import ui.components.modifier.applyIf
import ui.components.modifier.debounceClickable
import ui.tokens.AlmagestTheme

enum class ButtonStyle {
    PRIMARY, SECONDARY, ERROR
}

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    style: ButtonStyle = ButtonStyle.PRIMARY,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    fillMaxWidth: Boolean = true,
    paddingValues: PaddingValues = PaddingValues(horizontal = 20.dp),
    onClick: () -> Unit
) {
    BaseButton(
        modifier = modifier,
        isLoading = isLoading,
        onClick = onClick,
        style = style,
        enabled = enabled,
        fillMaxWidth = fillMaxWidth,
        outsidePaddingValues = paddingValues
    ) {
        Text(
            modifier = Modifier.padding(vertical = 2.dp),
            text = text
        )
    }
}

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean,
    fillMaxWidth: Boolean,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    isLoading: Boolean,
    outsidePaddingValues: PaddingValues = PaddingValues(horizontal = 20.dp),
    contentPadding: PaddingValues = PaddingValues(20.dp, 16.dp),
    style: ButtonStyle,
    content: @Composable RowScope.() -> Unit
) {
    val background = when (style) {
        ButtonStyle.PRIMARY -> AlmagestTheme.colors.callToActionDefault
        ButtonStyle.SECONDARY -> AlmagestTheme.colors.transparent
        ButtonStyle.ERROR -> AlmagestTheme.colors.backgroundWarning
    }
    val disabledBackground = when (style) {
        ButtonStyle.PRIMARY -> AlmagestTheme.colors.backgroundDisabled
        ButtonStyle.SECONDARY -> AlmagestTheme.colors.transparent
        ButtonStyle.ERROR -> AlmagestTheme.colors.transparent
    }
    val border = when (style) {
        ButtonStyle.SECONDARY -> {
            BorderStroke(
                width = 1.dp,
                color = if (isLoading || !enabled) {
                    AlmagestTheme.colors.bordersDefault
                } else {
                    AlmagestTheme.colors.bordersActive
                }
            )
        }

        ButtonStyle.ERROR -> {
            BorderStroke(
                width = 1.dp,
                color = if (isLoading || !enabled) {
                    AlmagestTheme.colors.bordersDefault
                } else {
                    AlmagestTheme.colors.systemWarning
                }
            )
        }

        else -> null
    }
    val contentColor = getContentColor(style, enabled)

    BaseButtonContent(
        modifier = modifier,
        isLoading = isLoading,
        enabled = enabled,
        disabledBackground = disabledBackground,
        background = background,
        contentColor = contentColor,
        indication = contentColor,
        fillMaxWidth = fillMaxWidth,
        border = border,
        interactionSource = interactionSource,
        contentPadding = contentPadding,
        outsidePaddingValues = outsidePaddingValues,
        onClick = onClick,
        content = content
    )
}

@Composable
private fun getContentColor(style: ButtonStyle, enabled: Boolean): Color {
    return when {
        enabled && style == ButtonStyle.PRIMARY -> AlmagestTheme.colors.staticBackground
        enabled && style == ButtonStyle.SECONDARY -> AlmagestTheme.colors.contentPrimary
        enabled && style == ButtonStyle.ERROR -> AlmagestTheme.colors.systemWarning
        else -> AlmagestTheme.colors.contentDisabled
    }
}

@Composable
internal fun BaseButtonContent(
    modifier: Modifier = Modifier,
    isLoading: Boolean = true,
    enabled: Boolean = true,
    fillMaxWidth: Boolean = true,
    minHeight: Dp = 52.dp,
    disabledBackground: Color = AlmagestTheme.colors.transparent,
    background: Color = AlmagestTheme.colors.transparent,
    contentColor: Color,
    contentPadding: PaddingValues = PaddingValues(20.dp, 16.dp),
    shape: Shape = RoundedCornerShape(12.dp),
    indication: Color? = null,
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    outsidePaddingValues: PaddingValues = PaddingValues(horizontal = 20.dp),
    onClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        shape = shape,
        color = Color.Transparent,
        contentColor = colorAnimation(
            targetColor = contentColor,
            durationMillis = 300
        ),
        border = border,
        modifier = modifier
            .padding(outsidePaddingValues)
            .defaultMinSize(minHeight = minHeight)
            .clip(shape)
            .background(
                color = colorAnimation(
                    targetColor = if (isLoading || !enabled) disabledBackground else background,
                    durationMillis = 300
                )
            )
            .debounceClickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = if (indication != null) rememberRipple(color = indication) else null
            )
    ) {
        if (isLoading) {
            Row(
                Modifier
                    .applyIf(fillMaxWidth) {
                        fillMaxWidth()
                    }
                    .padding(contentPadding),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(18.dp),
                    color = AlmagestTheme.colors.contentPrimary,
                    strokeWidth = 2.dp
                )
            }
        } else {
            ProvideTextStyle(
                value = AlmagestTheme.typography.bodySMed
            ) {
                Row(
                    Modifier
                        .applyIf(fillMaxWidth) {
                            fillMaxWidth()
                        }
                        .padding(contentPadding)
                        .heightIn(min = 24.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }
}