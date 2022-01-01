package com.example.tipcalculator.model

import androidx.room.*
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Todos")
data class Todo(
    @PrimaryKey val id: Int,
    @NotNull @ColumnInfo(name = "title") val title: String,
    @NotNull @ColumnInfo(name = "completed") val completed: Boolean
    )

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todos ORDER BY id ASC")
    fun getAll(): List<Todo>

    @Query("SELECT * FROM Todos WHERE completed = :status ORDER BY id ASC")
    fun getByCompletedStatus(status: Boolean): List<Todo>
}
