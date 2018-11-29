package dev.majimo.photochaton.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.facebook.stetho.Stetho
import dev.majimo.photochaton.R
import dev.majimo.photochaton.model.Slip
import dev.majimo.photochaton.service.JokeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import dev.majimo.photochaton.model.Picture
import dev.majimo.photochaton.view_model.PictureViewModel
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : MenuActivity() {
    private var button: Button? = null

    private var tvJoke: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Stetho.initializeWithDefaults(this)

        tvJoke = findViewById(R.id.tv_joke)

        button = findViewById(R.id.btn_launcher) as Button

        button!!.setOnClickListener {
            val intent = Intent(this, TakePictureActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        getJoke()
    }

    private fun getJoke() {
        val url = "https://api.adviceslip.com/"

        val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        val service = retrofit.create(JokeService::class.java)

        service.listJoke().enqueue(object : Callback<Slip> {

            override fun onResponse(call: Call<Slip>, response: Response<Slip>) {
                val joke = response.body()

                Log.wtf("XXX", "onResponse")

                print(" one course : ${joke?.slip?.slip_id} : ${joke?.slip?.advice} ")
                tvJoke?.text = joke?.slip?.advice ?: ""
            }

            override fun onFailure(call: Call<Slip>, t: Throwable) {
                //Log.wtf("XXX", "T'es là onFailure" + t.message)
                //error("KO : $t")
                t.printStackTrace()
            }
        })
    }
}
