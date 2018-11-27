package dev.majimo.photochaton.dao

import android.arch.persistence.room.Dao
import dev.majimo.photochaton.model.Picture


interface IPictureFirebaseDao {

    fun insert(picture : Picture)

    fun get(id : Int) : Picture

    fun getAll() : List<Picture>
}