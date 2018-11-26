package dev.majimo.photochaton.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import dev.majimo.photochaton.model.Picture

@Database(entities = arrayOf(Picture::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract val dao : IPictureTabletDao

    companion object {
        var instance : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase?{
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "picture.db").build()
            }
            return instance
        }
    }

}