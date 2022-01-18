package com.example.phone

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.collections.ArrayList

class MainActivity4 : AppCompatActivity() {
    //  val prefName:String="mySharedPref"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val myListView: ListView = findViewById(R.id.mylist2)
        val but: Button = findViewById(R.id.button6)
        val e1: EditText = findViewById(R.id.edittext1)
        val e2: EditText = findViewById(R.id.editText2)
        var sharedPref1 = getSharedPreferences("HisoryPreference", Context.MODE_PRIVATE)
        var sharedPref = getSharedPreferences("prefName", Context.MODE_PRIVATE)
        var editor = sharedPref.edit()
        var list = ArrayList<String>()
        var counter = sharedPref1.getInt("count", 0)
        var start: Int = 0

        while (start < counter) {
            var item: String = sharedPref1.getString("Lat" + start, "Unknown").toString()
            item = item + "\t" + sharedPref1.getString("Lon" + start, "Unknown").toString()
            item = item + "\n" + sharedPref1.getString("time" + start, "Unknown").toString()
            item = item + "\n" + sharedPref1.getString("address" + start, "Unknown").toString()
            item = item + ",  " + sharedPref1.getString("city" + start, "Unknown").toString()
            list.add(item)
            start = start + 1
        }

        if (list.size < 1)
            list.add("Nothing in the History")

        var myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        myListView.adapter = myAdapter

        but.setOnClickListener {

            var lat = e1.text.toString()
            var lon = e2.text.toString()
            val geocoder: Geocoder
            val addresses: List<Address>
            geocoder = Geocoder(this, Locale.getDefault())

            addresses = geocoder.getFromLocation(
                    lat.toDouble(), lon.toDouble(), 1)

            if (addresses != null && addresses.size > 0) {
                val address: String = addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

                val city: String = addresses[0].getLocality()
                val state: String = addresses[0].getAdminArea()
                val country: String = addresses[0].getCountryName()

                //    val currentTime: Date = Calendar.getInstance().getTime()
                var counter1: Int = sharedPref.getInt("count", 0)
                editor.putString("Lat" + counter1, lat)
                editor.putString("Lon" + counter1, lon)
                editor.putString("address" + counter1, address)
                editor.putString("city" + counter1, city)

                editor.putInt("count", counter1 + 1)

                editor.apply()
                editor.commit()

                var myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
                myListView.adapter = myAdapter
            }


        }
    }
}
