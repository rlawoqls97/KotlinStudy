package com.example.prjgo.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import com.example.prjgo.ListAdapter
import com.example.prjgo.Model
import com.example.prjgo.R
import com.example.prjgo.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private lateinit var binding : FragmentGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //새로 만든
        var UserList = arrayListOf<Model>(
            Model(R.drawable.bal," 밸런스게임"),
            Model(R.drawable.lee," 이구동성"),
            Model(R.drawable.ox," O/X 퀴즈"),
            Model(R.drawable.sang," 상식퀴즈"),
            Model(R.drawable.cho," 초성퀴즈")
        )

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
        // Inflate the layout for this fragment
        var adapter = ListAdapter(requireActivity(), UserList)
        var listLV = binding.gamePgListview
        listLV.adapter = adapter
        binding.homeTap.setOnClickListener {
            showDialog()
            //it.findNavController().navigate(R.id.action_gameFragment_to_homeFragment)
        }
        binding.testTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameFragment_to_testFragment)
        }
        binding.accountTap.setOnClickListener {
            showDialog()
            //it.findNavController().navigate(R.id.action_gameFragment_to_accountFragment)
        }
        // 밸런스게임이랑 이구동성게임 같은 틀, 상식이랑 OX퀴즈 같은 틀, 초성게임 따로 틀 이렇게 만들어야함
        // i의 값이 0, 1일 때 같은 페이지 컨텐츠만 다르게, 2, 3일 때 같은 페이지, 4는 다른 페이지로 만들어야함


        binding.gamePgListview.setOnItemClickListener { adapterView, view, i, l ->
            if(i == 0 || i == 1){
                val actionToContents = GameFragmentDirections.actionGameFragmentToGameContentsFragment(UserList[i])
                view.findNavController().navigate(actionToContents)
            }else if(i == 2 || i == 3){
                val actionToContents2 = GameFragmentDirections.actionGameFragmentToGameContents2Fragment(UserList[i])
                view.findNavController().navigate(actionToContents2)
            }else{
                val actionToContents3 = GameFragmentDirections.actionGameFragmentToGameContents3Fragment(UserList[i])
                view.findNavController().navigate(actionToContents3)
            }
        }

        return binding.root
    }
    // 아직 미구현된 페이지들을 눌렀을 경우 dialog 나오게 하는 것
    private fun showDialog(){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
        val mBuilder = AlertDialog.Builder(context).setView(mDialogView).setCancelable(false)
        val alertDialog = mBuilder.show()
        alertDialog.findViewById<Button>(R.id.closeBtn).setOnClickListener {
            alertDialog.dismiss()
        }

    }

}