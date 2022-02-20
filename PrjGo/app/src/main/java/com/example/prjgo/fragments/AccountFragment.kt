package com.example.prjgo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.prjgo.R
import com.example.prjgo.databinding.FragmentAccountBinding
import com.example.prjgo.databinding.FragmentHomeBinding


class AccountFragment : Fragment() {
    private lateinit var binding : FragmentAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)
        // 이부분 널 오류
        val args:AccountFragmentArgs by navArgs()
        val item = args.selectedArgs
        if(item == ""){
            binding.selected.text = " "
        }else{
            binding.selected.text = item
        }

        // Inflate the layout for this fragment
        binding.homeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_accountFragment_to_homeFragment)
        }
        binding.gameTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_accountFragment_to_gameFragment)
        }
        binding.testTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_accountFragment_to_testFragment)
        }
        return binding.root
    }


}