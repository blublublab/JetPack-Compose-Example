package com.classicagames.myapplication.model.entity

import com.classicagames.myapplication.R

data class Card (
    val name : String,
    val amount : Int,
    val imageId : Int
    )

val cards = listOf(
    Card("Business", 134, R.drawable.item_interior),
    Card("Culinary", 121, R.drawable.item_interior),
    Card("Fashion", 161, R.drawable.item_interior),
    Card("Film", 55, R.drawable.item_interior),
    Card("Arts & Crafts", 34, R.drawable.item_interior),
    Card("Medicine", 25, R.drawable.item_interior),
    Card("TV", 98, R.drawable.item_interior),
    Card("Music", 48, R.drawable.item_interior),

    )



