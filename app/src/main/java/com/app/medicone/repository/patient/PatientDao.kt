package com.app.medicone.repository.patient

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.app.medicone.model.Patient

@Dao
interface PatientDao {

    @Insert
    fun save(patient: Patient): Long

    @Update
    fun update(patient: Patient): Int

    @Delete
    fun delete(patient: Patient)

    @Query("SELECT * FROM patients WHERE id = :id")
    fun findById(id: Int): Patient

    @Query("SELECT * FROM patients WHERE userId = :userId")
    fun findAllByUserId(userId: Int): List<Patient>
}