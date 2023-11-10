package com.iyr.a7thweekpractice

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyStringDAO {
    @Insert
    fun addMyString(myString : MyStringEntity)

    @Update
    fun updateMyString(myString : MyStringEntity)

    @Delete
    fun deleteMyString(myString : MyStringEntity)

    @Query("SELECT * FROM MyStringTable")
    fun getAllMyStrings() : List<MyStringEntity>

}