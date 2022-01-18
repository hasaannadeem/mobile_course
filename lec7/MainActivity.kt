package com.example.listviewc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // your code here

        var myListView :ListView = findViewById(R.id.myListView)
        var cityNames = listOf<String>("Lahore", "Kashmir", "Gujranwala", "Narowal", "Faisalabad",
                "Lahore", "Kashmir", "Gujranwala", "Narowal", "Faisalabad",
                "Lahore", "Kashmir", "Gujranwala", "Narowal", "Faisalabad",
                "Lahore", "Kashmir", "Islamabad", "Narowal", "karachi")

//        var myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , cityNames)
        var myAdapter = ArrayAdapter<String>(this, R.layout.custome_listview_layout, R.id.display , cityNames)
        myListView.adapter = myAdapter

        myListView.setOnItemClickListener{
//            a, b, c, d ->
            parent, view, position, id ->

            Toast.makeText(baseContext, "You have clicked an item: "+  cityNames[position], Toast.LENGTH_SHORT).show()


        }






    }// onCreate ends here



}// this is end of class