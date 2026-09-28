package com.damate.taskflow.data.local.db

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.damate.taskflow.domain.model.Priority
import java.time.LocalDate

class Converters {

    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }

    @TypeConverter
    fun toPriority(value: String): Priority {
        return Priority.valueOf(value)
    }

    @TypeConverter
    fun fromLocalDate(date: LocalDate): String {
        return date.toString()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toLocalDate(value: String): LocalDate {
        return LocalDate.parse(value)
    }
}