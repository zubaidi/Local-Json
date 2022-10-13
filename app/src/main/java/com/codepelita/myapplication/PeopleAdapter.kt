package com.codepelita.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PeopleAdapter(
    private var context: Context,
    private var firstName: ArrayList<String>,
    private var lastName: ArrayList<String>,
    private var gender: ArrayList<String>,
    ) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}