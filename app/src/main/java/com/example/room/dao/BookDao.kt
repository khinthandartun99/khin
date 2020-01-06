package com.example.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room.entity.BookEntity

@Dao
interface BookDao {
    @Insert
    fun saveBooks(book:BookEntity)

    @Query(value = "Select * from BookEntity")
    fun getAllBooks():List<BookEntity>
}