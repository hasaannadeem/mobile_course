package com.example.adminportal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddNewStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_new_student)

        var stdid: EditText = findViewById(R.id.regno)
        var stdname: EditText = findViewById(R.id.stdName)
        var stdage: EditText = findViewById(R.id.age)
        var stdcgpa: EditText = findViewById(R.id.cgpa)
        var stdsubjects: EditText = findViewById(R.id.subjects)
        var stdaddress: EditText = findViewById(R.id.address)

        val saveData: Button = findViewById(R.id.btnsave)

        saveData.setOnClickListener {

            var id = stdid.text.toString()
            var name = stdname.text.toString()
            var age = stdage.text.toString().toInt()
            var cgpa: Float = stdage.text.toString().toFloat()
            var subjects: Int = stdsubjects.text.toString().toInt()
            var address = stdaddress.text.toString()

            val myDB: MyDatabaseClass = MyDatabaseClass(this)
            myDB.insertRecord(id, name, age, cgpa, subjects, address)

        }

    }
}