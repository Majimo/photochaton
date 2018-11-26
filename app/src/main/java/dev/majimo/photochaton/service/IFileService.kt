package dev.majimo.photochaton.service

import android.content.Context
import java.io.File

interface IFileService {

    fun createImageFile(context : Context) : File?


}