package dev.majimo.photochaton.service

import android.content.Context
import android.view.View
import dev.majimo.photochaton.model.Picture
import java.io.File

interface IFileService {

    fun createImageFile(url : String) : File


    fun getImage(url : String) : File

    fun getAllImage(url: String) : List<File>
}