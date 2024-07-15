package ui.components.modifier

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role
import kotlinx.coroutines.delay

@Composable
fun Modifier.applyIf(predicate: Boolean, run: @Composable Modifier.() -> Modifier): Modifier {
    if (predicate) {
        return run.invoke(this)
    }
    return this
}

inline fun Modifier.noRippleClickable(
    debounceInterval: Long = 500L,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    crossinline onClick: () -> Unit
): Modifier = composed {
    debounceClickable(
        debounceInterval = debounceInterval,
        enabled = enabled,
        indication = null,
        onClickLabel = onClickLabel,
        role = role,
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    )
}

inline fun Modifier.debounceClickable(
    debounceInterval: Long = 500L,
    interactionSource: MutableInteractionSource,
    indication: Indication?,
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    crossinline onClick: () -> Unit
): Modifier = composed {
    val hasClicked = remember { mutableStateOf(false) }
    clickable(
        interactionSource = interactionSource,
        indication = indication,
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role
    ) {
        //todo klock
//        if (hasClicked.value) return@clickable
//        hasClicked.value = true
//        LaunchedEffect(Unit) {
//            delay(debounceInterval)
//            hasClicked.value = false
//            onClick()
//        }
    }
}