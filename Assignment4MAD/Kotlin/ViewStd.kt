package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView

class ViewStd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_std)


        var recyView:RecyclerView=findViewById(R.id.myReclye)


            var readObj = FetchData(this,recyView)
            readObj.execute()


    }
}