package app.presentation.draft

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import core.navigation.observeEvents

@Composable
fun DraftView(
    navController: NavController,
    viewModel: DraftViewModel = DraftViewModel()
) {
    observeEvents(navController, viewModel)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Draft")
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.obtainIntent(DraftIntent.OpenDrafting) }
        ) {
            Text("GoNext")
        }
    }
}