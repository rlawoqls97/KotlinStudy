package com.example.prjgo.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.prjgo.R
import com.example.prjgo.databinding.FragmentGameContents3Binding


class GameContents3Fragment : Fragment() {
    private lateinit var binding : FragmentGameContents3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var clicked = false
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_contents3, container, false)
        val args:GameContents3FragmentArgs by navArgs()
        val item = args.nameContent3.name
        var selected = " "
        binding.saveBtn.setOnClickListener {
            val action = GameContents3FragmentDirections.actionGameContents3FragmentToAccountFragment(selected)
            it.findNavController().navigate(action)
        }
        binding.backarrow.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameContents3Fragment_to_gameFragment)
        }
        binding.item3.setOnClickListener {
            if(!clicked){
                clicked = true
                binding.item3.setBackgroundColor(Color.parseColor("#FFC93C"))
                binding.item3.setText("홍수 홍삼 황사 한숨\n행사 하수 현실 혜성\n홀수 헬스 환상 허세\n하사 휴식 형상 훈수\n\n등등")
            }else{
                clicked = false
                binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                binding.item3.setText("ㅎㅅ")
            }
            // 이부분을 눌렀을 때는 색이 변하면서 정답이 나와야 하고 다시 눌렀을 경우에는
            // 정답보기로 바뀌면서 흰색 배경으로 가야하는 것 만들어 줘야함

        }
        binding.arrowBackwardContents.setOnClickListener {
            binding.item3.setText("ㅎㅅ")
            binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        binding.arrowFowordContents.setOnClickListener {
            binding.item3.setText("ㅎㅅ")
            binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        binding.contentsName2.setText(item)
        return binding.root
    }


}