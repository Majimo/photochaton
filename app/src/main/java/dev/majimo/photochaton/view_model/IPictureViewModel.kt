package dev.majimo.photochaton.view_model

import android.arch.lifecycle.LiveData
import dev.majimo.photochaton.model.Picture

interface IPictureViewModel {
    fun insert(picture : Picture)

    fun get(id : Int) : LiveData<Picture>

    fun getAll() : LiveData<List<Picture>>
}