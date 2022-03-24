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
import com.example.prjgo.databinding.FragmentGameContents2Binding
import com.example.prjgo.databinding.FragmentGameContentsBinding

// 다음문제로 넘기면 위의 내용이랑 안에 있는 텍스트들 그리고 정답도 다 같이 넘어가야함.
class OXGameFragment : Fragment() {
    private lateinit var binding : FragmentGameContents2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var clicked = false
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_contents2, container, false)
        val args:OXGameFragmentArgs by navArgs()
        val item = args.nameContents2.name
        var selected = " "
        // 지금은 저장하기 버튼이 필요없기 때문에 주석처리 함
//        binding.saveBtn.setOnClickListener {
//            val action = GameContents2FragmentDirections.actionGameContents2FragmentToAccountFragment(selected)
//            it.findNavController().navigate(action)
//        }
        binding.backarrow.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameContents2Fragment_to_gameFragment)
        }
        binding.item3.setOnClickListener {
            if(!clicked){
                clicked = true
                binding.item3.setBackgroundColor(Color.parseColor("#FFC93C"))
                binding.item3.setText("기쁨, 노여움, \n슬픔, 즐거움")
            }else{
                clicked = false
                binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                binding.item3.setText("정답보기")
            }
            // 이부분을 눌렀을 때는 색이 변하면서 정답이 나와야 하고 다시 눌렀을 경우에는
            // 정답보기로 바뀌면서 흰색 배경으로 가야하는 것 만들어 줘야함

        }
        binding.arrowBackwardContents.setOnClickListener {
            binding.contentsExplain.setText("여러가지 감정을 뜻하는 \n 사자성어 희노애락은 \n 각각 어떤 감정을 뜻하나요?")
            binding.item3.setText("정답보기")
            binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        binding.arrowFowordContents.setOnClickListener {
            binding.contentsExplain.setText("상식퀴즈 다음문제~~")
            binding.item3.setText("정답보기")
            binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        binding.contentsName2.setText(item)
        // Inflate the layout for this fragment
        return binding.root
    }
}