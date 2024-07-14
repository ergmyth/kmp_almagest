package app.presentation.live

import Graphs.LIVE_GRAPH
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import app.presentation.draft.DraftView
import app.presentation.draft.drafting.DraftingScreen
import app.presentation.draft.drafting.DraftingView
import org.koin.core.qualifier.qualifier

@Composable
fun LiveGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        graph = navController.createGraph(startDestination = LiveScreen.ROUTE, route = LIVE_GRAPH) {
            composable(LiveScreen.ROUTE) {
                LiveView(navController)
            }
        }
    )
}