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
import com.example.prjgo.R
import com.example.prjgo.bal_game_model.MainViewModel
import com.example.prjgo.bal_game_model.MainViewModelFactory
import com.example.prjgo.bal_game_model.Repository
import com.example.prjgo.databinding.FragmentGameContents2Binding
import com.example.prjgo.databinding.FragmentGameContentsBinding

// OX퀴즈의 화면을 구성하는 프래그먼트
class OXGameFragment : Fragment() {
    private lateinit var binding : FragmentGameContents2Binding
    private lateinit var viewModel : MainViewModel4


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
        // 지금은 저장하기 버튼이 필요없기 때문에 주석처리 함
//        binding.saveBtn.setOnClickListener {
//            val action = GameContents2FragmentDirections.actionGameContents2FragmentToAccountFragment(selected)
//            it.findNavController().navigate(action)
//        }
        val repository = Repository4()
        val viewModelFactory = MainViewModelFactory4(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel4::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            binding.contentsExplain.setText(it.question)
        })
        binding.backarrow.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameContents2Fragment_to_gameFragment)
        }
        binding.item3.setOnClickListener {
            if(!clicked){
                clicked = true
                binding.item3.setBackgroundColor(Color.parseColor("#FFC93C"))
                if(viewModel.myResponse.value?.answer == true){
                    binding.item3.setText("O")
                }else if (viewModel.myResponse.value?.answer == false){
                    binding.item3.setText("X")
                }
            }else{
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