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
import com.example.prjgo.R
import com.example.prjgo.bal_game_model.MainViewModel
import com.example.prjgo.bal_game_model.MainViewModelFactory
import com.example.prjgo.bal_game_model.Repository
import com.example.prjgo.databinding.FragmentGameContents3Binding
import com.example.prjgo.start_game_model.MainViewModel3
import com.example.prjgo.start_game_model.MainViewModelFactory3
import com.example.prjgo.start_game_model.Repository3

// 초성게임의 화면을 구성하는 프래그먼트
class StartGameFragment : Fragment() {
    private lateinit var binding : FragmentGameContents3Binding
    private lateinit var viewModel : MainViewModel3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var clicked = false
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_contents3, container, false)
        val args:StartGameFragmentArgs by navArgs()
        val item = args.nameContent3.name
        var selected = " "
        // 지금은 저장하기 버튼이 필요없기 때문에 주석처리 함
//        binding.saveBtn.setOnClickListener {
//            val action = GameContents3FragmentDirections.actionGameContents3FragmentToAccountFragment(selected)
//            it.findNavController().navigate(action)
//        }
        val repository = Repository3()
        val viewModelFactory = MainViewModelFactory3(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel3::class.java)
        viewModel.getPost()
        viewModel.myresponse.observe(this, Observer {
            binding.item3.setText(it.question)

        })
        binding.backarrow.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameContents3Fragment_to_gameFragment)
        }
        binding.item3.setOnClickListener {
            if(!clicked){
                clicked = true
                binding.item3.setBackgroundColor(Color.parseColor("#FFC93C"))
                binding.item3.setText(viewModel.myresponse.value?.example)

            }else{
                clicked = false
                binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                binding.item3.setText(viewModel.myresponse.value?.question)
            }
            // 이부분을 눌렀을 때는 색이 변하면서 정답이 나와야 하고 다시 눌렀을 경우에는
            // 정답보기로 바뀌면서 흰색 배경으로 가야하는 것 만들어 줘야함

        }
        binding.randomBtn.setOnClickListener {
            clicked = false
            viewModel.getPost()
            binding.item3.setText(viewModel.myresponse.value?.question)
            binding.item3.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }

        binding.contentsName2.setText(item)
        return binding.root
    }


}