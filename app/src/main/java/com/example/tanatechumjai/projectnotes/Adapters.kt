package com.example.tanatechumjai.projectnotes

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.lo_customer.view.*

class CustomerAdapter(mCtx: Context , val customers: ArrayList<Customer>): RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){

    val mCtx = mCtx
    class ViewHolder(itemview: View ): RecyclerView.ViewHolder(itemview){
        val txtCustomerName = itemview.txtCutomerName
        val txtMaxCredit = itemview.txtMaxCredit
        val btnUpdate = itemview.btnUpdate
        val btnDelete = itemview.btnDelete
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomerAdapter.ViewHolder {
            val v : View = LayoutInflater.from(p0.context).inflate(R.layout.lo_customer,p0,false)
            return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(p0: CustomerAdapter.ViewHolder, p1: Int) {
            val customer : Customer = customers[p1]
            p0.txtCustomerName.text = customer.customerName
            p0.txtMaxCredit.text = customer.maxCredit.toString()

    }


}