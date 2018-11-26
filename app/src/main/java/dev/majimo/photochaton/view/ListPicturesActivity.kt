package dev.majimo.photochaton.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import dev.majimo.photochaton.R
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.view.adapter.PictureAdapter
import dev.majimo.photochaton.view_model.PictureViewModel
import javax.annotation.Nullable

class ListPicturesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pictures)

        val rv = findViewById<RecyclerView>(R.id.rv_pictures_list)

        rv.setHasFixedSize(true)

        val adapter = PictureAdapter(this)

        val vm = ViewModelProviders.of(this).get(PictureViewModel::class.java)

        vm.getAll().observe(this, Observer<List<Picture>> {
            adapter.setPictures(it)
            adapter.notifyDataSetChanged()
        })
    }
}
