package dev.majimo.photochaton.view.adapter

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import dev.majimo.photochaton.R
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.view.TakePictureActivity
import java.util.ArrayList
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import java.io.File
import java.io.FileInputStream


class PictureAdapter (val context: IClickable) : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    var items : List<Picture> = ArrayList()

    interface IClickable {
        fun action(picture: Picture)
    }

    fun setPictures(pictures : List<Picture>?){
        if (pictures == null){
            items = ArrayList()
        }
        else {
            items = pictures
        }
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.RGB_565
        options.inSampleSize = 5

        val bit = BitmapFactory.decodeStream(FileInputStream(File(items.get(position).url)), null, options)

        holder?.iv_picture.setImageBitmap(bit)

        holder?.picture = items.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        if (context is TakePictureActivity) {
            return PictureViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.line_photo, parent, false), context)
        }
        else {
            return PictureViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.line_grid_photo, parent, false), context)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PictureViewHolder (view: View, val context: IClickable) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val iv_picture = view.findViewById<ImageView>(R.id.iv_picture)
        lateinit var picture: Picture

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            context.action(picture)
        }
    }
}