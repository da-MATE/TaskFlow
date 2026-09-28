package com.damate.taskflow.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.damate.taskflow.domain.model.Priority
import java.time.LocalDate

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val isCompleted: Boolean = false,
    val priority: Priority = Priority.MEDIUM,
    val createdAt: LocalDate
)