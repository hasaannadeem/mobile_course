package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddStudent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)
        var eName:EditText=findViewById(R.id.eName)
        var eID:EditText=findViewById(R.id.etEmployeeID)
        var eAge:EditText=findViewById(R.id.et3)
        var eJoiningDate:EditText=findViewById(R.id.etJoiningDate);
        var submit:Button=findViewById(R.id.button6)


        submit.setOnClickListener()
        {
            var name=eName.text.toString()
            var ID=eID.text.toString()
            var age=eAge.text.toString()
            var ejd=eJoiningDate.text.toString()
            var threadObject:InsertData =InsertData(this@AddStudent)
            threadObject.execute(name,ID,age,ejd);

            //clearing after submit 
             eName.setText("");
            eID.setText("");
             eAge.setText("");
             eJoiningDate.setText("");
            
        }

    }
}