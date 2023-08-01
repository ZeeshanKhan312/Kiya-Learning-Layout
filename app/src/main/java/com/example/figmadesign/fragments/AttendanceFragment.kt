package com.example.figmadesign.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R
import com.example.figmadesign.adapters.CalendarAdapter
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


class AttendanceFragment : Fragment() {
    lateinit var selectedDate:LocalDate
    lateinit var monthYearText:TextView
    lateinit var calendarRecyclerView:RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_attendance, container, false)

//        calendarRecyclerView = view.findViewById(R.id.calendar);
//        monthYearText = view.findViewById(R.id.month_year);
//        val prvsMonth=view.findViewById<TextView>(R.id.prvs_month)
//        val nextMonth=view.findViewById<TextView>(R.id.nextMonth)
//
//        selectedDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            LocalDate.now()
//        } else {
//            TODO("VERSION.SDK_INT < O")
//        }
//
//        setMonthView()

//        prvsMonth.setOnClickListener{
//            previousMonth(view)
//        }
//        nextMonth.setOnClickListener{
//            nextMonth(view)
//        }

        return view
    }

}