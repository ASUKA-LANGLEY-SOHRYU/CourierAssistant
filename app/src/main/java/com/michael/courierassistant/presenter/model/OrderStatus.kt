package com.michael.courierassistant.presenter.model

enum class OrderStatus(val status: String) {
    Taken("Забрал заказ"),
    Delivered("Отдал заказ"),
    Waiting("Взять в работу"),
}