package com.example.assignment8_todo.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.assignment8_todo.ViewModels.TodoUiState
import com.example.assignment8_todo.ui.components.TodoList

@Composable
fun TodoScreen(uiState: TodoUiState) {
    Log.d("TodoScreen", "TodoScreen: $uiState")
    when (uiState) {
        is TodoUiState.Loading -> LoadingScreen("Loading...")
        is TodoUiState.Error -> ErrorScreen("Error in retrieving data from the server")
        is TodoUiState.Success -> TodoList(uiState.todos)
    }
}



