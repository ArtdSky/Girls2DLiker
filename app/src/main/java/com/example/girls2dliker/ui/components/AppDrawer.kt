package com.example.girls2dliker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.girls2dliker.routing.AppDistination
import com.example.girls2dliker.routing.Check
import com.example.girls2dliker.routing.Favorites
import com.example.girls2dliker.routing.navigateSingleTopTo

@Composable
fun AppDrawer(
    currentScreen: AppDistination,
    navController: NavHostController,
    closeDrawerAction: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        Surface(
            modifier = Modifier.weight(1f)
        ) {
            ScreenNavigationButton(
                icon = Icons.Filled.Home,
                isSelected = currentScreen == Check,
                onClick = {
                    navController.navigateSingleTopTo(Check.route)
                    closeDrawerAction()
                }
            )
        }
        Surface(
            modifier = Modifier.weight(1f)
        ) {
            ScreenNavigationButton(
                icon = Icons.Filled.Favorite,
                isSelected = currentScreen == Favorites,
                onClick = {
                    navController.navigateSingleTopTo(Favorites.route)
                    closeDrawerAction()
                }
            )
        }
    }

}

@Composable
fun ScreenNavigationButton(
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val colors = MaterialTheme.colors
    val textColor = if (isSelected) colors.primary else colors.onSurface.copy(alpha = 0.6f)
    val backgroundColor = if (isSelected) colors.primary.copy(alpha = 0.12f) else colors.surface
    val imageAlpha = if (isSelected) 1f else 0.6f
    Surface( // 1
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp),
        color = backgroundColor,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            imageVector = icon,
            contentDescription = "Screen Navigation Button",
            colorFilter = ColorFilter.tint(textColor),
            alpha = imageAlpha,
            modifier = Modifier
                .clickable(onClick = onClick)
                .fillMaxWidth()
                .padding(4.dp)
        )
    }
}