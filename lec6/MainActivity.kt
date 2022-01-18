package com.example.calculator_c2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // start your code here
        var etNumber1:EditText = findViewById(R.id.etFirst)
        var etNumber2:EditText = findViewById(R.id.etSecond)

        var screen:TextView = findViewById(R.id.answer)

        var plus :Button = findViewById(R.id.plus)
        var diff :Button = findViewById(R.id.minus)

        plus.setOnClickListener({
            // this block will get  each time user clicks on plus button on interface

            if (!(etNumber1.text.toString().length > 0)) {
                etNumber1.requestFocus()
                Toast.makeText(baseContext, "Error", Toast.LENGTH_SHORT).show()
                etNumber1.setError("Pleasse enter a vlaue")


            } else if (!(etNumber2.text.toString().length > 0)) {
                etNumber2.requestFocus()
                etNumber2.setError("Pleasse enter a vlaue")
            } else {
                var secondNumber: Int = etNumber2.text.toString().toInt()
                var firstNumber: Int = etNumber1.text.toString().toInt()
                var res: Int = firstNumber + secondNumber

                screen.setText("Addition is: $res")

                Toast.makeText(this, "Answer is: $res", Toast.LENGTH_LONG).show()



            }


        })



        diff.setOnClickListener({

            var firstNumber : Int = etNumber1.text.toString().toInt()
            var secondNumber : Int= etNumber2.text.toString().toInt()
            var res : Int = firstNumber - secondNumber

            screen.setText("Difference is: $res")

        })



    }// on create ends here
}// end of class