package com.example.assignment5

import android.app.Activity
import android.app.ProgressDialog
import android.os.AsyncTask
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class FetchData(var ctx: Activity,var rv:RecyclerView) : AsyncTask<Void, Void, String>() {
    var context:Activity=ctx
    var progress: ProgressDialog?=null
    var response=""

    override fun onPreExecute() {
        super.onPreExecute()

        progress=ProgressDialog(context)
        progress!!.setTitle("Please wait")
        progress!!.setMessage("Reading all records from database... ")
        progress!!.show()


    }


    override fun doInBackground(vararg params: Void?): String {


        var link="http://192.168.10.12/php/stdget.php"


        var connection: HttpURLConnection?=null


        var url= URL(link)
        connection = url.openConnection() as HttpURLConnection
        connection.connectTimeout=5*1000
        connection.doInput=true
        connection.doOutput=true
//            connection.requestMethod="POST"
        connection.readTimeout=5000
        connection.connect()


        //READING
        var reader:BufferedReader= BufferedReader(InputStreamReader(connection.inputStream))
        var line=reader.readLine()
        while(line!=null)
        {
            response=response+line
            line=reader.readLine()
        }







        return response

    }


    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        progress!!.dismiss()


        var jarray= JSONArray(result)
        var size=jarray.length()
        var _name=mutableListOf<String>()
        var _fname=mutableListOf<String>()
        var _class=mutableListOf<String>()
        var _phone=mutableListOf<String>()
        var _Fee=mutableListOf<String>()
        var _TotalSubject=mutableListOf<String>()
        var _SubjectDetails=mutableListOf<String>()
        //var _class=mutableListOf<String>()


        var start=0
        while(start<size)
        {
            var jsonObj=jarray.getJSONObject(start)


            var sname=jsonObj.getString("Name")
            var fname=jsonObj.getString("FatherName")
            var sclass=jsonObj.getString("Class")

            var phone=jsonObj.getString("PhoneNo")
            var Fee=jsonObj.getString("MonthlyFee")
            var TotalSubject=jsonObj.getString("TotalSubjects")
            var SubjectDetail=jsonObj.getString("SubjectDetails")
            _name.add(sname)
            _fname.add(fname)
            _class.add(sclass)
            _phone.add(phone)
            _Fee.add(Fee)
            _TotalSubject.add(TotalSubject)
            _SubjectDetails.add(SubjectDetail)











            start++


        }
        rv.layoutManager= LinearLayoutManager(ctx)

        var myRecAdapter:myADapter=myADapter(ctx,_name,_fname,_class,_phone,_Fee,_TotalSubject,_SubjectDetails)
        rv.adapter=myRecAdapter


//        var message=AlertDialog.Builder(context)
//        message.setTitle("Server Response")
//        message.setMessage("Received: \n"+result)
//        message.create()
//        message.show()

    }

}