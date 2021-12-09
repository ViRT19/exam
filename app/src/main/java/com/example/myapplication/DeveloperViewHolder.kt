package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView

class DeveloperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val developerNameTextView: TextView =
        itemView.findViewById(R.id.developer_name_text_view)

    fun Bind(name: String){
        developerNameTextView.text = name

    }

}