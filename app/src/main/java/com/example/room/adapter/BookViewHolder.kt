package com.example.room.adapter

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import kotlinx.android.synthetic.main.activity_main.view.*

class BookViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
    val bookId=itemView.findViewById<TextView>(R.id.text_id)
    val bookName=itemView.findViewById<TextView>(R.id.text_name)
}