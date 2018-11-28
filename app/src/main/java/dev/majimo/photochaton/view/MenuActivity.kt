package dev.majimo.photochaton.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import dev.majimo.photochaton.R

open class MenuActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.menu_take_picture -> {
                val intent = Intent(this, TakePictureActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_pics_list -> {
                val intent1 = Intent(this, ListPicturesActivity::class.java)
                startActivity(intent1)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}