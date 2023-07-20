package com.example.figmadesign.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R

class StarterPageAdapter(private val images:List<Int>, private val titles:List<Int>, private val texts: List<String>):RecyclerView.Adapter<StarterPageAdapter.PagerViewHolder>() {

    class PagerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        val images:ImageView=itemView.findViewById(R.id.start_img)
        val swipeTitle:ImageView=itemView.findViewById(R.id.swipe_title)
        val swipeText: TextView =itemView.findViewById(R.id.swipe_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarterPageAdapter.PagerViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.starter_swipe,parent,false )
        return PagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarterPageAdapter.PagerViewHolder, position: Int) {
        holder.images.setImageResource(images[position])
        holder.swipeTitle.setImageResource(titles[position])
        holder.swipeText.setText(texts[position])
    }


    override fun getItemCount(): Int {
        return images.size
    }
}