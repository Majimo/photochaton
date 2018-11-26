package dev.majimo.photochaton.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import dev.majimo.photochaton.R

class MainActivity : AppCompatActivity() {
    private var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_launcher) as Button

        button!!.setOnClickListener {
            val intent = Intent(this, TakePictureActivity::class.java)
            startActivity(intent)
        }
    }
}
