package com.damate.taskflow.ui.screens.home

import com.damate.taskflow.domain.model.Task

data class HomeState(
    val tasks: List<Task> = emptyList()
)