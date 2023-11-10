package com.iyr.a7thweekpractice

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MyStringTable")
data class MyStringEntity(
    val str : String
) {
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
}