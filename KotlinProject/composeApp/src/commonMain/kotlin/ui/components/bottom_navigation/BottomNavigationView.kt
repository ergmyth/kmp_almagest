package ui.components.bottom_navigation

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ui.tokens.AlmagestTheme

@Composable
fun BottomNavigationView(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = AlmagestTheme.colors.backgroundPrimary,
        contentColor = AlmagestTheme.colors.contentPrimary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        BottomNavItem.entries.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { popUpTo(it) }
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp, 24.dp),
                        painter = item.icon.invoke(),
                        contentDescription = null
                    )
                },
                label = { Text(item.label) }
            )
        }
    }
}