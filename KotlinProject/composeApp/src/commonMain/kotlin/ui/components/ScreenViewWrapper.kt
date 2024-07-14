package ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import app.presentation.settings.SettingsView
import ui.components.bottom_navigation.BottomNavigationView

@Composable
fun ScreenViewWrapper(
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        scaffoldState = rememberScaffoldState(),
        bottomBar = { BottomNavigationView(navController) },
        content = content
    )
}