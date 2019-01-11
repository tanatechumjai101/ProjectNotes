package com.example.tanatechumjai.projectnotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var dbHandler: DBHandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DBHandler(this,null)

        viewCustomers()
    }
    private fun viewCustomers(){
        val customerlist: ArrayList<Customer> = dbHandler.getCustomer(this)
        val adapter = CustomerAdapter(this,customerlist)
        val rv : RecyclerView = findViewById(R.id.Recycle1)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager
        rv.adapter = adapter
    }
}
