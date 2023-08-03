package com.example.figmadesign.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R
import com.example.figmadesign.adapters.LibraryAdapter

class LibraryFragment : Fragment() {

    lateinit var course:TextView
    lateinit var books:TextView
    lateinit var recyclerView: RecyclerView
    val list=ArrayList<String>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_library, container, false)

        course=view.findViewById(R.id.course)
        books=view.findViewById(R.id.books)
        recyclerView=view.findViewById(R.id.libraryRV)

        var selected="course"
        courses()
        val libraryAdapter=LibraryAdapter(list,context)
        recyclerView.layoutManager=LinearLayoutManager(this.context)
        recyclerView.adapter=libraryAdapter

        course.setOnClickListener {
            if(selected!="course"){
                course.setTextColor(Color.parseColor("#ffffff"))
                books.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                course.setBackgroundResource(R.color.app_theme)
                books.setBackgroundResource(R.color.white)
                selected="course"

                list.clear()
                courses()
                libraryAdapter.notifyDataSetChanged()
            }
        }

        books.setOnClickListener {
            if(selected!="books"){
                books.setTextColor(Color.parseColor("#ffffff"))
                course.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                books.setBackgroundResource(R.color.app_theme)
                course.setBackgroundResource(R.color.white)
                selected="books"

                list.clear()
                books()
                libraryAdapter.notifyDataSetChanged()
            }
        }

        return view
    }
    fun courses() {
        list.add("Java Dev")
        list.add("Python Dev")
        list.add("Frontend Dev")
        list.add("Full Stack Dev")
        list.add("Art of Acting")
        list.add("Mass Communication")
    }

    fun books(){
        list.add("Programming in C")
        list.add("Introduction to Modern C++")
        list.add("Core Java")
        list.add("Guide to Spring")
    }
}