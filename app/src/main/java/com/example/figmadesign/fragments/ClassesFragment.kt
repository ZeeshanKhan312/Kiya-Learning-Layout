package com.example.figmadesign.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.figmadesign.R
import com.example.figmadesign.adapters.ClassAdapter

 class ClassesFragment : Fragment() {
     companion object {
          var classSection: String = "newClass"
     }

    lateinit var newClass:TextView
    lateinit var cancelledClass:TextView
    lateinit var completedClass:TextView
    lateinit var adapter:ClassAdapter
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_classes, container, false)
        var itemSelected:String="newClass"
        recyclerView=view.findViewById(R.id.fragment_container)
        newClass=view.findViewById(R.id.new_classes)
        cancelledClass=view.findViewById(R.id.cancelled_classes)
        completedClass=view.findViewById(R.id.completed_classes)
        val list:ArrayList<String> =ArrayList()
        list.add("Zeeshan")
        list.add("Aaquib")
        list.add("Shaleel")
        list.add("Ali")
        adapter=ClassAdapter(list,context)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter

        newClass.setOnClickListener {
            if(itemSelected != "newClass"){
                completedClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                newClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                cancelledClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))

                completedClass.setBackgroundResource(R.color.white)
                newClass.setBackgroundResource(R.color.app_theme)
                cancelledClass.setBackgroundResource(R.color.white)
                list.clear()
                list.add("Zeeshan")
                list.add("Aaquib")
                list.add("Shaleel")
                list.add("Ali")
                classSection="newClass"
                adapter.notifyDataSetChanged()
                itemSelected="newClass"
            }
        }

        completedClass.setOnClickListener {1
            if(itemSelected!="completedClass") {
                completedClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
                newClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                cancelledClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))

                completedClass.setBackgroundResource(R.color.app_theme)
                newClass.setBackgroundResource(R.color.white)
                cancelledClass.setBackgroundResource(R.color.white)
                list.clear()
                list.add("Zeeshan")
                list.add("Shaleel")
                list.add("Ali")
                classSection="completedClass"
                adapter.notifyDataSetChanged()
                itemSelected = "completedClass"
            }
        }

        cancelledClass.setOnClickListener {
            if(itemSelected!="cancelledClass"){
                completedClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                newClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.black))
                cancelledClass.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

                completedClass.setBackgroundResource(R.color.white)
                newClass.setBackgroundResource(R.color.white)
                cancelledClass.setBackgroundResource(R.color.app_theme)
                list.clear()
                list.add("Aaquib")
                classSection="cancelledClass"
                adapter.notifyDataSetChanged()
                itemSelected="cancelledClass"
            }
        }
        return view
    }

}