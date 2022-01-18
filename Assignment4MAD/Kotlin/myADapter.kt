package com.example.assignment5

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class myADapter(ctx: Context, var _n:List<String>,var f:List<String>,var _clas:List<String>,var _ph:List<String>,var _Fe:List<String>,var _Ts:List<String>,var _Sdet:List<String>)
    : RecyclerView.Adapter<myADapter.viewHolder>() {


    var context:Context=ctx
    var sname:List<String> = _n
    var fname:List<String> = f
    var sclass:List<String> = _clas

    var phone:List<String> =_ph
    var Fee:List<String> = _Fe
    var TotalSubject:List<String> =_Ts
    var SubjectDetail:List<String> =_Sdet
    class viewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
    {
        var _eName:TextView=itemView.findViewById(R.id.eName);
        var _eID:TextView=itemView.findViewById(R.id.eID);
        var _eAge:TextView=itemView.findViewById(R.id.et3);
        var _eDate:TextView=itemView.findViewById(R.id.etJoiningDate);



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myADapter.viewHolder {

        var rowView= LayoutInflater.from(context).inflate(R.layout.mycustom, parent, false)
        return viewHolder(rowView)


    }

    override fun getItemCount(): Int {
        return sname.size
    }

    override fun onBindViewHolder(holder: myADapter.viewHolder, position: Int) {
      //  holder.image.setImageResource(images.get(position))
        holder._eName.setText("Employee Name: "+sname[position])
        holder._eID.setText("EmployeeID: "+fname[position])
        holder._eAge.setText("Age: "+sclass[position])
        holder._eDate.setText("JoiningDate: "+phone[position])

    }


}