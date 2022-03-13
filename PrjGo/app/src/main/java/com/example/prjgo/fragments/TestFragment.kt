package com.example.prjgo.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prjgo.*
import com.example.prjgo.databinding.FragmentHomeBinding
import com.example.prjgo.databinding.FragmentTestBinding


class TestFragment : Fragment() {
    private lateinit var binding : FragmentTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var UserList = arrayListOf<TestModel>(
            TestModel(R.drawable.first,"MBTI", "https://www.16personalities.com/ko/%EB%AC%B4%EB%A3%8C-%EC%84%B1%EA%B2%A9-%EC%9C%A0%ED%98%95-%EA%B2%80%EC%82%AC"),
            TestModel(R.drawable.second,"에고그램", "http://ego.na.to/test/ego/"),
            TestModel(R.drawable.third,"mgram", "https://mgram.me/ko/"),
            TestModel(R.drawable.fourth,"애착유형", "http://typer.kr/test/ecr/"),
            TestModel(R.drawable.fifth,"EQ", "https://eqtest.kr/"),
            TestModel(R.drawable.six,"연애능력", "https://www.banggooso.com/gl/1002/"),
            TestModel(R.drawable.seven,"연락유형", "https://type-of-contact.netlify.app/"),
            TestModel(R.drawable.eight,"결혼상대", "https://www.simcong.com/quiz/349"),
        )
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        // Inflate the layout for this fragment
        var adapter = ContentRVAdapter(requireActivity(), UserList)
        var recyRV = binding.recyclerView
        recyRV.adapter = adapter
        recyRV.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.homeTap.setOnClickListener {
            showDialog()
            //it.findNavController().navigate(R.id.action_testFragment_to_homeFragment)
        }
        binding.gameTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_testFragment_to_gameFragment)
        }
        binding.accountTap.setOnClickListener {
            showDialog()
            //it.findNavController().navigate(R.id.action_testFragment_to_accountFragment)
        }

        adapter.itemClick = object : ContentRVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(context, ContentShowActivity::class.java)
                intent.putExtra("url", UserList[position].url)
                startActivity(intent)
            }

        }

        return binding.root
    }
    private fun showDialog(){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null)
        val mBuilder = AlertDialog.Builder(context).setView(mDialogView).setCancelable(false)
        val alertDialog = mBuilder.show()
        alertDialog.findViewById<Button>(R.id.closeBtn).setOnClickListener {
            alertDialog.dismiss()
        }

    }

}