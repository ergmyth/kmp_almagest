package app.presentation.live

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import core.navigation.observeEvents
import org.koin.compose.koinInject

@Composable
fun LiveView(
    navController: NavHostController,
    viewModel: LiveViewModel = koinInject()
) {
    observeEvents(navController, viewModel)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Live")
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.obtainIntent(LiveIntent.Open) }
        ) {
            Text("GoNext")
        }
    }
}