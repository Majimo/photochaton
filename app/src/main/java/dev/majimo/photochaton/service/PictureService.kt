package dev.majimo.photochaton.service

import android.arch.lifecycle.LiveData
import android.content.Context
import android.os.AsyncTask
import dev.majimo.photochaton.dao.PictureFirebaseDao
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.repository.IPictureRepository
import dev.majimo.photochaton.repository.PictureRepository
import java.io.File

class PictureService(private val context: Context) : IPictureService {
    val repo : IPictureRepository = PictureRepository(context)

    override fun insert(picture: Picture) {
        insertAsync(repo).execute(picture)
    }

    override fun get(id: Int): LiveData<Picture> {
        return repo.get(id)
    }

    override fun getAll(): LiveData<List<Picture>> {
        return repo.getAll()
    }

    private class insertAsync(private val repository: IPictureRepository) : AsyncTask<Picture, Void?, Void?>() {

        override fun doInBackground(vararg params: Picture?): Void? {
            repository.insert(params[0]!!)

            var fbDao = PictureFirebaseDao()
            fbDao.insert(params[0]!!)

            return null
        }
    }
}