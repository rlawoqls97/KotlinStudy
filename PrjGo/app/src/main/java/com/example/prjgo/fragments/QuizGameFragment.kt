package com.example.prjgo.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.prjgo.OX_game_model.MainViewModel4
import com.example.prjgo.OX_game_model.MainViewModelFactory4
import com.example.prjgo.OX_game_model.Repository4
import com.example.prjgo.Quiz_game_model.MainViewModel5
import com.example.prjgo.Quiz_game_model.MainViewModelFactory5
import com.example.prjgo.Quiz_game_model.Repository5
import com.example.prjgo.R
import com.example.prjgo.databinding.FragmentQuizGameBinding

// 상식퀴즈의 화면을 구성하는 프래그먼트
class QuizGameFragment : Fragment() {
    private lateinit var binding: FragmentQuizGameBinding
    private lateinit var viewModel : MainViewModel5


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var clicked = false
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz_game, container, false)
        val args: QuizGameFragmentArgs by navArgs()
        val item = args.nameContent.name
        var selected = " "
        // 지금은 저장하기 버튼이 필요없기 때문에 주석처리 함
//        binding.saveBtn.setOnClickListener {
//            val action = GameContents2FragmentDirections.actionGameContents2FragmentToAccountFragment(selected)
//            it.findNavController().navigate(action)
//        }
        val repository = Repository5()
        val viewModelFactory = MainViewModelFactory5(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel5::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            binding.contentsExplain.setText(it.question)
        })
        binding.backarrow.setOnClickListener {
            it.findNavController().navigate(R.id.action_quizGameFragment_to_gameFragment)
        }
        binding.item3.setOnClickListener {
            if (!clicked) {
                clicked = true
                binding.item3.setBackgroundColor(Color.parseColor("#FFC93C"))
                binding.item3.setText(viewModel.myResponse.value?.answer)
            } else {
                clicked = false
                binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                binding.item3.setText("정답보기")
            }
            // 이부분을 눌렀을 때는 색이 변하면서 정답이 나와야 하고 다시 눌렀을 경우에는
            // 정답보기로 바뀌면서 흰색 배경으로 가야하는 것 만들어 줘야함

        }
        binding.randomBtn.setOnClickListener {
            clicked = false
            viewModel.getPost()
            binding.contentsExplain.setText(viewModel.myResponse.value?.question)
            binding.item3.setText("정답보기")
            binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }

        binding.contentsName2.setText(item)
        // Inflate the layout for this fragment
        return binding.root
    }
}