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

    var localImageFilePath = ""
    private var mStorageRef: StorageReference? = null
    internal var riversRef: StorageReference? = null

    init {
        mStorageRef = FirebaseStorage.getInstance().reference
    }


    override fun createImageFile(context : Context): File? {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(Date())
        val imageFileName = "IMG_" + timeStamp + "_"
        val storageDir = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        var image: File? = null
        try {
            image = File.createTempFile(
                    imageFileName, /* prefix */
                    ".jpg", /* suffix */
                    storageDir      /* directory */
            )
            localImageFilePath = image!!.absolutePath
            return image
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return null

    }

    fun uploadImage(view: View) {
        val file = Uri.fromFile(File(localImageFilePath))
        riversRef = mStorageRef?.child("images/rivers.jpg")

        riversRef?.putFile(file)
                ?.addOnSuccessListener(object : OnSuccessListener<UploadTask.TaskSnapshot> {
                    override fun onSuccess(taskSnapshot: UploadTask.TaskSnapshot) {
                        // Get a URL to the uploaded content
                        val downloadUrl = taskSnapshot.getDownloadUrl()
                    }
                })
                ?.addOnFailureListener(object : OnFailureListener {
                    override fun onFailure(exception: Exception) {
                        // Handle unsuccessful uploads
                        // ...
                    }
                })
    }

}