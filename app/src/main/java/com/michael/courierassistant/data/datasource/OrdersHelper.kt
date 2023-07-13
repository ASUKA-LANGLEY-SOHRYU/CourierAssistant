package com.michael.courierassistant.data.datasource

import com.michael.courierassistant.data.model.OrderApiModel

class OrdersHelper {

    private val data = listOf<OrderApiModel>(
        OrderApiModel("Екатеринбург, Ленина ул., 10", "", "1234", "12:33"),
        OrderApiModel("Екатеринбург, Коминтерна ул., 5", "", "234", "12:38"),
        OrderApiModel("Екатеринбург, Мира ул., 32", "", "457", "12:50"),
        OrderApiModel("Екатеринбург, Мира ул., 19", "", "7443", "12:55"),
        OrderApiModel("Екатеринбург, Мира ул., 20", "", "3477", "13:10"),
        OrderApiModel("Екатеринбург, Вайнера ул., 9", "", "37357", "13:34"),
        OrderApiModel("Екатеринбург, 8 Марта ул., 46", "", "454", "13:47"),
        OrderApiModel("Екатеринбург, Ленина ул., 6", "", "963", "13:50"),
        OrderApiModel("Екатеринбург, Коминтера ул., 3", "", "947", "13:54"),
        OrderApiModel("Екатеринбург, Блюхера ул., 59", "", "843", "14:06"),
        OrderApiModel("Екатеринбург, Сыромолотова ул., 22", "", "8433", "15:03"),
        OrderApiModel("Екатеринбург, Фрунзе ул., 64", "", "883", "15:20"),
        OrderApiModel("Екатеринбург, Чапаева ул., 10", "", "3468", "15:40"),
        OrderApiModel("Екатеринбург, Карла Маркса ул., 5", "", "2478", "20:34"),
    )

    fun getAllOrders(): List<OrderApiModel>{
        return data
    }
}