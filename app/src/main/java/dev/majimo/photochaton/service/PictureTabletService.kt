package dev.majimo.photochaton.service

import android.content.Context
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.repository.IPictureRepository
import dev.majimo.photochaton.repository.PictureRepository

class PictureTabletService(context: Context) : IPictureTabletService {

    val repo = PictureRepository(context)

    override fun insert(picture: Picture) {

    }

    override fun get(id: Int): Picture {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<Picture> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}