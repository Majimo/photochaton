package dev.majimo.photochaton.view_model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.repository.IPictureRepository
import dev.majimo.photochaton.repository.PictureRepository


class PictureViewModel(application: Application) : IPictureViewModel, AndroidViewModel(application) {

    val repo : IPictureRepository = PictureRepository(application)

    fun insert(picture : Picture){
        return repo.insert(picture)
    }

    fun get(id : Int) : LiveData<Picture>{
        return repo.get(id)
    }

    fun getAll() : LiveData<List<Picture>>{
        return repo.getAll()
    }
}