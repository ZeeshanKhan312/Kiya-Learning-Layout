package com.example.figmadesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.example.figmadesign.adapters.StarterPageAdapter

class StarterActivity : AppCompatActivity() {
    lateinit var viewPager:ViewPager2
    lateinit var point1:View
    lateinit var point2:View
    lateinit var point3:View
    lateinit var next:AppCompatButton
    lateinit var skip:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

        //remove title bar form up
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        viewPager=findViewById(R.id.fragment_container)
        point1=findViewById(R.id.point1)
        point2=findViewById(R.id.point2)
        point3=findViewById(R.id.point3)
        next=findViewById(R.id.next_btn)
        skip=findViewById(R.id.skip_btn)

        val images= listOf(R.drawable.start_img1,R.drawable.swipe_02,R.drawable.swipe_03)
        val titles= listOf(R.drawable.leads,R.drawable.follow_ups,R.drawable.performance)
        val texts= listOf(applicationContext.resources.getString(R.string.manage_your),applicationContext.resources.getString(R.string.prioritise),applicationContext.resources.getString(R.string.performance))

        val adapter=StarterPageAdapter(images,titles, texts)
        viewPager.adapter=adapter

        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun equals(other: Any?): Boolean {
                return super.equals(other)
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                changeColor()
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
                changeColor()
                super.onPageScrollStateChanged(state)
            }
        })

        next.setOnClickListener{
            startActivity(Intent(this@StarterActivity,LogInActivity::class.java))
        }

        skip.setOnClickListener{
            startActivity(Intent(this@StarterActivity, LogInActivity::class.java))
        }


    }

    fun changeColor(){
        when(viewPager.currentItem){
            0->{
                point1.background=applicationContext.resources.getDrawable(R.drawable.ellipse_85)
                point2.background=applicationContext.resources.getDrawable(R.drawable.ellipse_83)
                point3.background=applicationContext.resources.getDrawable(R.drawable.ellipse_83)
            }
            1->{
                point1.background=applicationContext.resources.getDrawable(R.drawable.ellipse_83)
                point2.background=applicationContext.resources.getDrawable(R.drawable.ellipse_85)
                point3.background=applicationContext.resources.getDrawable(R.drawable.ellipse_83)
                next.text="Next"
            }
            2->{
                point1.background=applicationContext.resources.getDrawable(R.drawable.ellipse_83)
                point2.background=applicationContext.resources.getDrawable(R.drawable.ellipse_83)
                point3.background=applicationContext.resources.getDrawable(R.drawable.ellipse_85)
                next.text="Login"
            }
        }
    }
}