package com.example.phone

import android.content.Context
import android.content.SharedPreferences
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.TextView
import android.widget.Toast
import java.text.BreakIterator
import java.util.*
import kotlin.system.exitProcess


class LocationClass(var context: Context, private var View:TextView,var share:SharedPreferences,var hshare:SharedPreferences,var numShare:SharedPreferences) :LocationListener{
    override fun onLocationChanged(location: Location) {
        //       TODO("Not yet implemented")
        var flag1:Boolean=true
         var latitude: Double = location.latitude
            var longitude: Double = location.longitude
       var counter1: Int = hshare.getInt("count", 0)
       // var edit =share.edit()
        for (i in 0..counter1) {
            if (latitude.toInt() == hshare.getString("Lat" + i, "0")?.toInt() ?: 0.0) {
                if (longitude.toInt()== hshare.getString("Lon" + i, "0")?.toInt() ?: 0.0) {
                    flag1 = false
                }
            }
        }

        var flag:Boolean=false

        var counter:Int=share.getInt("count",0)
        for (i in 0..counter)
        {
            if(latitude.toInt()== share.getString("Lat"+i,"0")?.toInt() ?: 0.0)
            {
                if(longitude.toInt()== share.getString("Lon"+i,"0")?.toInt() ?: 0.0) {

                       flag=true
                    var item: String = numShare.getString("number", "Unknown").toString()
                    var manager: SmsManager = SmsManager.getDefault()
                    var strPhone=item
                    var strMessage="You reached at your Favourite Location"
                    manager.sendTextMessage(strPhone, null, strMessage, null , null )
                    Toast.makeText(context, "Your message has been sent", Toast.LENGTH_SHORT).show()
                  //  Toast.makeText(context,"Found  "+i, Toast.LENGTH_SHORT).show()
                    exitProcess(1)

                }
            }

        }
            flag1=true
         //   View.text="Your Current Location is:-\nLatitude: $latitude \nLongitude: $longitude\n"

        val geocoder: Geocoder
        val addresses: List<Address>
        geocoder = Geocoder(context, Locale.getDefault())

        addresses = geocoder.getFromLocation(
                latitude, longitude, 1)

        if (addresses != null && addresses.size > 0) {
            val address: String = addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()

            val city: String = addresses[0].getLocality()
            val state: String = addresses[0].getAdminArea()
            val country: String = addresses[0].getCountryName()
            //  val postalCode: String = addresses[0].getPostalCode()
            //  val knownName: String = addresses[0].getFeatureName() // Only if available else return NULL

            View.text = "Your Current Location is:-\nLatitude: $latitude \nLongitude: $longitude\nYour Physical address is: $address\n City: $city\nState: $state\nCountry: $country"
            if(flag1==true) {
                var editor = hshare.edit()
                val currentTime: Date = Calendar.getInstance().getTime()
                var counter1: Int = hshare.getInt("count", 0)
                editor.putString("Lat" + counter1, latitude.toString())
                editor.putString("Lon" + counter1, longitude.toString())
                editor.putString("time" + counter1, currentTime.toString())
                editor.putString("address"+counter1,address)
                editor.putString("city"+counter1,city)
                editor.putInt("count", counter1 + 1)

                editor.apply()
                editor.commit()
            }
            return
        }

    }

    override fun onProviderDisabled(provider: String) {
        super.onProviderDisabled(provider)
    }

    override fun onProviderEnabled(provider: String) {
        super.onProviderEnabled(provider)
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
       // super.onStatusChanged(provider, status, extras)
    }


}