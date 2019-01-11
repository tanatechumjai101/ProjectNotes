package com.example.tanatechumjai.projectnotes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHandler(contet: Context, factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(contet, DATABASE_NAME, factory,DATABASE_VERSION){


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
    fun getCustomer(mCtx: Context): ArrayList<Customer> {
        val qry = "Select * From $CUSTOMERS_TABEL_NAME"

        val db = this.readableDatabase
        val cursor = db.rawQuery(qry,null)
        val customers = ArrayList<Customer>()
        if(cursor.count == 0 ){
            Toast.makeText(mCtx,"No Records Found", Toast.LENGTH_SHORT).show()
        }else {
            while (cursor.moveToNext()){
                    val customer = Customer()
                customer.customerID = cursor.getInt(cursor.getColumnIndex(COLUMN_CUSTOMERID))
                customer.customerName = cursor.getString(cursor.getColumnIndex(COLUMN_CUSTOMERNAME))
                customer.maxCredit = cursor.getDouble(cursor.getColumnIndex(COLUMN_MAXCREDIT))
                customers.add(customer)
            }
            Toast.makeText(mCtx,"${cursor.count.toString()} Records Found ",Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        db.close()
        return  customers

    }
}