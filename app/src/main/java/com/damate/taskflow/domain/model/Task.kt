package com.damate.taskflow.domain.model

import java.time.LocalDate

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val priority: Priority = Priority.MEDIUM,
    val createdAt: LocalDate
)