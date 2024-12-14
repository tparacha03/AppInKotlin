package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val tasks = mutableListOf<Task>()

    fun updateTasks(newTasks: List<Task>) {
        tasks.clear()
        tasks.addAll(newTasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.title.text = task.title
        holder.deadline.text = task.deadline ?: "No Deadline"
        holder.category.text = task.category
        holder.checkBoxComplete.isChecked = task.isCompleted

        holder.checkBoxComplete.setOnCheckedChangeListener { _, isChecked ->
            task.isCompleted = isChecked
        }
    }

    override fun getItemCount(): Int = tasks.size

    inner class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.textTaskTitle)
        val deadline: TextView = view.findViewById(R.id.textTaskDeadline)
        val category: TextView = view.findViewById(R.id.textTaskCategory)
        val checkBoxComplete: CheckBox = view.findViewById(R.id.checkBoxComplete)
    }
}
