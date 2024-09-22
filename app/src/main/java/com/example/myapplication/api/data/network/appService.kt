package com.example.myapplication.api.data.network
import com.example.myapplication.api.data.model.NewsResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService
{
@GET("everything")
suspend fun getNews(@Query("q") query: String ,@Query("apiKey") apiKey: String): Response<NewsResponse>
}
object NewsApi{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(ApiService::class.java)
}