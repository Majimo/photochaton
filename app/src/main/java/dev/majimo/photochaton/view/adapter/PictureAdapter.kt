package dev.majimo.photochaton.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.TextView
import dev.majimo.photochaton.R

 class PictureAdapter (val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder?.tv_pictures.text = items.get(position)
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