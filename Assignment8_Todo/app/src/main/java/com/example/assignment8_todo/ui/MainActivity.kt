package com.example.assignment8_todo.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.assignment8_todo.ViewModels.TodoViewModel
import com.example.assignment8_todo.ui.screens.TodoScreen
import com.example.assignment8_todo.ui.theme.Assignment8_TodoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment8_TodoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoApp()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoApp(todoViewModel: TodoViewModel = viewModel()) {
    //TodoList(todoViewModel.todos)
    TodoScreen(uiState = todoViewModel.todoUiState)
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Todo List") }
        )
        },
        content = {
            TodoScreen(uiState = todoViewModel.todoUiState)
            Log.d("TodoApp", "TodoApp: ${todoViewModel.todoUiState}")
        }
    )
}





