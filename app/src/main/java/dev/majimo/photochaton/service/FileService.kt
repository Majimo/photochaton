package dev.majimo.photochaton.service

import dev.majimo.photochaton.model.Picture
import java.io.File
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

class FileService : IFileService{
    override fun createImageFile(url: String): File {
        val format = SimpleDateFormat("dd-MM-yyyy_HH-mm-ss", Locale.getDefault()).format(Date())

        return File(url + "/" + format + ".jpg")
    }

    override fun fileToPicture(file : File) : Picture{

        val url = file.absolutePath
        val name = file.name
        val ts = Timestamp(Date().time)

        return Picture(0, url, name)
    }
}