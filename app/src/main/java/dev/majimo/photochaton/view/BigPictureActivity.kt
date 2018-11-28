package dev.majimo.photochaton.view

import android.databinding.DataBindingUtil
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.ImageView
import dev.majimo.photochaton.R
import dev.majimo.photochaton.databinding.ActivityBigPictureBinding
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.view.adapter.PictureAdapter
import java.io.File
import java.io.FileInputStream

class BigPictureActivity : MenuActivity(), PictureAdapter.IClickable {
    lateinit var ivPopupPicture : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_picture)

        val pictureUrl: String = intent.getStringExtra("urlPic")

        val options = BitmapFactory.Options()
        options.inPreferredConfig = Bitmap.Config.RGB_565

        val bit = BitmapFactory.decodeStream(FileInputStream(File(pictureUrl)), null, options)

        ivPopupPicture = findViewById(R.id.iv_popup_picture)

        ivPopupPicture.setImageBitmap(bit)
    }

    override fun action(picture: Picture) {
    }
}
