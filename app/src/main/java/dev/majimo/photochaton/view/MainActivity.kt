package dev.majimo.photochaton.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.facebook.stetho.Stetho
import dev.majimo.photochaton.R

class MainActivity : MenuActivity() {
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this)

        button = findViewById(R.id.btn_launcher) as Button

        button!!.setOnClickListener {
            val intent = Intent(this, TakePictureActivity::class.java)
            startActivity(intent)
        }
    }
}
