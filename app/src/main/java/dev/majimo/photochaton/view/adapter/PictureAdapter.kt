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
        options.inSampleSize = 8

        val bit = BitmapFactory.decodeStream(FileInputStream(File(items.get(position).url)), null, options)

        holder?.iv_picture.setImageBitmap(bit)

        // holder?.iv_picture.setImageURI(Uri.parse(items.get(position).url))

        holder?.picture = items.get(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        if (context is TakePictureActivity) {
            return PictureViewHolder(LayoutInflater.from(context).inflate(R.layout.line_photo, parent, false))
        }
        else {
            return PictureViewHolder(LayoutInflater.from(context).inflate(R.layout.line_grid_photo, parent, false))
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

            /*

            // Voir comment envoyer du binding dans une activité

            val layoutInflater = context
                    .getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = layoutInflater.inflate(R.layout.popup_picture, null)
            val popupWindow = PopupWindow(
                    popupView,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT)

            val picBinding = DataBindingUtil.setContentView<ViewDataBinding>(TakePictureActivity(), R.layout.popup_picture)
            val picClicked = Picture(0, "/storage/emulated/0/Android/data/dev.majimo.photochaton/files/27-11-2018_17-40-45-.jpg", "27-11-2018_17-40-45-.jpg")
            picBinding.data =

            val btnDismiss = popupView.findViewById<Button>(R.id.bnt_popup_dismiss)
            btnDismiss.setOnClickListener(View.OnClickListener {
                popupWindow.dismiss()
            })

            popupWindow.showAsDropDown(v, 20, 20)
            */
        }
    }
}