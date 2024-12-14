package com.example.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    private val _tasks = MutableLiveData<MutableList<Task>>(mutableListOf())
    val tasks: LiveData<MutableList<Task>> = _tasks

    fun addTask(task: Task) {
        _tasks.value?.add(task)
        _tasks.value = _tasks.value // Trigger LiveData observers
    }

    fun filterTasksByCategory(category: String): List<Task> {
        return if (category == "All") _tasks.value.orEmpty()
        else _tasks.value.orEmpty().filter { it.category == category }
    }
}
