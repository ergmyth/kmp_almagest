package core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import core.mvvm.BaseViewModel
import core.mvvm.Screen
import core.mvvm.ViewEvent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun NavController.navigateViaRoute(screen: Screen) {
    navigate(screen.route)
}

@Composable
fun observeEvents(
    navController: NavController,
    viewModel: BaseViewModel,
    otherEvents: ((ViewEvent) -> Unit)? = null
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    LaunchedEffect(Unit) {
        viewModel.viewEvent.flowWithLifecycle(lifecycle).onEach {
            when (it) {
                is ViewEvent.Navigation -> navController.navigateViaRoute(it.screen)
                is ViewEvent.PopBackStack -> navController.popBackStack()
                else -> otherEvents?.invoke(it)
            }
        }.launchIn(this)
    }
}
