package com.app.medicone.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "users")
class User() : Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int = 0

    @ColumnInfo
    var username: String = ""

    @ColumnInfo
    var password: String = ""

    @ColumnInfo
    var email: String = ""

    @ColumnInfo
    var tel: String = ""

    constructor(username: String, password: String) : this() {
        this.username = username
        this.password = password
    }

    constructor(username: String, password: String, email: String, tel: String) : this() {
        this.username = username
        this.password = password
        this.email = email
        this.tel = tel
    }

    constructor(id: Int, username: String, password: String, email: String, tel: String) : this() {
        this.id = id
        this.username = username
        this.password = password
        this.email = email
        this.tel = tel
    }

}