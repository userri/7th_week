package com.iyr.a7thweekpractice

import android.content.Context
import androidx.room.Database
import androidx.room.Room
//import androidx.room.Room
//import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [MyStringEntity::class], version = 1)
abstract class MyStringDatabase : RoomDatabase() {
    abstract fun getMyStringDAO() : MyStringDAO

    companion object {
        var instance : MyStringDatabase? = null

        fun getInstance(context: Context) : MyStringDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    MyStringDatabase::class.java,
                    "mystring-database"
                ).fallbackToDestructiveMigration()
                    // 데이터 베이스 버전 올릴 때마다 데이터베이스 초기화됨
                    .allowMainThreadQueries().build()
                // 원래는 안되지만 일단 스레드 생성 없이 메인스레드에서 데이터에 접근하도록 요청함.
            }

            return instance!!
        }
    }


}