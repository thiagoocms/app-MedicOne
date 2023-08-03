package com.app.medicone.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.medicone.R
import com.app.medicone.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {
    lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.back.setOnClickListener {
            finish()
        }
    }
}