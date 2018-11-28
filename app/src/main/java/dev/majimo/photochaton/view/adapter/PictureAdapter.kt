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
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.util.Log
import android.widget.Button
import android.widget.PopupWindow





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
        return PictureViewHolder(LayoutInflater.from(context).inflate(R.layout.line_photo, parent, false), context)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PictureViewHolder (view: View, val context: Context) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val iv_picture = view.findViewById<ImageView>(R.id.iv_picture)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val layoutInflater = context
                    .getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = layoutInflater.inflate(R.layout.popup_picture, null)
            val popupWindow = PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

            val btnDismiss = popupView.findViewById<Button>(R.id.bnt_popup_dismiss)
            btnDismiss.setOnClickListener(View.OnClickListener {
                popupWindow.dismiss()
            })

            popupWindow.showAsDropDown(v, 20, 20)
        }
    }
}