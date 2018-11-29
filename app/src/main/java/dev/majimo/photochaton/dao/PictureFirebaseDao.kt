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

            var list = getPicsToUpload();
            if (list.size > 0){
                var nb = uploadPics(list)

                if (nb != list.size){
                    clearUntil(nb)
                }
            }

        }).addOnFailureListener(OnFailureListener { exception ->
            addPicToUpload(picture)
        })
    }

    fun uploadPics(list : List<Picture>): Int{
        for ((index, pic) in list.withIndex()){
            val file = Uri.fromFile(File(pic.url))
            val riversRef = mStorageRef?.child("pictures/" + pic.name)
            var go = true;

            riversRef!!.putFile(file).addOnSuccessListener(OnSuccessListener { tResult ->
            }).addOnFailureListener(OnFailureListener { exception ->
                go = false;
            })

            if (!go){
                return index;
            }
        }

        clearPics()

        return list.size
    }

    companion object {
        private var toUpload: MutableList<Picture> = ArrayList()

        fun addPicToUpload(picture: Picture){
            toUpload.add(picture)
        }
        fun getPicsToUpload() : List<Picture>{
            return toUpload
        }
        fun clearPics(){
            toUpload.clear()
        }
        fun clearUntil(index : Int){
            for (i in 0..index) {
                toUpload.removeAt(i)
            }
        }
    }
}