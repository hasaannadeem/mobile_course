package com.example.phone

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val pref:String="checklogin"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var check:Int=0
        val intent = Intent(this, MainActivity2::class.java)
        val Num: EditText = findViewById(R.id.number)
        val next: Button = findViewById(R.id.button)
        var sharedPref=getSharedPreferences("pref", Context.MODE_PRIVATE)
        var editor=sharedPref.edit()
        var flag=sharedPref.getInt("check",0)
        if(flag!=0)
        {  startActivity(intent)
        }

        next.setOnClickListener {
            var number:String=Num.toString()
            while(check==0) {
                number = Num.text.toString()
                if (number == null)
                {
                       Toast.makeText(this, " \nPlease Enter a Number", Toast.LENGTH_LONG).show()
                }
                else
                    check=1
            }


            val intent = Intent(this, MainActivity2::class.java).apply {
              putExtra(EXTRA_MESSAGE, number)
            }
          editor.putInt("check",1)
            editor.putString("number",number)
            editor.apply()
            editor.commit()

            startActivity(intent)
        }
    }
}