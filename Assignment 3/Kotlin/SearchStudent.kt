package com.example.adminportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SearchStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_student)

        val search:Button=findViewById(R.id.btnsearch)
        var idEntry:EditText=findViewById(R.id.regnosearch)

        search.setOnClickListener({
            MyDatabaseClass(this).searchById(idEntry.text.toString())
        })

    }
}