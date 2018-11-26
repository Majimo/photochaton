package dev.majimo.photochaton.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import dev.majimo.photochaton.model.Picture

@Dao
interface IPictureTabletDao {
    @Insert
    fun insert(picture: Picture)

    @Query("SELECT * FROM Picture WHERE id = :id")
    fun get(id: Int): LiveData<Picture>

    @Query("SELECT * FROM Picture")
    fun getAll(): LiveData<List<Picture>>
}