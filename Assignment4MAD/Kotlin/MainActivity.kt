package com.example.assignment5


import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adStd: Button =findViewById(R.id.button)
        var viewAll:Button=findViewById(R.id.button3)
        var dele:Button=findViewById(R.id.button2)
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.INTERNET),101)






        adStd.setOnClickListener()
        {
            //   var in= Intent(this,AddStudent::class.java)
            startActivity(Intent(this,AddStudent::class.java))
        }

        viewAll.setOnClickListener()
        {
            //   var in= Intent(this,AddStudent::class.java)
            startActivity(Intent(this,ViewStd::class.java))
        }
        dele.setOnClickListener()
        {
            //   var in= Intent(this,AddStudent::class.java)
            startActivity(Intent(this,DeleteData::class.java))
        }





    }
}