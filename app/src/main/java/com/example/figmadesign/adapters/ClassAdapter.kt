package com.example.figmadesign.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R
import com.example.figmadesign.fragments.ClassesFragment.Companion.classSection

class ClassAdapter(val list: ArrayList<String>, val context: Context?):RecyclerView.Adapter<ClassAdapter.PagerViewHolder>() {

    class PagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val student_name:TextView=itemView.findViewById(R.id.student_name)
        val class_date:TextView=itemView.findViewById(R.id.class_date)
        val class_time:TextView=itemView.findViewById(R.id.class_time)
        val class_fees:TextView=itemView.findViewById(R.id.class_fees)
        val request_date:TextView=itemView.findViewById(R.id.request_date)
        val acceptBtn:TextView=itemView.findViewById(R.id.acceptBtn)
        val rejectBtn:TextView=itemView.findViewById(R.id.rejectBtn)
        val class_method:TextView=itemView.findViewById(R.id.class_method)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.class_layout,parent,false)
        return PagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.student_name.text=list.get(position)

        holder.acceptBtn.setOnClickListener {
            Toast.makeText(context, "Accepted!!", Toast.LENGTH_SHORT).show()
        }
        holder.rejectBtn.setOnClickListener {
            Toast.makeText(context, "Rejected!!", Toast.LENGTH_SHORT).show()
        }
        if(classSection!="newClass") {
            holder.acceptBtn.visibility = View.GONE
            holder.rejectBtn.visibility = View.GONE
        }
        else{
            holder.acceptBtn.visibility = View.VISIBLE
            holder.rejectBtn.visibility = View.VISIBLE
        }
    }
}