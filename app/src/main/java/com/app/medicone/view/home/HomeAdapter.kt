package com.app.medicone.view.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.medicone.databinding.RowPatientBinding
import com.app.medicone.model.Patient
import com.google.android.material.snackbar.Snackbar

class HomeAdapter(var list: List<Patient>) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        var binding = RowPatientBinding.inflate(LayoutInflater.from(parent.context))
        binding.card.setOnClickListener {
            Snackbar.make(binding.root, "click",Snackbar.LENGTH_LONG).show()
        }
        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.age.text = list[position].age + " anos"
        holder.gender.text = list[position].gender
    }
}