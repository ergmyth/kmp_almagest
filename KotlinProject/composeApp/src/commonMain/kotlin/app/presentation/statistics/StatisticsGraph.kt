package app.presentation.statistics

import Graphs.SETTINGS_GRAPH
import Graphs.STATISTICS_GRAPH
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph

@Composable
fun StatisticsGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        graph = navController.createGraph(startDestination = StatisticsScreen.ROUTE, route = STATISTICS_GRAPH) {
            composable(StatisticsScreen.ROUTE) {
                StatisticsView(navController)
            }
        }
    )
}