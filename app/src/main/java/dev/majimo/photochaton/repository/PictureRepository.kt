package dev.majimo.photochaton.repository

import android.arch.lifecycle.LiveData
import android.content.Context
import dev.majimo.photochaton.dao.AppDatabase
import dev.majimo.photochaton.dao.IPictureFirebaseDao
import dev.majimo.photochaton.dao.IPictureTabletDao
import dev.majimo.photochaton.model.Picture

class PictureRepository(context : Context) : IPictureRepository{

    var daoTablet : IPictureTabletDao = AppDatabase.getInstance(context)!!.daoTablet
    var daoFirebase : IPictureFirebaseDao = AppDatabase.getInstance(context)!!.daoFirebase

    override fun insert(picture: Picture) {
        daoTablet.insert(picture)
        daoFirebase.insert(picture)
    }

    override fun get(id: Int): LiveData<Picture> {
        return daoTablet.get(id)
    }

    override fun getAll(): LiveData<List<Picture>> {
        return daoTablet.getAll()
    }
}