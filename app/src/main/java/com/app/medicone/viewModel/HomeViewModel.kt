package com.app.medicone.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.medicone.model.Patient
import com.app.medicone.repository.patient.PatientRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PatientRepository(application.applicationContext)
    private var list = MutableLiveData<List<Patient>>()
    private var patient = MutableLiveData<Patient>()

    fun getList(userId: Int) {
        list.value = repository.findAll(userId)
    }

    fun list(): LiveData<List<Patient>> {
        return list
    }
}