package dev.majimo.photochaton.view.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import dev.majimo.photochaton.R
import dev.majimo.photochaton.model.Picture
import java.util.ArrayList

class PictureAdapter (val context: Context) : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

     var items : List<Picture> = ArrayList()

    fun setPictures(pictures : List<Picture>?){
        if (pictures == null){
            items = ArrayList()
        }
        else {
            items = pictures
        }
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder?.iv_picture.setImageURI(Uri.parse(items.get(position).url))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        return PictureViewHolder(LayoutInflater.from(context).inflate(R.layout.line_photo, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PictureViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tv_pictures = view.findViewById<TextView>(R.id.tv_pictures)
    }
}