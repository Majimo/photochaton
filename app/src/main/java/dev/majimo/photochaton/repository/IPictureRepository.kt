package dev.majimo.photochaton.repository

import android.arch.lifecycle.LiveData
import dev.majimo.photochaton.model.Picture

interface IPictureRepository {

    fun insert(picture : Picture)

    fun get(id : Int) : LiveData<Picture>

    fun getAll() : LiveData<List<Picture>>

}