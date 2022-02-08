package com.example.lovetest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_question.*


class QuestionFragment : Fragment(), View.OnClickListener{
    lateinit var naveController:NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        naveController = Navigation.findNavController(view)
        next2.setOnClickListener { this }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.next2 ->{
                naveController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }
        }
    }
}