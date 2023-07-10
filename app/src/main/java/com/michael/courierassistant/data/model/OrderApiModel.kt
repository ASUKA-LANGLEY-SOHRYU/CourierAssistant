package com.michael.courierassistant.data.model

data class OrderApiModel(
    val address: String,
    val comment: String,
    val customer: String,
    val id: String,
    val maxTime: Int,
    val price: String,
    val products: List<String>
)