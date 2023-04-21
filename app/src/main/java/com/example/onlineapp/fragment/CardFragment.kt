package com.example.onlineapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.onlineapp.R
import com.example.onlineapp.RoomDB.AppDatabase
import com.example.onlineapp.adapter.CardAdaptor
import com.example.onlineapp.databinding.FragmentCardBinding

class CardFragment : Fragment() {
    private lateinit var binding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCardBinding.inflate(layoutInflater)

        val preference=requireContext().getSharedPreferences("info", AppCompatActivity.MODE_PRIVATE)
        val editor=preference.edit()
        editor.putBoolean("isCart",false )
        editor.apply()

        val dao=AppDatabase.getDatabase(requireContext()).productDao()
        dao.getAllProducts().observe(requireActivity()){
            binding.cardRecycler.adapter=CardAdaptor(requireContext(),it)
        }
        return binding.root
    }

}