package com.example.bai2_training.ui.dessert

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai2_training.R
import com.example.bai2_training.databinding.FragmentDessertBinding
import com.example.bai2_training.model.Dish
import com.example.bai2_training.viewmodel.DishViewModel

class DessertFragment : Fragment() {

    private lateinit var binding: FragmentDessertBinding
    private lateinit var adapter: DessertAdapter
    private var listDessertChecked : ArrayList<Dish> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentDessertBinding.inflate(inflater,container,false)
        binding.rcvDessert.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        val viewModel = androidx.lifecycle.ViewModelProvider(requireContext() as androidx.lifecycle.ViewModelStoreOwner)[DishViewModel::class.java]
        viewModel.getDessert().observe(requireContext() as LifecycleOwner){
            adapter = DessertAdapter(it)
            binding.rcvDessert.adapter = adapter
        }
        binding.btnGoToFavFra.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_favouriteFragment)
            for (dessert in adapter.getCheckedItems()){
                listDessertChecked.add(dessert)
            }
            viewModel.setDataList(listDessertChecked)
        }
        return binding.root
    }
}