package app.presentation.draft.drafting

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import app.presentation.live.LiveScreen
import core.mvvm.ViewEvent
import core.mvvm.ViewState
import core.navigation.navigateViaRoute
import core.navigation.observeEvents
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun DraftingView(
    navController: NavController,
    viewModel: DraftingViewModel = DraftingViewModel()
) {
    observeEvents(navController, viewModel)
    val state = viewModel.viewState.collectAsState().value
    when (state) {
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