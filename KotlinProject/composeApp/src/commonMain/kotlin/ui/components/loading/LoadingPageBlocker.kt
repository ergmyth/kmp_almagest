package ui.components.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import core.mvvm.LoadingState
import core.mvvm.LoadingType
import ui.tokens.AlmagestTheme


@Composable
fun LoadingPageBlocker(
    loadingState: LoadingState,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        content.invoke()
        if (loadingState is LoadingState.Enabled) {
            when (loadingState.data?.type) {
                LoadingType.Transparent -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(AlmagestTheme.colors.backgroundOverlay.copy(alpha = 0.4f))
                            .gesturesDisabled(true)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center).size(48.dp),
                            color = AlmagestTheme.colors.contentPrimary,
                            strokeWidth = 2.dp
                        )
                    }
                }

                else -> Unit
            }
        }
    }
}

fun Modifier.gesturesDisabled(disabled: Boolean = true) =
    if (disabled) {
        pointerInput(Unit) {
            awaitPointerEventScope {
                while (true) {
                    awaitPointerEvent(pass = PointerEventPass.Initial)
                        .changes
                        .forEach(PointerInputChange::consume)
                }
            }
        }
    } else {
        this
    }