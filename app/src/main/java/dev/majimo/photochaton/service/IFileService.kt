package dev.majimo.photochaton.service

import android.content.Context
import android.view.View
import java.io.File

interface IFileService {

    fun createImageFile(url : String) : File


    fun getImage(url : String)
}