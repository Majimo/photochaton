package dev.majimo.photochaton.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dev.majimo.photochaton.R
import dev.majimo.photochaton.view.preview.CameraPreview


class TakePictureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_take_picture)

        if (null == savedInstanceState) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CameraPreview.newInstance())
                    .commit()
        }
    }
}
