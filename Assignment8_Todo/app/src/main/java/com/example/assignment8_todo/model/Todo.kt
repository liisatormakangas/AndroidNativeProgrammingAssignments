package com.example.assignment8_todo.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

data class Todo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

interface TodosApi {
    @GET("todos")
    // getTodos return a list of Todo objects
    suspend fun getTodos(): List<Todo>

    companion object {
        // todosService is of type TodosApi; it is initially set to null; What is the TodoApi type?
        var todosService: TodosApi? = null
        fun getInstance(): TodosApi {
            if (todosService == null) {
                todosService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }
            return todosService!!
        }
    }
}
