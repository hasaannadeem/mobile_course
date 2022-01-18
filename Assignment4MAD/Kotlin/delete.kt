package com.example.assignment5


import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.AsyncTask
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import javax.net.ssl.HttpsURLConnection

class del(var ctx: Activity): AsyncTask<String, Void, String>() {


    var context:Activity=ctx
    var progress:ProgressDialog?=null
    var response=""

    override fun onPreExecute() {
        super.onPreExecute()

        progress= ProgressDialog(context)
        progress!!.setTitle("Please wait")
        progress!!.setMessage("Inserting your record into database... ")
//        progress!!.show()


    }

    override fun doInBackground(vararg params: String?): String? {


        var ename=params[0]

        var link="http://192.168.8.102/php/stddel.php"


        var connection: HttpURLConnection?=null


        var url= URL(link)
        connection = url.openConnection() as HttpURLConnection
        connection.connectTimeout=5*1000
        connection.doInput=true
        connection.doOutput=true
//            connection.requestMethod="POST"
        connection.readTimeout=5000
        connection.connect()

        var data= URLEncoder.encode("column1","UTF-8")+"="+URLEncoder.encode(ename, "UTF-8")+"&"

        var writer = OutputStreamWriter(connection.outputStream)
        writer.write(data)
        writer.flush()
        //READING
        var reader: BufferedReader = BufferedReader(InputStreamReader(connection.inputStream))
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

        var message= AlertDialog.Builder(context)
        message.setTitle("Server Response")
        message.setMessage("Received: \n"+result)
        message.create()
        message.show()

    }
}