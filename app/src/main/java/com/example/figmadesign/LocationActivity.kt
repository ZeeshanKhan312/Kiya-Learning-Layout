package com.example.figmadesign

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var searhBox:EditText
    lateinit var addressName:TextView
    lateinit var useLocation:AppCompatButton

    lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var map: GoogleMap
    private val PERMISSION_CODE:Int=1
    lateinit var currLocation : Location
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        searhBox=findViewById(R.id.searhBox)
        addressName=findViewById(R.id.address)
        useLocation=findViewById(R.id.useLocation)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment //as keyword to typecast
        mapFragment.getMapAsync(this@LocationActivity)

        fusedLocationProviderClient= LocationServices.getFusedLocationProviderClient(this@LocationActivity)
        getLastLocation()

        searhBox.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // This method is called before the text is changed.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // This method is called when the text is being changed.
            }

            @SuppressLint("SuspiciousIndentation")
            override fun afterTextChanged(s: Editable?) {
                // This method is called after the text has been changed.
                // You can perform actions here based on the updated text in the EditText.
                val string = s.toString()
                // Do something with the updatedText

                map.clear()
                if(string.isNotEmpty()){
                    val geocoder=Geocoder(this@LocationActivity)
                    try{
                        val address=geocoder.getFromLocationName(string,1)
                            if (address!!.isNotEmpty()) {
                                val latitude = address!![0].latitude
                                val longitude = address[0].longitude

                                val latLang= LatLng(latitude,longitude)
                                map.addMarker(MarkerOptions().position(latLang))
                                map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLang,10f))

                                val loc:String=address[0].locality+", "+address[0].subLocality+", "+address[0].adminArea+", "+address[0].countryName
                                addressName.text=loc

                            }

                    }
                    catch (e:IOException){
                        e.printStackTrace()
                    }
                }

            }
        })


        useLocation.setOnClickListener{
            startActivity(Intent(this@LocationActivity, DashboardActivity::class.java))
            finish()
        }

    }

    private fun getLastLocation(){
        //to check whether location access is provided or not
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION),PERMISSION_CODE)
            return
        }

        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) { location->
            if(location!=null){
                map.isMyLocationEnabled = true
                map.uiSettings.isMyLocationButtonEnabled = true //for blue dots current location
                currLocation = location
                var you= LatLng(currLocation.latitude,currLocation.longitude)
                map.addMarker(MarkerOptions().position(you))
                map.animateCamera(CameraUpdateFactory.newLatLngZoom(you,12f))  //for zooming into location

                val geocoder=Geocoder(this@LocationActivity)
                val address=geocoder.getFromLocation(currLocation.latitude,currLocation.longitude,1)
                val loc:String= address!![0].getAddressLine(0)+", "+address[0].locality+", "+address[0].subLocality+", "+address[0].adminArea+", "+address[0].countryName
                addressName.text=loc
            }
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map=googleMap
        map.uiSettings.isZoomControlsEnabled=true

    }

    //to check whether the permission is granted after PERMISSION BOX
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==PERMISSION_CODE){
            if(grantResults.size>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                getLastLocation()
            }
            else
                Toast.makeText(this, "Location Access is required!!", Toast.LENGTH_SHORT).show()
        }
    }

}


