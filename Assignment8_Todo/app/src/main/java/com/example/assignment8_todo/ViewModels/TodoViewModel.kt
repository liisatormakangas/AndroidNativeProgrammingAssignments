package com.example.assignment8_todo.ViewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assignment8_todo.model.Todo
import com.example.assignment8_todo.model.TodosApi
import kotlinx.coroutines.launch

sealed interface TodoUiState {
    data class Success(val todos: List<Todo>): TodoUiState
    object Error: TodoUiState
    object Loading: TodoUiState
}

class TodoViewModel: ViewModel() {
    //val todos = mutableStateListOf<Todo>()
    var todoUiState: TodoUiState by mutableStateOf<TodoUiState>(TodoUiState.Loading)

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                //todos.clear()
                //todos.addAll(todosApi.getTodos())
                todoUiState = TodoUiState.Success(todosApi.getTodos())
            } catch (e: Exception) {
                Log.d("TodoViewModel", "Error: ${e.message.toString()}")
                Log.d("TodoViewModel", "todoUiState: $todoUiState")
                todoUiState = TodoUiState.Error
            }
        }
    }
}