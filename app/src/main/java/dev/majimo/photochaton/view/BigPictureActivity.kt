package dev.majimo.photochaton.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dev.majimo.photochaton.R
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.view.adapter.PictureAdapter

class BigPictureActivity : MenuActivity(), PictureAdapter.IClickable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_picture)
    }

    override fun action(picture: Picture) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
