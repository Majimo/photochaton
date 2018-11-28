package dev.majimo.photochaton.service

import dev.majimo.photochaton.model.Slip
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JokeService {

    @GET("advice")
    fun listJoke(): Call<Slip>
}