package dev.majimo.photochaton.service

import dev.majimo.photochaton.model.Picture

interface IPictureTabletService {

    fun insert(picture : Picture)

    fun get(id : Int) : Picture

    fun getAll() : List<Picture>

}