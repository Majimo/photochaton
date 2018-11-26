package dev.majimo.photochaton.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import dev.majimo.photochaton.dao.AppDatabase
import dev.majimo.photochaton.dao.IPictureTabletDao
import dev.majimo.photochaton.model.Picture

class PictureRepository(context : Context) : IPictureRepository{

    var dao : IPictureTabletDao = AppDatabase.getInstance(context)!!.dao

    override fun insert(picture: Picture) {
        dao.insert(picture)
    }

    override fun get(id: Int): LiveData<Picture> {
        return dao.get(id)
    }

    override fun getAll(): LiveData<List<Picture>> {
        return dao.getAll()
    }
}