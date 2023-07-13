package com.michael.courierassistant.data.model.mapper

import com.michael.courierassistant.app.core.mapper.IMapper
import com.michael.courierassistant.data.model.OrderApiModel
import com.michael.courierassistant.domain.model.Order

class OrderApiMapper: IMapper<OrderApiModel, Order> {
    override fun map(input: OrderApiModel): Order {
        return Order(
            input.id,
            input.address,
            input.comment,
            input.maxTime,
        )
    }
}