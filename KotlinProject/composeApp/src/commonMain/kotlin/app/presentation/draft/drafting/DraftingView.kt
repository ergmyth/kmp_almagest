package app.presentation.draft.drafting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import core.mvvm.LoadingState
import core.mvvm.LoadingType
import core.navigation.observeEvents
import org.koin.compose.koinInject
import ui.components.loading.LoadingPageBlocker
import ui.tokens.AlmagestTheme

@Composable
fun DraftingView(
    navController: NavController,
    viewModel: DraftingViewModel = koinInject()
) {
    observeEvents(navController, viewModel)
    LoadingPageBlocker(viewModel.loadingState.collectAsState().value) {
        when (val state = viewModel.viewState.collectAsState().value) {
            is DraftingViewState.DefaultState -> {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Drafting ${state.someInt}")
                }
            }
        }
    }
}
