package com.example.phone

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemLongClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity() {
    //val prefName:String="mySharedPref"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val button: Button = findViewById(R.id.button5)
        val mylistview: ListView = findViewById(R.id.mylist)

        var sharedPref = getSharedPreferences("prefName", Context.MODE_PRIVATE)
        var editor = sharedPref.edit()
        var list = ArrayList<String>()
        var counter = sharedPref.getInt("count", 0)
        var start: Int = 0
        while (start < counter) {
            var item: String = sharedPref.getString("Lat" + start, "Unknown").toString()
            item = item + "\t" + sharedPref.getString("Lon" + start, "Unknown").toString()
            item = item + "\n" + sharedPref.getString("address" + start, "Unknown").toString()
            item = item + ",  " + sharedPref.getString("city" + start, "Unknown").toString()

            list.add(item)
            start = start + 1
        }

        if (list.size < 1)
            list.add("Nothing in the Favourite")

        var myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        mylistview.adapter = myAdapter
        button.setOnClickListener {

            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }
        mylistview.setOnItemLongClickListener(OnItemLongClickListener { parent, view, position, arg3 ->
            val adb = AlertDialog.Builder(this)
            adb.setTitle("Delete Item")
            adb.setMessage("Are You Sure You Want To Delete ?")
            adb.setIcon(android.R.drawable.ic_dialog_alert)
            adb.setPositiveButton("OK") { dialog, which ->
                myAdapter.remove(list.get(position))
                myAdapter.notifyDataSetChanged()
                Toast.makeText(applicationContext, "Delete Successfully", Toast.LENGTH_LONG).show() }

            adb.setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(applicationContext, "Cancel Delete", Toast.LENGTH_LONG).show()
                //finish();
            }

            val alertDialog = adb.create()
            alertDialog.show()
            true


        })
    }
}