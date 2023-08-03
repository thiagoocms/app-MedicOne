package com.app.medicone.repository.user

import android.content.Context
import com.app.medicone.model.User
import com.app.medicone.repository.MedicOneDatabase

class UserRepository(context: Context) {

    private val db = MedicOneDatabase.getDatabase(context).getUserDao()

    fun save(user: User): Long{
        return db.save(user)
    }

    fun findByUserNameAndPassword(username: String, password: String): User {
        return db.findByUserNameAndPassword(username, password)
    }

}