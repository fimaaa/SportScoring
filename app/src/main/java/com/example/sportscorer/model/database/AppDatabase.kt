package com.example.sportscorer.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sportscorer.model.Post
import com.example.sportscorer.model.PostDao

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}
