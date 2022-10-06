package com.example.testtribal

import com.example.testtribal.api.Api
import com.example.testtribal.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {

    suspend fun getCategoryList(): List<String>{
        return withContext(Dispatchers.IO){
            Api.retrofirService.getCategories()
        }
    }

    suspend fun getCategory(category: String): Category{
        return withContext(Dispatchers.IO){
            Api.retrofirService.getCategory(category)
        }
    }

}