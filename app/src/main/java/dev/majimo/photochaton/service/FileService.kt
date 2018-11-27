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

class FileService : IFileService{
    override fun createImageFile(url: String): File {
        val format = SimpleDateFormat("dd-MM-yyyy_HH-mm-ss-", Locale.getDefault()).format(Date())

        return File(url + "/" + format + ".jpg")
    }

    override fun getImage(url : String): File {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllImage(url: String): List<File> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}