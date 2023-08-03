package com.app.medicone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.app.medicone.databinding.ActivityRegisterBinding
import com.app.medicone.model.User
import com.app.medicone.view.home.HomeActivity
import com.app.medicone.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var viewModel: RegisterViewModel
    var user: User = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        binding.back.setOnClickListener {
            finish()
        }
        binding.btnCreate.setOnClickListener {
            user = User(
                0,
                binding.editUser.text.toString(),
                binding.editPassword.text.toString(),
                binding.editEmail.text.toString(),
                binding.editTel.text.toString()
            )
            viewModel.doCreate(user)
        }
        viewModel.create().observe(this) {
            if (it > 0) {
                viewModel.login().observe(this){
                    user = it
                }
                var intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
                finish()
            }
        }
    }
}