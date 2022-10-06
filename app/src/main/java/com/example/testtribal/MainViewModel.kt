package com.example.testtribal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtribal.model.Category
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel : ViewModel() {

    private val mainRepository = MainRepository()

    private val _categoryList = MutableLiveData<List<String>>()
    val categoryList: LiveData<List<String>>
        get() = _categoryList

    init {
        getCategoryList()
    }

    private fun getCategoryList() {
        viewModelScope.launch {
            response(mainRepository.getCategoryList())
        }
    }

    private fun response(list: List<String>) {
        _categoryList.value = list
        println(list.joinToString(","))
    }

    fun getCategory(category: String): Category {

        val categoryObject: Category

        runBlocking {
            categoryObject = mainRepository.getCategory(category)
        }

        return categoryObject

    }

}