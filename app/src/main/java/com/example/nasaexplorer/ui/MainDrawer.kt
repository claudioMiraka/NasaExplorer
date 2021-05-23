package com.example.nasaexplorer.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import com.example.nasaexplorer.R
import com.example.nasaexplorer.ui.screens.ScreensController
import kotlinx.coroutines.launch


@Composable
fun MainDrawer(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    screensAvailable: List<ScreensController.AppScreens>
) {
    val coroutineScope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

    Text(
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(16.dp)
    )
    screensAvailable.forEach { screen ->
        DrawerRow(
            title = screen.title,
            selected = currentRoute == screen.route,
            onClick = {
                navController.popBackStack(navController.graph.startDestination, false)
                if (currentRoute != screen.route) {
                    navController.navigate(screen.route)
                }
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            })
    }
}

@Composable
private fun DrawerRow(title: String, selected: Boolean, onClick: () -> Unit) {

    val background =
        if (selected) MaterialTheme.colors.primary.copy(alpha = 0.12f)
        else Color.Transparent

    val textColor =
        if (selected) MaterialTheme.colors.primary
        else MaterialTheme.colors.onSurface

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .background(background)
            .padding(horizontal =  10.dp,vertical = 15.dp)
    ) {
        Text(color = textColor, text = title)
    }
}

@Preview("Drawer Row")
@Composable
private fun DrawerRowPreview() {
    DrawerRow("Daily Picture", false, onClick = {})
}