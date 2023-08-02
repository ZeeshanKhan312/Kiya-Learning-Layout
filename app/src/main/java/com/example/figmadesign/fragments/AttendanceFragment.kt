package com.example.figmadesign.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R
import java.time.LocalDate


class AttendanceFragment : Fragment() {
    lateinit var selectedDate:LocalDate
    lateinit var monthYearText:TextView
    lateinit var calendarRecyclerView:RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_attendance, container, false)



        return view
    }

}