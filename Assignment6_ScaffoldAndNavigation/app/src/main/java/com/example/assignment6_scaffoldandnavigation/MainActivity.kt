package com.example.assignment6_scaffoldandnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.assignment6_scaffoldandnavigation.ui.screens.InfoScreen
import com.example.assignment6_scaffoldandnavigation.ui.screens.MainScreen
import com.example.assignment6_scaffoldandnavigation.ui.screens.SettingsScreen
import com.example.assignment6_scaffoldandnavigation.ui.theme.Assignment6_ScaffoldAndNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment6_ScaffoldAndNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScaffoldApp()
                }
            }
        }
    }
}
@Composable
fun ScaffoldApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "Home"
    ) {
        composable(route = "Home") {
            MainScreen(navController)
        }
        composable(route = "Info") {
            InfoScreen(navController)
        }
        composable(route = "Settings") {
            SettingsScreen(navController)
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(title: String, navController: NavController) {
    var moreExpanded by remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(title) },

        actions = {
            IconButton(
                onClick = {
                    moreExpanded = !moreExpanded
                }
            ) {
                Icon(Icons.Filled.MoreVert, contentDescription = null)
            }
            DropdownMenu(
                expanded = moreExpanded,
                onDismissRequest = { moreExpanded = false }) {
                    DropdownMenuItem(
                        onClick = {
                            navController.navigate("info")
                        },
                        text = { Text("Info") }
                    )
                    DropdownMenuItem(
                        onClick = {
                            navController.navigate("settings")
                        },
                        text = { Text("Settings") }
                    )
                }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopBar(title: String, navController: NavController) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = { navController.navigateUp() }
            ) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null)
            }
        }
    )
}
@Composable
fun BottomBar (navController: NavController) {
    BottomAppBar(
        modifier = Modifier.height(45.dp),
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround

            ) {
                IconButton(
                    onClick = { navController.navigate("Home") }
                ) {
                    Icon(Icons.Outlined.Home, contentDescription = null)
                }
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(Icons.Outlined.Email, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Phone, contentDescription = null)
                }
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(Icons.Filled.List, contentDescription = null)
                }

            }
        }
    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment6_ScaffoldAndNavigationTheme {
        ScaffoldApp()
    }
}