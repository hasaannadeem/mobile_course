package com.example.phone

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity2 : AppCompatActivity() {
    var locationObj:LocationManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val current: Button = findViewById(R.id.button2)
        val favourite: Button = findViewById(R.id.button3)
        val history: Button = findViewById(R.id.button4)
        val et2:TextView=findViewById(R.id.textView2)
        var sharedPref=getSharedPreferences("prefName", Context.MODE_PRIVATE)
        var sharedPref1=getSharedPreferences("HisoryPreference", Context.MODE_PRIVATE)
        var NumPref=getSharedPreferences("pref", Context.MODE_PRIVATE)
        current.setOnClickListener {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS,Manifest.permission.ACCESS_COARSE_LOCATION
                ,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET),
        1122)
     /*   val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.textView2).apply {
            text = message


       Toast.makeText(this, "$message \nNumber is copied", Toast.LENGTH_LONG).show()*/
        locationObj=getSystemService(Context.LOCATION_SERVICE)as LocationManager?
        var locListObj=LocationClass(this,et2,sharedPref,sharedPref1,NumPref)

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return@setOnClickListener
        }
        locationObj?.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,0f,locListObj)




        //    Toast.makeText(this, " \nCurrent button is presses", Toast.LENGTH_LONG).show()
        }
        favourite.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        history.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}