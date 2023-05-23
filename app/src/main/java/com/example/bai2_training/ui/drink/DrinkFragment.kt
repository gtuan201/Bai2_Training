package com.example.bai2_training.ui.drink

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai2_training.R
import com.example.bai2_training.databinding.FragmentDrinkBinding
import com.example.bai2_training.ui.dessert.DessertAdapter
import com.example.bai2_training.viewmodel.DishViewModel

class DrinkFragment : Fragment() {

    private lateinit var binding: FragmentDrinkBinding
    private lateinit var adapter: DessertAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDrinkBinding.inflate(inflater,container,false)
        binding.rcvDrink.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        val viewModel = ViewModelProvider(requireContext() as androidx.lifecycle.ViewModelStoreOwner)[DishViewModel::class.java]
        viewModel.getDrink().observe(requireContext() as LifecycleOwner){
            adapter = DessertAdapter(it)
            binding.rcvDrink.adapter = adapter
        }
        binding.btnResult.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_drinkFragment_to_resultFragment)
            for (i in adapter.getCheckedItems()){
                viewModel.getDataList().add(i)
            }
            adapter.getCheckedItems().clear()
        }
        binding.btnBack.setOnClickListener{
            viewModel.getDataList().clear()
            activity?.onBackPressed()
        }
        return binding.root
    }
}