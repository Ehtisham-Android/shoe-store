package com.udacity.shoestore.screens.shoelist

import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber


class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoeListBinding
    lateinit var viewModel: ShoeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            goToLoginScreen()
        }

        return false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        viewModel.shoeListData.observe(viewLifecycleOwner, Observer {
            for (item in it) {
                Timber.i("item number : %s", item.name)
            }

            addShoeItemsInScrollView(inflater, it)
        })

        binding.fabShoeDetails.setOnClickListener {
            goToShoeDetailScreen()
        }

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().openOptionsMenu()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback);

        return binding.root
    }

    private fun addShoeItemsInScrollView(inflater: LayoutInflater, shoeList: MutableList<Shoe>) {
        for (shoe in shoeList) {
            val row: ItemShoeListBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_shoe_list, null, false)

            val imageId = resources.getIdentifier(
                shoe.images[0],
                "drawable",
                requireContext().packageName
            )
            row.ivShoeThumbnail.setImageResource(imageId)
            row.tvCompany.text = shoe.company
            row.tvName.text = shoe.name
            row.tvSize.text = "Size: " + shoe.size
            row.tvDescription.text = shoe.description

            binding.llItems.addView(row.root)
        }
    }

    private fun goToShoeDetailScreen() {
        Navigation.findNavController(this.requireView())
            .navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
    }

    private fun goToLoginScreen() {
        Navigation.findNavController(this.requireView())
            .navigate(R.id.action_shoeListFragment_to_loginFragment)
    }
}