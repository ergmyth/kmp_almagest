import Graphs.DRAFT_GRAPH
import Graphs.LIVE_GRAPH
import Graphs.SETTINGS_GRAPH
import Graphs.STATISTICS_GRAPH
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import app.di.getDraftModule
import app.di.getLiveModule
import app.presentation.draft.DraftGraph
import app.presentation.live.LiveGraph
import app.presentation.settings.SettingsGraph
import app.presentation.statistics.StatisticsGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.core.context.startKoin
import ui.components.ScreenViewWrapper
import ui.tokens.AlmagestTheme

object Graphs {
    const val DRAFT_GRAPH = "DRAFT_GRAPH"
    const val STATISTICS_GRAPH = "STATISTICS_GRAPH"
    const val LIVE_GRAPH = "LIVE_GRAPH"
    const val SETTINGS_GRAPH = "SETTINGS_GRAPH"
}

@Composable
@Preview
fun App() {
    startKoin {
        modules(getDraftModule(), getLiveModule())
    }
    AlmagestTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            graph = navController.createGraph(startDestination = DRAFT_GRAPH) {
                composable(DRAFT_GRAPH) {
                    ScreenViewWrapper(navController) {
                        DraftGraph()
                    }
                }
                composable(STATISTICS_GRAPH) {
                    ScreenViewWrapper(navController) {
                        StatisticsGraph()
                    }
                }
                composable(LIVE_GRAPH) {
                    ScreenViewWrapper(navController) {
                        LiveGraph()
                    }
                }
                composable(SETTINGS_GRAPH) {
                    ScreenViewWrapper(navController) {
                        SettingsGraph()
                    }
                }
            }
        )
    }
}







