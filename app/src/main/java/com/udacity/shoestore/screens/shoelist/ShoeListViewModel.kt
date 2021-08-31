package com.udacity.shoestore.screens.shoelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    // create an array list of shoes of type Shoe
    // create a method to return that list

    private lateinit var _shoeList : MutableList<Shoe>
    val shoeListData = MutableLiveData<MutableList<Shoe>>()

    init {
        Timber.i("ShoeListViewModel created !")
        shoeListData.value = populateShoeList()
    }

    private fun populateShoeList() : MutableList<Shoe> {
        _shoeList = mutableListOf(
            Shoe("Flat shoes", 7.5, "Zara men", "Multicolored informal shoes with laces", listOf("shoe_1_1")),
            Shoe("Joggers", 8.5, "Nike", "Multicolored informal shoes with laces", listOf("shoe_2_2","")),
            Shoe("Runners", 9.0, "Adidas", "Multicolored informal shoes with laces", listOf("shoe_3_3","")),
            Shoe("Pim sole", 8.0, "Lee cooper", "Multicolored informal shoes with laces", listOf("shoe_4_4","")),
            Shoe("Sneakers", 8.5, "Bershka", "Multicolored informal shoes with laces", listOf("shoe_4_4","")),
            Shoe("Formal", 8.5, "Shoe mart", "Multicolored informal shoes with laces", listOf("shoe_2_2","")),
            Shoe("Casual", 9.5, "Zara men", "Multicolored informal shoes with laces", listOf("shoe_1_1",""))
        )

        return _shoeList
    }

    fun addShoe(shoe: Shoe){
        _shoeList.add(shoe)
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("ShoeListViewModel destroyed !")
        _shoeList.clear()
    }
}