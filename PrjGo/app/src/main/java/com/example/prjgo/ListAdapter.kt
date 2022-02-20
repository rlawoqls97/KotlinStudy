package com.example.prjgo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.makeramen.roundedimageview.RoundedImageView

// 새로 만들어 보는것
class ListAdapter(val  context: Context, private val uList:ArrayList<Model>) : BaseAdapter(){
    override fun getCount(): Int {
        return uList.size
    }
    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun getItem(p0: Int): Any {
        return uList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.game_card, null)
        val gname = view.findViewById<TextView>(R.id.itemdetail)
        val gimg = view.findViewById<RoundedImageView>(R.id.mainimage)
        val user = uList[position]
        gname.text = user.name
        gimg.setImageResource(user.profile)

        return view
    }
}