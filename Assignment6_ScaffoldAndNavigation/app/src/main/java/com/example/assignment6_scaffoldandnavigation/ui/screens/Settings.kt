package com.example.assignment6_scaffoldandnavigation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment6_scaffoldandnavigation.BottomBar
import com.example.assignment6_scaffoldandnavigation.ScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen (navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val choices = listOf("Language", "Theme", "Notifications", "Privacy", "About", "Help", "Log Out")
    Scaffold(
        topBar = { ScreenTopBar("Settings", navController) },
        content = { paddingValues ->
            Column(
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxWidth(),
                content = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            Icons.Filled.Settings,
                            contentDescription = null,
                            modifier = Modifier.padding(16.dp))
                        ClickableText(
                            modifier = Modifier
                                .padding(16.dp),
                            style = TextStyle(
                                fontSize = 24.sp,
                                color = MaterialTheme.colorScheme.primary),
                            text = AnnotatedString("Settings" ),
                            onClick = { offset ->
                                expanded = !expanded
                            }
                        )
                    }

                    if (expanded) {
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false}) {
                                choices.forEach { choice ->
                                    DropdownMenuItem(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(MaterialTheme.colorScheme.surface)
                                            .padding(start = 16.dp, end = 16.dp),
                                        onClick = {
                                            expanded = false
                                        },
                                        text = { Text(choice) }
                                    )
                                }
                        }
                    }

             }
            )
        },
        bottomBar = { BottomBar(navController) },
    )
}