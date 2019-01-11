package com.example.tanatechumjai.projectnotes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(contet: Context, name : String , factory: SQLiteDatabase.CursorFactory, version: Int):
    SQLiteOpenHelper(contet, DATABASE_NAME, factory,DATABASE_VERSION){


    companion object {
        private val  DATABASE_NAME = "MyData.db"
        private  val DATABASE_VERSION = 1

        val CUSTOMERS_TABEL_NAME = "Customers"
        val COLUMN_CUSTOMERID = "customerid"
        val COLUMN_CUSTOMERNAME = "customername"
        val COLUMN_MAXCREDIT = "maxcredit"
     }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CUSTOMERS_TABLE = ("CREATE TABLE $CUSTOMERS_TABEL_NAME ("+
                "$COLUMN_CUSTOMERID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_CUSTOMERNAME TEXT,"+
                "$COLUMN_MAXCREDIT DOUBLE DEFAULT 0 )")
                db?.execSQL(CREATE_CUSTOMERS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}