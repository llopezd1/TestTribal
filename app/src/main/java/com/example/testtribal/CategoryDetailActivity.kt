package com.example.testtribal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testtribal.MainActivity.Companion.CATEGORY
import com.example.testtribal.databinding.ActivityCategoryDetailBinding
import com.example.testtribal.model.Category


class CategoryDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val category = bundle?.getSerializable(CATEGORY) as Category


        binding.txtId.text = category.id
        binding.txtCreatedAt.text = category.created_at
        binding.txtUpdateAt.text = category.updated_at
        binding.txtValue.text = category.value



    }
}