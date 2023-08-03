package com.app.medicone.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.medicone.model.Patient
import com.app.medicone.model.User
import com.app.medicone.repository.patient.PatientDao
import com.app.medicone.repository.user.UserDao

@Database(entities = [User::class, Patient::class], version = 1)
abstract class MedicOneDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getPatientDao(): PatientDao

    companion object {
        private lateinit var INSTANCE: MedicOneDatabase

        fun getDatabase(context: Context): MedicOneDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(MedicOneDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, MedicOneDatabase::class.java, "db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}