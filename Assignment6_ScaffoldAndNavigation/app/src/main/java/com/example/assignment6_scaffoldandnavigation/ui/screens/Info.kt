package com.example.assignment6_scaffoldandnavigation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.assignment6_scaffoldandnavigation.BottomBar
import com.example.assignment6_scaffoldandnavigation.ScreenTopBar

@Composable
fun InfoScreen (navController: NavController) {
    Scaffold(
        topBar = { ScreenTopBar("Info", navController) },
        content = { paddingValues ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize(),
                content = {
                    Text(
                        text = "Content for info screen",
                        style = TextStyle(
                            fontSize = 24.sp,
                            color = MaterialTheme.colorScheme.primary),
                    )
                }
            )
        },
        bottomBar = { BottomBar(navController) },
    )
}