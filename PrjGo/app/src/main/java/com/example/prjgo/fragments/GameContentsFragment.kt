package com.example.prjgo.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.prjgo.R
import com.example.prjgo.databinding.FragmentGameContentsBinding


class GameContentsFragment : Fragment() {
    private lateinit var binding : FragmentGameContentsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_contents, container, false)
        val args:GameContentsFragmentArgs by navArgs()
        val item = args.nameContent.name
        // 이부분 null 오류
        var selected = ""
        binding.saveBtn.setOnClickListener {
            val action = GameContentsFragmentDirections.actionGameContentsFragmentToAccountFragment(selected)
            it.findNavController().navigate(action)
        }
        binding.backarrow.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameContentsFragment_to_gameFragment)
        }
        binding.item1.setOnClickListener {
            binding.item1.setBackgroundColor(Color.parseColor("#FFC93C"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            // 이부분 널 오류
            selected = binding.item1.text.toString()
        }
        binding.item2.setOnClickListener {
            binding.item1.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFC93C"))
            // 이부분 널 오류
            selected = binding.item2.text.toString()
        }
        binding.contentsName.setText(item)
        return binding.root
    }


}