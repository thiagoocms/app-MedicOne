package com.app.medicone.repository.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.medicone.model.User

@Dao
interface UserDao {

    @Insert
    fun save(user: User): Long

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    fun findByUserNameAndPassword(username: String, password: String): User

}