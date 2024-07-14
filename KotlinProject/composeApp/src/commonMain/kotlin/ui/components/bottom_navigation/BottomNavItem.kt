package ui.components.bottom_navigation

import Graphs.DRAFT_GRAPH
import Graphs.LIVE_GRAPH
import Graphs.SETTINGS_GRAPH
import Graphs.STATISTICS_GRAPH
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import ui.tokens.AlmagestTheme

enum class BottomNavItem(val route: String, val icon: @Composable () -> Painter, val label: String) {
    Draft(DRAFT_GRAPH, { AlmagestTheme.icons.draft }, "Draft"),
    Live(LIVE_GRAPH, { AlmagestTheme.icons.live}, "Live"),
    Statistics(STATISTICS_GRAPH, { AlmagestTheme.icons.live}, "Statistics"),
    Settings(SETTINGS_GRAPH,{ AlmagestTheme.icons.settings}, "Settings");
}