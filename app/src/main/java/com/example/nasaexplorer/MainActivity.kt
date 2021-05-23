package com.example.nasaexplorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.nasaexplorer.ui.MainDrawer


import com.example.nasaexplorer.ui.screens.ScreensController

import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector

import com.example.nasaexplorer.ui.util.theme.NasaExplorerTheme

import kotlinx.coroutines.launch
import timber.log.Timber

import javax.inject.Inject

class MainActivity : ComponentActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    @Inject
    lateinit var screensController: ScreensController

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            NasaExplorerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScaffold()
                }
            }
        }
    }

    @Composable
    private fun MainScaffold() {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val navController = rememberNavController()
        val coroutineScope = rememberCoroutineScope()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        val title =
                            if (currentRoute != null) screensController.screensMap[currentRoute]?.title
                            else screensController.screensMap[screensController.initialRoute]?.title

                        Text("$title")

                    },
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu icon",
                            modifier = Modifier
                                .clickable(onClick = {
                                    coroutineScope.launch {
                                        scaffoldState.drawerState.open()
                                    }
                                })
                                .size(30.dp)
                        )
                    })
            },
            drawerContent = {
                MainDrawer(
                    navController = navController,
                    scaffoldState = scaffoldState,
                    screensAvailable = screensController.screensAvailable
                )
            },
            scaffoldState = scaffoldState,
        ) {

            NavHost(
                navController = navController,
                startDestination = screensController.initialRoute,
            ) {
                screensController.screensAvailable.forEach {
                    composable(
                        it.route,
                        content = it.content
                    )
                }
            }
        }
    }
}