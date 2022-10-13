package com.example.mystore.data.favourite_provider

interface FavouriteProvider {
    fun addFavorite(productId: String)

    fun removeFavorite(productId: String)

    fun isFavorite(productId: String): Boolean

    fun getFavoriteItems(): List<String>
}