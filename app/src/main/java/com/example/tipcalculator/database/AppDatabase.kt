package com.example.tipcalculator.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tipcalculator.model.Todo
import com.example.tipcalculator.model.TodoDao

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase (){
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, AppDatabase::class.java, "tip_calculator_database")
                    .createFromAsset("database/tip_calculator_database.db")
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}