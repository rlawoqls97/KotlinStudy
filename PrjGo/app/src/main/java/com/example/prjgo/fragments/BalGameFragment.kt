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
import com.example.prjgo.*
import com.example.prjgo.bal_game_model.MainViewModel
import com.example.prjgo.bal_game_model.MainViewModelFactory
import com.example.prjgo.bal_game_model.Repository
import com.example.prjgo.databinding.FragmentGameContentsBinding


class BalGameFragment : Fragment() {
    private lateinit var binding : FragmentGameContentsBinding
    private lateinit var viewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_contents, container, false)
        val args:BalGameFragmentArgs by navArgs()
        val item = args.nameContent.name
        // 이부분 null 오류
        var selected = " "
        // 지금은 저장하기 버튼이 필요없기 때문에 주석처리 함
//        binding.saveBtn.setOnClickListener {
//            // 저장하기 버튼을 누르면 자신이 한 게임에 대한 정보가 들어가야함. 그리고 이미 저장이 되어 있는 문제를 다시 저장하려 하면
//            // 이미 저장이 되어 있다는 알림이 떠야함.
//            val action = GameContentsFragmentDirections.actionGameContentsFragmentToAccountFragment(selected)
//            it.findNavController().navigate(action)
//        }
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {
            binding.item1.setText(it.solution1)
            binding.item2.setText(it.solution2)

        })
        binding.backarrow.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameContentsFragment_to_gameFragment)
        }
        binding.item1.setOnClickListener {
            binding.item1.setBackgroundColor(Color.parseColor("#FFC93C"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            // 이부분 널 오류

        }
        binding.item2.setOnClickListener {
            binding.item1.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFC93C"))
            // 이부분 널 오류

        }
        // 하드코딩 된 것이라서 나중에 데이터 바꿔줘야함
        binding.arrowBackwardContents.setOnClickListener {
            viewModel.getPost()
            binding.item1.setText(viewModel.myResponse.value?.solution1)
            binding.item2.setText(viewModel.myResponse.value?.solution2)
            binding.item1.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        // 하드코딩 된 것이라서 나중에 데이터 바꿔줘야함
        binding.arrowFowordContents.setOnClickListener {
            viewModel.getPost()
            binding.item1.setText(viewModel.myResponse.value?.solution1)
            binding.item2.setText(viewModel.myResponse.value?.solution2)
            binding.item1.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
            binding.item2.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
        }
        binding.contentsName.setText(item)
        return binding.root
    }


}