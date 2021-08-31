package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoelist.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailBinding
    lateinit var viewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.btnCancel.setOnClickListener{
            goToShoeListScreen()
        }

        binding.btnSave.setOnClickListener{
            val result = validateFields()
            if (result == "valid"){
                saveShoeDetails()
                goToShoeListScreen()
            }else{
                Toast.makeText(requireContext(), result, Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    private fun goToShoeListScreen(){
        Navigation.findNavController(this.requireView()).popBackStack()
    }

    private fun validateFields() : String
    {
        return when {
            binding.etShoeName.text.toString()
                .isBlank() -> return getString(R.string.please_enter) + " shoe name"
            binding.etShoeCompany.text.toString()
                .isBlank() -> return getString(R.string.please_enter) + " the brand"
            binding.etShoeSize.text.toString()
                .isBlank() -> return getString(R.string.please_enter) + " shoe size"
            binding.etShoeDescription.text.toString()
                .isBlank() -> return getString(R.string.please_enter) + " shoe description"
            else -> "valid"
        }
    }

    private fun saveShoeDetails(){
        val shoe = Shoe(binding.etShoeName.text.toString(),
            binding.etShoeSize.text.toString().toDouble(),
            binding.etShoeCompany.text.toString(),
            binding.etShoeDescription.text.toString(),
            listOf("shoe_2_2"))

        viewModel.addShoe(shoe)
    }
}