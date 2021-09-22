package com.example.newsapplicationv1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeadlineFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_headline, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getNews()
    }

    private fun getNews() {
        val apiKey = "YourApi key"
        val request = newsApiHit.getNewsInstance().getHeadlines("in" , apiKey)
        request.enqueue(NewsCallBack())

    }

    inner class NewsCallBack : Callback<Headline> {
        override fun onResponse(call: Call<Headline>, response: Response<Headline>) {
            Log.d("HeadLine" , "news are ${response.body()}")
            if(response.isSuccessful){
                Log.d("HeadLine" , "news are ${response.body()}" )
            }
        }

        override fun onFailure(call: Call<Headline>, t: Throwable) {
            Log.d("HeadLineii" , "news are ${t.message}" )
        }

    }

}

