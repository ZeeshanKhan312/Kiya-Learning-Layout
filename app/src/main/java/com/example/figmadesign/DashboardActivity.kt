package com.example.figmadesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.figmadesign.fragments.AttendanceFragment
import com.example.figmadesign.fragments.ClassesFragment
import com.example.figmadesign.fragments.HomeFragment
import com.example.figmadesign.fragments.LibraryFragment
import com.example.figmadesign.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    lateinit var bottomNavigationBar: com.google.android.material.bottomnavigation.BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigationBar = findViewById(R.id.navigation_bar)

        supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, HomeFragment()).commit()

        bottomNavigationBar.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeTab -> {
                    // Replace the fragment or launch the activity for Home
                     supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, HomeFragment()).commit()
                    true
                }
                R.id.attendanceTab -> {
                    // Replace the fragment or launch the activity for Dashboard
                     supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, AttendanceFragment()).commit()
                    true
                }
                R.id.classesTab -> {
                    // Replace the fragment or launch the activity for Notifications
                     supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, ClassesFragment()).commit()
                    true
                }
                R.id.libraryTab -> {
                    // Replace the fragment or launch the activity for Notifications
                     supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, LibraryFragment()).commit()
                    true
                }
                R.id.profileTab -> {
                    // Replace the fragment or launch the activity for Notifications
                      supportFragmentManager.beginTransaction().replace(R.id.dashboard_fragment, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }


    }

}