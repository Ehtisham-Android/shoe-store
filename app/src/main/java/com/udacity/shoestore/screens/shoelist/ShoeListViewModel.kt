package com.udacity.shoestore.screens.shoelist

import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListViewModel : ViewModel() {

    private lateinit var _shoeList : MutableList<Shoe>
    val shoeListData = MutableLiveData<MutableList<Shoe>>()
    private val _saveButtonEnable = MutableLiveData<Boolean>()
    val saveButtonEnable: LiveData<Boolean>
        get() = _saveButtonEnable

    val gotoShoeListScreen = MutableLiveData<Boolean>()
    var shoeName : String = ""
    var shoeSize : Double = 0.0
    var shoeCompany : String = ""
    var shoeDescription : String = ""


    init {
        Timber.i("ShoeListViewModel created !")
        shoeListData.value = populateShoeList()
        gotoShoeListScreen.value = false
        _saveButtonEnable.value = false
    }

    private fun populateShoeList() : MutableList<Shoe> {
        _shoeList = mutableListOf(
            Shoe("Flat shoes", 7.5, "Zara men", "Multicolored informal shoes with laces", listOf("shoe_1_1")),
            Shoe("Joggers", 8.5, "Nike", "Multicolored informal shoes with laces", listOf("shoe_2_2")),
            Shoe("Runners", 9.0, "Adidas", "Multicolored informal shoes with laces", listOf("shoe_3_3")),
            Shoe("Pim sole", 8.0, "Lee cooper", "Multicolored informal shoes with laces", listOf("shoe_4_4")),
        )

        return _shoeList
    }

    fun addShoe(){
        _shoeList.add(createShoe())
        goBackToListScreen()
    }

    private fun createShoe() : Shoe {
        return Shoe(shoeName,
            shoeSize, shoeCompany, shoeDescription, listOf(""))
    }

    fun enableSaveButton() {
        _saveButtonEnable.value = (shoeName.isNotEmpty()
                && shoeSize.toString().isNotEmpty()
                && shoeDescription.isNotEmpty()
                && shoeCompany.isNotEmpty())
    }

    val shoeNameTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(editable: Editable) {
            shoeName = editable.toString()
            enableSaveButton()
        }
    }

    val shoeCompanyTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(editable: Editable) {
            shoeCompany = editable.toString()
            enableSaveButton()
        }
    }

    val shoeSizeTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(editable: Editable) {
            shoeSize = editable.toString().toDouble()
            enableSaveButton()
        }
    }

    val shoeDescriptionTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(editable: Editable) {
            shoeDescription = editable.toString()
            enableSaveButton()
        }
    }

    fun goBackToListScreen(){
        gotoShoeListScreen.value = true
    }

    fun goBackToListScreenComplete(){
        gotoShoeListScreen.value = false
        _saveButtonEnable.value = false
    }

    override fun onCleared() {
        super.onCleared()
        _shoeList.clear()
    }
}