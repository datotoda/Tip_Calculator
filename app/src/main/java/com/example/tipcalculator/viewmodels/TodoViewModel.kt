package com.example.tipcalculator.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tipcalculator.model.Todo
import com.example.tipcalculator.model.TodoDao
import java.lang.IllegalArgumentException

class TodoViewModel (private val todoDao: TodoDao) : ViewModel() {
    fun fullList(): List<Todo> = todoDao.getAll()
    fun getByStatus(status: Boolean): List<Todo> = todoDao.getByCompletedStatus(status)
}

class TodoViewModelFactory(private val todoDao: TodoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return TodoViewModel(todoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}