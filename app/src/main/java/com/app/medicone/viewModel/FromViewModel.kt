package com.app.medicone.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.app.medicone.repository.patient.PatientRepository

class FromViewModel(application: Application): AndroidViewModel(application) {

    private val repository = PatientRepository(application.applicationContext)

    fun save(): Long?{
        return null
    }
}