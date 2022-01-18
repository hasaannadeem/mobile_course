package com.example.adminportal

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add:Button=findViewById(R.id.addbtn)
        val search:Button=findViewById(R.id.searchbtn)
        val delete:Button=findViewById(R.id.deletebtn)
        val display:Button=findViewById(R.id.displaybtn)


        add.setOnClickListener({
            var intent: Intent = Intent(this, AddNewStudent::class.java)
            startActivity(intent)
        })

        display.setOnClickListener({
            val myDB: MyDatabaseClass = MyDatabaseClass(this)
            myDB.readAllRecords()
        })

        search.setOnClickListener({
            var intent: Intent = Intent(this, SearchStudent::class.java)
            startActivity(intent)
        })

    }
}

