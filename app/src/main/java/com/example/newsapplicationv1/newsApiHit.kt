package com.example.newsapplicationv1


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY


interface newsApiHit {

    @GET("top-headlines")
    fun getHeadlines(@Query("country") country : String ,@Query("apiKey") key :String) : Call<Headline>

    companion object{
        private val BASE_URL = "https://newsapi.org/v2/"

        fun getNewsInstance() : newsApiHit{
            val builder = Retrofit.Builder()
            builder.baseUrl(BASE_URL)
            builder.addConverterFactory(GsonConverterFactory.create())

            val retrofitObj = builder.build()

            return retrofitObj.create(newsApiHit::class.java)

        }
    }


}