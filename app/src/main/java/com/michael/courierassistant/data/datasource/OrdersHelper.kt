package com.michael.courierassistant.data.datasource

import com.michael.courierassistant.data.model.OrderApiModel
import com.michael.courierassistant.domain.model.OrderStatus

class OrdersHelper {

    private val data = listOf<OrderApiModel>(
        OrderApiModel("Екатеринбург, Ленина ул., 10", "", "1234", "12:33", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Коминтерна ул., 5", "", "234", "12:38", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Мира ул., 32", "", "457", "12:50", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Мира ул., 19", "", "7443", "12:55", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Мира ул., 20", "", "3477", "13:10", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Вайнера ул., 9", "", "37357", "13:34", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, 8 Марта ул., 46", "", "454", "13:47", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Ленина ул., 6", "", "963", "13:50", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Коминтера ул., 3", "", "947", "13:54", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Блюхера ул., 59", "", "843", "14:06", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Сыромолотова ул., 22", "", "8433", "15:03", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Фрунзе ул., 64", "", "883", "15:20", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Чапаева ул., 10", "", "3468", "15:40", OrderStatus.Waiting),
        OrderApiModel("Екатеринбург, Карла Маркса ул., 5", "", "2478", "20:34", OrderStatus.Waiting),
    )

    fun changeStatus(id: String, newStatus: OrderStatus){
        val order = data.find {
            it.id == id
        }
        order?.status = newStatus
    }

    fun getAllOrders(): List<OrderApiModel>{
        return data
    }
}