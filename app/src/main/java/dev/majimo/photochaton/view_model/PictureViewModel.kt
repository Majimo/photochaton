package dev.majimo.photochaton.view_model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.service.IPictureService
import dev.majimo.photochaton.service.PictureService


class PictureViewModel(application: Application) : IPictureViewModel, AndroidViewModel(application) {

    val service : IPictureService = PictureService(application)

    fun insert(picture : Picture){
        return service.insert(picture)
    }

    fun get(id : Int) : LiveData<Picture>{
        return service.get(id)
    }

    fun getAll() : LiveData<List<Picture>>{
        return service.getAll()
    }
}