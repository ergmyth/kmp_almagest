package app.presentation.draft

import Graphs.DRAFT_GRAPH
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import app.presentation.draft.drafting.DraftingScreen
import app.presentation.draft.drafting.DraftingView

@Composable
fun DraftGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        graph = navController.createGraph(startDestination = DraftScreen.ROUTE, route = DRAFT_GRAPH) {
            composable(DraftScreen.ROUTE) {
                DraftView(navController)
            }
            composable(DraftingScreen.ROUTE) {
                DraftingView(navController)
            }
        }
    )
}