package com.example.todo

data class Task(
    val title: String,
    val deadline: String?,
    val category: String,
    var isCompleted: Boolean = false
)
