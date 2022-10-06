package com.example.mystore.data.firebase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mystore.data.models.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProductDataSource {
    private val db = Firebase.firestore

    fun getProductsInfo(): MutableLiveData<List<Product>>{
        val productLivedata = MutableLiveData<List<Product>>()

        db.collection("products")
            .get()
            .addOnSuccessListener { documents ->
                val listOfProducts: List<Product> = documents.toObjects(Product::class.java)
                productLivedata.value = listOfProducts


            }
            .addOnFailureListener { error ->
                Log.e("Firebase Error", error.message.toString())
            }

        return productLivedata
    }
}