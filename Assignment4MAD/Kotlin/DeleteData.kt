package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class delData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_data)

        var eID:EditText=findViewById(R.id.etEmployeeID)
        var deleBtn: Button =findViewById(R.id.button4)


        deleBtn.setOnClickListener()
        {
            var threadObject: del = del(this@delData)
            threadObject.execute(eID.text.toString())


            //clearing
            eID.setText("").toString()



        }

    }
}