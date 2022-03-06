package com.example.prjgo.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.prjgo.R
import com.example.prjgo.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding :FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        binding.gameTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_gameFragment)
        }
        binding.testTap.setOnClickListener {
            showDialog()
//            it.findNavController().navigate(R.id.action_homeFragment_to_testFragment)
        }
        binding.accountTap.setOnClickListener {
            showDialog()
//            it.findNavController().navigate(R.id.action_homeFragment_to_accountFragment)
        }
        return binding.root
    }
    private fun showDialog(){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
        val mBuilder = AlertDialog.Builder(context).setView(mDialogView)
    }


}