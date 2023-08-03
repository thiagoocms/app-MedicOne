package com.app.medicone.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.app.medicone.R
import com.app.medicone.databinding.ActivityHomeBinding
import com.app.medicone.model.Patient
import com.app.medicone.model.User
import com.app.medicone.view.FormActivity
import com.app.medicone.viewModel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var list: List<Patient>
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        setContentView(binding.root)
        user = intent.getSerializableExtra("user") as User
        createList()
        viewModel.list().observe(this){
            binding.recyclerView.adapter = HomeAdapter(it)
        }
        binding.btnCreate.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.getList(user.id)
    }

    fun createList(){
        list = listOf(Patient("Thiago Cavalcante Mendes da Silva", "19", "Masculino"),
                    Patient("Arianne Maria de Vasconcelos Cavalcante", "20", "Feminino"))
    }
}