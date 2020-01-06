package com.example.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room.dao.BookDao
import com.example.room.entity.BookEntity

@Database(entities = [(BookEntity::class)],version = 1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun bookDao():BookDao
}