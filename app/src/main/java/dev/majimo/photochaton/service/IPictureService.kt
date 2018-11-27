package dev.majimo.photochaton.service

import android.arch.lifecycle.LiveData
import dev.majimo.photochaton.model.Picture

interface IPictureService {

    fun insert(picture : Picture)

    fun get(id : Int) : LiveData<Picture>

    fun getAll() : LiveData<List<Picture>>

}