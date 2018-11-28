package dev.majimo.photochaton.dao

import android.content.Context
import android.net.Uri
import android.support.v4.content.FileProvider
import android.util.Log
import com.google.firebase.storage.FirebaseStorage
import dev.majimo.photochaton.model.Picture
import com.google.firebase.storage.StorageReference
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.storage.UploadTask
import com.google.android.gms.tasks.OnSuccessListener
import java.io.File
import java.net.URI


class PictureFirebaseDao() : IPictureFirebaseDao {

    private var mStorageRef: StorageReference? = null

    init {
        mStorageRef = FirebaseStorage.getInstance().getReference();
    }

    override fun insert(picture: Picture) {
        val file = Uri.fromFile(File(picture.url))
        val riversRef = mStorageRef?.child("pictures/" + picture.name)

        riversRef!!.putFile(file).addOnSuccessListener(OnSuccessListener { tResult ->
            Log.wtf("XXX", "Firebase OK")
        }).addOnFailureListener(OnFailureListener { exception ->
            Log.wtf("XXX", "Firebase OKN'T")
        })
    }
}