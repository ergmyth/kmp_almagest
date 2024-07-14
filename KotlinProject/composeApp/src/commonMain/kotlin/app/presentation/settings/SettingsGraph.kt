package app.presentation.settings

import Graphs.SETTINGS_GRAPH
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph

@Composable
fun SettingsGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        graph = navController.createGraph(startDestination = SettingsScreen.ROUTE, route = SETTINGS_GRAPH) {
            composable(SettingsScreen.ROUTE) {
                SettingsView(navController)
            }
        }
    )
}