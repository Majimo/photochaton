package dev.majimo.photochaton.dao

import android.net.Uri
import com.google.firebase.storage.FirebaseStorage
import dev.majimo.photochaton.model.Picture
import com.google.firebase.storage.StorageReference
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.storage.UploadTask
import com.google.android.gms.tasks.OnSuccessListener
import dev.majimo.photochaton.service.FileService
import dev.majimo.photochaton.service.IFileService


class PictureFirebaseDao : IPictureFirebaseDao {

    private var mStorageRef: StorageReference? = null

    init {
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }

    override fun insert(picture: Picture) {
        val file = Uri.fromFile(FileService().createImageFile("Ceci/est/mon/chemin"))
        val riversRef = mStorageRef?.child("images/rivers.jpg")

        riversRef?.putFile(file)
                ?.addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> { taskSnapshot ->
                    // Get a URL to the uploaded content
                    val downloadUrl = taskSnapshot.downloadUrl
                })
                ?.addOnFailureListener(OnFailureListener {
                    // Handle unsuccessful uploads
                    // ...
                })
    }

    override fun get(id: Int): Picture {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAll(): List<Picture> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}