package dev.majimo.photochaton.service

import android.content.Context
import android.net.Uri
import android.os.Environment
import android.view.View
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class FileService(name : String) : IFileService{
    override fun createImageFile(url: String): File {

        val format

        var f = File(url)
    }

    init {

    }

    override fun getImage(url : String) {

    }

    companion object {
        fun createImage(url : String) : File{
            return File("")
        }
    }

}