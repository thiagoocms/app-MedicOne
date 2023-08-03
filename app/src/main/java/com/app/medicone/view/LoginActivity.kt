package com.app.medicone.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.app.medicone.databinding.ActivityLoginBinding
import com.app.medicone.view.home.HomeActivity
import com.app.medicone.viewModel.LoginViewModel
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.btnLogin.setOnClickListener {
            viewModel.doLogin(binding.editUser.text.toString(), binding.editPassword.text.toString())
        }
        binding.txtCreate.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        viewModel.login().observe(this){
            if (it != null){
                var intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("user", it)
                startActivity(intent)
                finish()
            }else{
                Snackbar.make(binding.root, "Usuario ou senha invalidos...", Snackbar.LENGTH_LONG).show()
            }
        }


    }
}