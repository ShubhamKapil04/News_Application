package com.example.instant

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val Base_URL = "https://newsapi.org/"
const val API_KEY = "4fee228cf19049a2a016c4366f4c808a"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country: String, @Query("page") page: Int) : Call<News>
    // https://newsapi.org/v2/top-headlines?apiKey=$API_KEY&country=in&page=1

}

object NewsService{
    val newsInstance: NewsInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}