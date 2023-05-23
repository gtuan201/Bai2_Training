package com.example.bai2_training.ui.food

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai2_training.R
import com.example.bai2_training.databinding.FragmentFoodBinding
import com.example.bai2_training.ui.dessert.DessertAdapter
import com.example.bai2_training.viewmodel.DishViewModel

class FoodFragment : Fragment() {
    private lateinit var binding: FragmentFoodBinding
    private lateinit var adapter: DessertAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFoodBinding.inflate(inflater,container,false)
        val viewModel = ViewModelProvider(requireContext() as ViewModelStoreOwner)[DishViewModel::class.java]
        binding.rcvFood.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        viewModel.getFood().observe(requireContext() as LifecycleOwner){
            adapter = DessertAdapter(it)
            binding.rcvFood.adapter = adapter
        }
        binding.btnGoToDrink.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_favouriteFragment_to_drinkFragment)
            for (i in adapter.getCheckedItems()){
                viewModel.getDataList().add(i)
            }
        }
        binding.btnBack.setOnClickListener{
            viewModel.getDataList().clear()
            activity?.onBackPressed()
        }
        return binding.root
    }
}