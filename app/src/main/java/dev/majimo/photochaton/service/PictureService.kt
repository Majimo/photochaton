package dev.majimo.photochaton.service

import android.arch.lifecycle.LiveData
import android.content.Context
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.repository.IPictureRepository
import dev.majimo.photochaton.repository.PictureRepository

class PictureService(context: Context) : IPictureService {

    val repo : IPictureRepository = PictureRepository(context)

    override fun insert(picture: Picture) {
        repo.insert(picture)
    }

    override fun get(id: Int): LiveData<Picture> {
        return repo.get(id)
    }

    override fun getAll(): LiveData<List<Picture>> {
        return repo.getAll()
    }
}