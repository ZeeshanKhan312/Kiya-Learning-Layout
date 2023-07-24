package com.example.figmadesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R


class CalendarAdapter(private val dayOfMonth:ArrayList<String>, val onItemListener: OnItemListener): RecyclerView.Adapter<CalendarAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View, onItemListener: CalendarAdapter.OnItemListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val cellDate: TextView
        private val onItemListener: CalendarAdapter.OnItemListener

        init {
            cellDate = itemView.findViewById<TextView>(R.id.cell_date)
            this.onItemListener = onItemListener
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            onItemListener.onItemClick(adapterPosition, cellDate.text as String)
        }
    }

//    class MyViewHolder(itemView:View,onItemListener: CalendarAdapter.OnItemListener): RecyclerView.ViewHolder(itemView), View.OnClickListener {
//
//        val cellDate=itemView.findViewById<TextView>(R.id.cell_date)
//
//        override fun onClick(view: View?) {
//            onItem
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.date_layout,parent,false)
        return MyViewHolder(view,onItemListener)
    }

    override fun getItemCount(): Int {
        return dayOfMonth.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cellDate.text=dayOfMonth.get(position)
    }

    interface OnItemListener {
        fun onItemClick(position: Int, dayText: String?)
    }
}