package com.michael.courierassistant.data.model

import com.michael.courierassistant.domain.model.OrderStatus

data class OrderApiModel(
    val address: String,
    val comment: String,
    val id: String,
    val maxTime: String,
    var status: OrderStatus
)