package com.example.newsapplicationv1

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class  NewsAdapter(val newsList : List<TopNew>) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    inner class NewsHolder(view :View): RecyclerView.ViewHolder(view) {
        val newsImage = view.findViewById<ImageView>(R.id.newsImage)
        val newsHeadline = view.findViewById<TextView>(R.id.headlineTV)
        val newsDescription  = view.findViewById<TextView>(R.id.descriptionTV)
        val cvBackGroundChange = view.findViewById<CardView>(R.id.cardViewIs)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.headline_item , parent , false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val currentItem = newsList[position]
        holder.newsHeadline.text = currentItem.title
        holder.newsDescription.text = currentItem.description

        Glide.with(holder.itemView).load(currentItem.urlToImage).into(holder.newsImage)
        val colorArray  = arrayListOf(Color.RED , Color.BLUE , Color.DKGRAY , Color.GRAY ,Color.MAGENTA ,Color.YELLOW)
        val randomColor = (0..5).random()
        holder.cvBackGroundChange.setCardBackgroundColor(colorArray[randomColor])

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}