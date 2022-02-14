package com.example.prj

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.makeramen.roundedimageview.RoundedImageView

class ListAdapter(val context: Context, private val uList:ArrayList<Model>) : BaseAdapter() {
    override fun getCount(): Int {
        return uList.size
    }

    override fun getItem(position: Int): Any {
        return uList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    @SuppressLint("ResourceType")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //주석 쳐있는게 원래 코드였음.
        val view: View = LayoutInflater.from(context).inflate(R.layout.game_card, null)
        val gname = view.findViewById<TextView>(R.id.item_detail)
        val gimg = view.findViewById<RoundedImageView>(R.id.main_image)
        val user = uList[position]
        gname.text = user.name
        gimg.setImageResource(user.profile)

        return view
//        var view = convertView
//        val gname = view?.findViewById<TextView>(R.id.item_detail)
//        if (view == null){
//            view = LayoutInflater.from(parent?.context).inflate(R.layout.game_card, parent, false)
//        }
//        gname?.text = uList[position].name
//        return view!!
    }
}