package app.presentation.draft.drafting

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import app.presentation.draft.DraftViewModel
import core.navigation.observeEvents
import org.koin.compose.koinInject
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.qualifier
import ui.components.loading.LoadingPageBlocker

@Composable
fun DraftingView(
    navController: NavController,
    viewModel: DraftingViewModel = koinInject<DraftingViewModel>()
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
