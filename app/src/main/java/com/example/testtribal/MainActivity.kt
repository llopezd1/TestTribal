package com.example.testtribal

import android.content.Intent

import android.os.Bundle
import android.view.View.GONE
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtribal.adapters.CategoryAdapter
import com.example.testtribal.databinding.ActivityMainBinding
import com.example.testtribal.model.Category

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    companion object {
        const val CATEGORY = "category"
        const val CATEGORY_KEY = "category_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //define Recycler View
        val recycler = binding.rvList
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = CategoryAdapter()

        adapter.setOnItemClickListener {
            category ->
                val categoryObject = viewModel.getCategory(category)
                openDetailActivity(categoryObject)
        }

        recycler.adapter = adapter

        viewModel.categoryList.observe(this){
            list ->
                binding.progressBar.visibility = GONE
                adapter.submitList(list)

        }
    }

    private fun openDetailActivity(category: Category){

        val bundle = Bundle()
        val intent = Intent(this@MainActivity, CategoryDetailActivity::class.java)

        bundle.putSerializable(CATEGORY, category)

        intent.putExtras(bundle)
        startActivity(intent)

    }

}