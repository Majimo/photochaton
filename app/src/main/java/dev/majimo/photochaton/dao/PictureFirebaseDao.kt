package dev.majimo.photochaton.dao

import android.net.Uri
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import dev.majimo.photochaton.model.Picture
import com.google.firebase.storage.StorageReference
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.storage.UploadTask
import com.google.android.gms.tasks.OnSuccessListener
import dev.majimo.photochaton.service.FileService
import dev.majimo.photochaton.service.IFileService
import com.google.firebase.storage.FileDownloadTask




class PictureFirebaseDao : IPictureFirebaseDao {

    private var mStorageRef: StorageReference? = null

    init {
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }

    override fun insert(picture: Picture) {
        val file = Uri.fromFile(FileService().createImageFile("pictures/"))
        val riversRef = mStorageRef?.child(picture.name)

        riversRef?.putFile(file)
                ?.addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> { taskSnapshot ->
                    // Get a URL to the uploaded content
                    // val downloadUrl = taskSnapshot.downloadUrl
                    // Féfé il dit "Bats les steaks de ces lignes là ! "
                    // Log.wtf("XXX", downloadUrl.toString())
                })
                ?.addOnFailureListener(OnFailureListener {
                    Log.wtf("XXX", "Erreur : " + it.message)
                })
    }
}