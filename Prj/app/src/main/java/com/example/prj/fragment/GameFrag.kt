package com.example.prj.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.prj.ListAdapter
import com.example.prj.MainActivity
import com.example.prj.Model
import com.example.prj.R
import com.example.prj.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.game_card.*

class GameFrag : Fragment() {


    private lateinit var binding: FragmentGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment

        // img파일에 나중에 받아온 img를 넣어줘야함
        var UserList = arrayListOf<Model>(
            Model(R.color.white,"밸런스게임"),
            Model(R.color.white,"이구동성"),
            Model(R.color.white,"O/X 퀴즈"),
            Model(R.color.white,"상식게임"),
            Model(R.color.white,"초성퀴즈")
        )
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        var listLv = view.findViewById<ListView>(R.id.game_pg_listview)
        val Adapter = ListAdapter(requireActivity(), UserList)
        listLv.adapter = Adapter

        return view
//        val gameLVAdapter = ListAdapter(UserList)
//        game_pg_listview.adapter = gameLVAdapter
//        return inflater.inflate(R.layout.game_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }



}