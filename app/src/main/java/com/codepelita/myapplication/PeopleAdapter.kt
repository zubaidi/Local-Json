package com.codepelita.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter(
    private var context: Context,
    private var firstName: ArrayList<String>,
    private var lastName: ArrayList<String>,
    private var gender: ArrayList<String>,
    private var age: ArrayList<String>,
    private var number: ArrayList<String>,
) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nama_depan = itemView.findViewById<TextView>(R.id.tvFirstName)
        var nama_belakang = itemView.findViewById<TextView>(R.id.tvLastName)
        var jkelamin = itemView.findViewById<TextView>(R.id.tvGender)
        var usia = itemView.findViewById<TextView>(R.id.tvAge)
        var nomor = itemView.findViewById<TextView>(R.id.tvNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_adapter, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nama_depan.text = firstName[position]
        holder.nama_belakang.text = lastName[position]
        holder.jkelamin.text = gender[position]
        holder.usia.text = age[position]
        holder.nomor.text = number[position]
    }

    override fun getItemCount(): Int {
        return firstName.size
    }
}