package com.example.room.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.entity.BookEntity

 class BookAdapter (val bookList: ArrayList<BookEntity>):RecyclerView.Adapter<BookViewHolder>(){
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
         val view= LayoutInflater.from(parent.context).inflate(R.layout.room,parent,false)
         return BookViewHolder(view)
     }

     override fun getItemCount(): Int {
        return bookList.size

     }

     override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
         holder.bookId.text= bookList[position].bookId.toString()
         holder.bookName.text=bookList[position].bookName

     }

 }