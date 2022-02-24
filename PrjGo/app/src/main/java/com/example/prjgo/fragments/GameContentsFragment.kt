package com.example.prjgo.fragments

import android.annotation.SuppressLint
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
        var selected = " "
        binding.saveBtn.setOnClickListener {
            // 저장하기 버튼을 누르면 자신이 한 게임에 대한 정보가 들어가야함. 그리고 이미 저장이 되어 있는 문제를 다시 저장하려 하면
            // 이미 저장이 되어 있다는 알림이 떠야함.
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
        // 하드코딩 된 것이라서 나중에 데이터 바꿔줘야함
        binding.arrowBackwardContents.setOnClickListener {
            binding.item1.setText("내 흑역사 전세계에 \n 공유하고 5억 받기")
            binding.item2.setText("그냥살기")
            binding.item1.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        // 하드코딩 된 것이라서 나중에 데이터 바꿔줘야함
        binding.arrowFowordContents.setOnClickListener {
            binding.item1.setText("오이케이크 먹기")
            binding.item2.setText("김치케이크 먹기")
            binding.item1.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        binding.contentsName.setText(item)
        return binding.root
    }


}