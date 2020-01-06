package com.example.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.room.adapter.BookAdapter
import com.example.room.database.AppDatabase
import com.example.room.entity.BookEntity

class BookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_recycler)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)

        var db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "BookDb").build()

        Thread {
            var bookList = ArrayList<BookEntity>()

            var bookEntity = BookEntity()
            bookEntity.bookId = 1
            bookEntity.bookName = "Apple"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 2
            bookEntity.bookName = "banana"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 3
            bookEntity.bookName = "Coconut"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 4
            bookEntity.bookName = "Orange"
            db.bookDao().saveBooks((bookEntity))

            bookEntity.bookId = 5
            bookEntity.bookName = "Strawberry"
            db.bookDao().saveBooks((bookEntity))

            db.bookDao().getAllBooks().forEach() {

                Log.i("Fruit Record", "Id::${it.bookId}")
                Log.i("Fruit Record", "Name::${it.bookName}")

                //txt_fruit.text=it.fruitName
                // var txtName = findViewById<TextView>(R.id.txt_fruit)

            }

            var list=db.bookDao().getAllBooks()
            bookList= list as ArrayList<BookEntity>

            val bookAdapter = BookAdapter(bookList)

            recyclerView.adapter = bookAdapter
        }.start()
    }
}