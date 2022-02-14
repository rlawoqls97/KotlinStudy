package com.example.prj.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.prj.ListAdapter
import com.example.prj.Model
import com.example.prj.R
import com.example.prj.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_game.*

class GameFrag : Fragment() {
    lateinit var Adapter : ListAdapter
    lateinit var binding:FragmentGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val UserList = arrayListOf<Model>(
            Model("밸런스게임")
        )
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        var listLv = view.findViewById<ListView>(R.id.game_pg_listview)
        Adapter = ListAdapter(UserList)
        listLv.adapter = Adapter
        return view
//        val gameLVAdapter = ListAdapter(UserList)
//        game_pg_listview.adapter = gameLVAdapter
//        return inflater.inflate(R.layout.game_card, container, false)
    }




}