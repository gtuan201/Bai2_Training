package com.example.bai2_training.ui.result

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai2_training.databinding.FragmentResultBinding
import com.example.bai2_training.ui.dessert.DessertAdapter
import com.example.bai2_training.viewmodel.DishViewModel

class ResultFragment : Fragment() {

    private lateinit var binding : FragmentResultBinding
    private lateinit var adapter: DessertAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentResultBinding.inflate(inflater,container,false)
        binding.rcvResult.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        val viewModel = ViewModelProvider(requireContext() as ViewModelStoreOwner)[DishViewModel::class.java]
        adapter = DessertAdapter(viewModel.getDataList())
        binding.rcvResult.adapter = adapter
        adapter.notifyDataSetChanged()
        binding.btnBack.setOnClickListener{
            viewModel.getDataList().clear()
            activity?.onBackPressed()
        }
        return binding.root
    }
}