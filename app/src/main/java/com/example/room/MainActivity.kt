package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.room.Room
import com.example.room.database.AppDatabase
import com.example.room.entity.BookEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editOne = findViewById<EditText>(R.id.edit_one)
        var editTwo = findViewById<EditText>(R.id.edit_two)

        var bookId: Int=0
        var bookName: String=""
        var bookEntity = BookEntity()




        var db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "BookDB").build()

        //insert case
        btn_add.setOnClickListener {
            bookId = editOne.text.toString().toInt()
            bookName = editTwo.text.toString()

            bookEntity.bookId = bookId
            bookEntity.bookName = bookName

            Thread{
                db.bookDao().saveBooks(bookEntity)
            }.start()

        }

        btn_select.setOnClickListener {
            Thread{
                db.bookDao().getAllBooks().forEach() {
                    Log.i("Fetch Records", "Id:${it.bookId}")
                    Log.i("Fetch Records", "Name:${it.bookName}")

                }
            }.start()
        }

            /* Thread{
            var bookEntity=BookEntity()
            bookEntity.bookId=1
            bookEntity.bookName="Kotlin for Android Developer"

            db.bookDao().saveBooks(bookEntity)

            //fetch records
            db.bookDao().getAllBooks().forEach(){
                Log.i("Fetch Records","Id:${it.bookId}")
                Log.i("Fetch Records","Name:${it.bookName}")
            }
        }.start()*/


        }
    }


