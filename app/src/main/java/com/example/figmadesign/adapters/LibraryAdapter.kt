package com.example.figmadesign.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R

class LibraryAdapter(val list:ArrayList<String>,val context:Context?): RecyclerView.Adapter<LibraryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val file_name=itemView.findViewById<TextView>(R.id.file_name)
        val country=itemView.findViewById<TextView>(R.id.country)
        val curriculum=itemView.findViewById<TextView>(R.id.curriculum)
        val grade=itemView.findViewById<TextView>(R.id.grade)
        val language=itemView.findViewById<TextView>(R.id.language)
        val viewBtn=itemView.findViewById<TextView>(R.id.viewBtn)
        val downloadBtn=itemView.findViewById<TextView>(R.id.downloadBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.library_card,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.file_name.text=list.get(position)
    }
}