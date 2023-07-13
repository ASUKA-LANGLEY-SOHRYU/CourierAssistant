package com.michael.courierassistant.presenter.model

import com.michael.courierassistant.domain.model.OrderStatus

data class OrderListItem(
    val id: String,
    val maxTime: String,
    val address: String,
    var status: OrderStatus
)
