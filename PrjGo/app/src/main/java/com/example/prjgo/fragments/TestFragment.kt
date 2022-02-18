package com.example.prjgo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.prjgo.R
import com.example.prjgo.databinding.FragmentHomeBinding
import com.example.prjgo.databinding.FragmentTestBinding


class TestFragment : Fragment() {
    private lateinit var binding : FragmentTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        // Inflate the layout for this fragment
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_testFragment_to_homeFragment)
        }
        binding.gameTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_testFragment_to_gameFragment)
        }
        binding.accountTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_testFragment_to_accountFragment)
        }
        return binding.root
    }


}