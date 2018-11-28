package dev.majimo.photochaton.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import dev.majimo.photochaton.R
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.view.adapter.PictureAdapter
import dev.majimo.photochaton.view_model.PictureViewModel

class ListPicturesActivity : MenuActivity(), PictureAdapter.IClickable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pictures)

        val rv = findViewById<RecyclerView>(R.id.rv_list_picture)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        val adapter = PictureAdapter(this)
        rv.adapter = adapter

        val vm = ViewModelProviders.of(this).get(PictureViewModel::class.java)

        vm.getAll().observe(this, Observer<List<Picture>> {
            adapter.setPictures(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun action(picture: Picture) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
