package com.michael.courierassistant.presenter.model

data class OrderListItem(
    val id: String,
    val maxTime: String,
    val address: String,
    val status: OrderStatus
)
