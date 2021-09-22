package com.example.newsapplicationv1

data class Headline(val articles : List<TopNew>)

data class TopNew(
    val source : itemName,
    val author : String  ,
    val title : String  ,
    val description : String  ,
    val publishedAt : String  ,
    val content : String  ,
)
data class itemName(
    val name :  String
)





