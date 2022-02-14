package com.example.prj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListAdapter(private val UserList:ArrayList<Model>) : BaseAdapter() {
    override fun getCount(): Int {
        return UserList.size
    }

    override fun getItem(position: Int): Any {
        return UserList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view =convertView
        val gname = view?.findViewById<TextView>(R.id.item_detail)
        val user = UserList[position]
        gname?.text = user.gname
        if (view == null){
            view = LayoutInflater.from(parent?.context).inflate(R.layout.game_card, parent, false)
        }

        return view!!
    }
}