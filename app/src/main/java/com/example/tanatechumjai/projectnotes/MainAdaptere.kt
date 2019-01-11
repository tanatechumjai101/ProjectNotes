package com.example.tanatechumjai.projectnotes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainAdaptere (


): RecyclerView.Adapter<MainAdaptere.ViewHolder>() {

    override fun getItemCount(): Int {
        return 3

    }

    override fun onCreateViewHolder(parant: ViewGroup, viewType: Int): MainAdaptere.ViewHolder {
        var view: View = LayoutInflater.from(parant.context).inflate(R.layout.activity_main_adaptere, parant, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var Listview_1: ListView = itemView.findViewById(R.id.Listview_1)
    }
}
