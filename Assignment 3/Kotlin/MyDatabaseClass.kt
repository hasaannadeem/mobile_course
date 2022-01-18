package com.example.adminportal

import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AllPermission

class MyDatabaseClass(var view:Context) : SQLiteOpenHelper(view, "StudentDB.db", null, 1){

    val tableName = "Student"

    override fun onCreate(db: SQLiteDatabase?) {
        var tableQuery = "create table $tableName(ID varchar(20), NAME varchar(50), AGE integer, CGPA float, SUBJECTS integer, ADDRESS varchar(100))"
        db?.execSQL(tableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var dropTable = "drop table $tableName"
        db?.execSQL(dropTable)

        onCreate(db)

    }


    fun insertRecord(id:String, name:String, age:Int, cgpa:Float, subjects:Int, address:String)
    {

        var db = writableDatabase


        var cv:ContentValues = ContentValues()
        cv.put("ID", id)
        cv.put("NAME", name)
        cv.put("AGE", age)
        cv.put("CGPA", cgpa)
        cv.put("SUBJECTS", subjects)
        cv.put("ADDRESS", address)
        var result = db.insert(tableName, null, cv)
        if(result>0)
            Toast.makeText(view, "Record is inserted: $result", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(view, "Record is not inserted...", Toast.LENGTH_SHORT).show()

    }

    fun readAllRecords()
    {

        var db = readableDatabase
        var allData:Cursor = db.rawQuery("SELECT * FROM $tableName", null )

        var size = allData.count
        var x=0
        allData.moveToFirst()
        while(x<size)
        {
            var column1 = allData.getString(allData.getColumnIndex("ID"))
            var column2 = allData.getString(allData.getColumnIndex("NAME"))
            var column3 = allData.getString(allData.getColumnIndex("AGE"))
            var column4 = allData.getInt(allData.getColumnIndex("CGPA"))
            var column5 = allData.getInt(allData.getColumnIndex("SUBJECTS"))
            var column6 = allData.getInt(allData.getColumnIndex("ADDRESS"))

            Toast.makeText(view, "$column1 \n $column2 \n $column3 \n $column4 \n $column5 \n $column6", Toast.LENGTH_LONG).show()

            allData.moveToNext()
            x++
        }
    }


    fun searchById(id:String)
    {

        var db = readableDatabase
        var allData:Cursor = db.rawQuery("SELECT * FROM $tableName where ID = $id", null )

        var size = allData.count
        var x=0
        allData.moveToFirst()
        var allRecords = ""
        while(x<size)
        {
            var column1 = allData.getString(allData.getColumnIndex("ID"))
            var column2 = allData.getString(allData.getColumnIndex("NAME"))
            var column3 = allData.getString(allData.getColumnIndex("AGE"))
            var column4 = allData.getInt(allData.getColumnIndex("CGPA"))
            var column5 = allData.getInt(allData.getColumnIndex("SUBJECTS"))
            var column6 = allData.getInt(allData.getColumnIndex("ADDRESS"))

            allRecords+="Record No. ${x+1} \n $column1 \n" +
                    " $column2 \n" +
                    " $column3 \n" +
                    " $column4 \n" +
                    " $column5 \n" +
                    " $column6\n__________________\n\n"


            allData.moveToNext()
            x++
        }

        var alert = AlertDialog.Builder(view)
        alert.setTitle("Database records")
        alert.setMessage(allRecords)
        alert.setPositiveButton("Cancel", {id, dialog->})
        alert.create()
        alert.show()


    }

}