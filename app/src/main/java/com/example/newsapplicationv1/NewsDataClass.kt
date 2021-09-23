package com.example.newsapplicationv1

data class Headline(val articles : List<TopNew>)

data class TopNew(
    val source : ItemName,
    val author : String  ,
    val title : String  ,
    val description : String  ,
    val publishedAt : String  ,
    val urlToImage : String ,
    val content : String  ,
)
data class ItemName(
    val name :  String
)





