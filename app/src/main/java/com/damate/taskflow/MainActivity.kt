package com.damate.taskflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.damate.taskflow.ui.theme.TaskFlowTheme
import androidx.lifecycle.ViewModelProvider
//Room
import androidx.room.Room
import com.damate.taskflow.data.local.db.TaskDatabase
import com.damate.taskflow.data.repository.TaskRepositoryImpl
import com.damate.taskflow.ui.screens.home.HomeScreen
import com.damate.taskflow.ui.screens.home.HomeViewModel
import com.damate.taskflow.ui.screens.home.HomeViewModelFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            "taskflow.db"
        ).build()

        val repository = TaskRepositoryImpl(database.taskDao())

        val viewModel = ViewModelProvider(
            this,
            HomeViewModelFactory(repository)
        )[HomeViewModel::class.java]

        setContent {
            TaskFlowTheme {
                HomeScreen(
                    viewModel = viewModel
                )
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "TaskFlow",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskFlowTheme {
        Greeting("TaskFlow")
    }
}