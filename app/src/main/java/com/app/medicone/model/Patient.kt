package com.app.medicone.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "patients")
class Patient(): Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Int = 0

    @ColumnInfo
    var name: String = ""

    @ColumnInfo
    var age: String = ""

    @ColumnInfo
    var gender: String = ""

    @ColumnInfo
    var userId: Int = 0

    constructor(name: String, age: String, gender: String) : this() {
        this.name = name
        this.age = age
        this.gender = gender
    }

    constructor(name: String, age: String, gender: String, userId: Int) : this() {
        this.name = name
        this.age = age
        this.gender = gender
        this.userId = userId
    }
}