package com.app.medicone.repository.patient

import android.content.Context
import com.app.medicone.model.Patient
import com.app.medicone.repository.MedicOneDatabase

class PatientRepository(context: Context) {
    private val db = MedicOneDatabase.getDatabase(context).getPatientDao()

    fun save(patient: Patient): Long? {
        return db.save(patient)
    }

    fun update(patient: Patient): Int? {
        return db.update(patient)
    }

    fun delete(id: Int) {
        db.delete(findById(id)!!)
    }

    fun findById(id: Int): Patient? {
        return db.findById(id)
    }

    fun findAll(userId: Int): List<Patient>? {
        return db.findAllByUserId(userId)
    }

}