package com.example.figmadesign.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.example.figmadesign.R


class HomeFragment : Fragment() {
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        val classes_offered_box=view.findViewById<RelativeLayout>(R.id.classes_offered_box)
        val classes_taken_box=view.findViewById<RelativeLayout>(R.id.classes_taken_box)
        val cancel_classes_box=view.findViewById<RelativeLayout>(R.id.cancel_classes_box)
        val earning_box=view.findViewById<RelativeLayout>(R.id.earning_box)
        val paid_box=view.findViewById<RelativeLayout>(R.id.paid_box)
        val due_box=view.findViewById<RelativeLayout>(R.id.due_box)
        val profile_box=view.findViewById<RelativeLayout>(R.id.profile_box)
        val attendance_box=view.findViewById<RelativeLayout>(R.id.attendance_box)
        val library_box=view.findViewById<RelativeLayout>(R.id.library_box)


        classes_offered_box.setOnClickListener{
            requireFragmentManager().beginTransaction().replace(R.id.dashboard_fragment, ClassesFragment()).commit()
        }

        profile_box.setOnClickListener{
            requireFragmentManager().beginTransaction().replace(R.id.dashboard_fragment,ProfileFragment()).commit()
        }
        attendance_box.setOnClickListener{
            requireFragmentManager().beginTransaction().replace(R.id.dashboard_fragment,AttendanceFragment()).commit()
        }
        library_box.setOnClickListener{
            requireFragmentManager().beginTransaction().replace(R.id.dashboard_fragment,LibraryFragment()).commit()
        }

        return view
    }


}