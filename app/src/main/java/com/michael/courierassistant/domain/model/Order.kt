package com.michael.courierassistant.domain.model

data class Order(
    val id: String,
    val address: String,
    val comment: String,
    val customer: String,
    val maxTime: Int,
    val price: String,
    val products: List<String>
)
