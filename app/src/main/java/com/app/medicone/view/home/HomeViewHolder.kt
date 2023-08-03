package com.app.medicone.view.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.app.medicone.databinding.RowPatientBinding

class HomeViewHolder(binding: RowPatientBinding) : RecyclerView.ViewHolder(binding.root) {
    var name = binding.textNamePatient
    var age = binding.textAge
    var gender = binding.textGender
}