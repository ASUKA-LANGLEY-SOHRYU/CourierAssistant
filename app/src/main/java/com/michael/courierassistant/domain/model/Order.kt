package com.michael.courierassistant.domain.model

data class Order(
    val id: String,
    val address: String,
    val comment: String,
    val maxTime: String,
    val status: OrderStatus
)
