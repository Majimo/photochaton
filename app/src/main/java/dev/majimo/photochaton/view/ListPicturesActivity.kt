package dev.majimo.photochaton.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dev.majimo.photochaton.R
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.view.adapter.PictureAdapter
import dev.majimo.photochaton.view_model.PictureViewModel
import java.io.File

class ListPicturesActivity : MenuActivity(), PictureAdapter.IClickable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pictures)

        val rv = findViewById<RecyclerView>(R.id.rv_list_picture)

        rv.setHasFixedSize(true)

        val layout = GridLayoutManager(this, 4)

        rv.layoutManager = layout

        val adapter = PictureAdapter(this)
        rv.adapter = adapter

        val vm = ViewModelProviders.of(this).get(PictureViewModel::class.java)

        vm.getAll().observe(this, Observer<List<Picture>> {
            adapter.setPictures(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun action(picture: Picture) {
        val intent = Intent(this, BigPictureActivity::class.java)
        intent.putExtra("urlPic", picture.url)
        startActivity(intent)
    }
}
