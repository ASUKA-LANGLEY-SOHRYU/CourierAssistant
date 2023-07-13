package com.michael.courierassistant.presenter.model.mapper

import com.michael.courierassistant.app.core.mapper.IMapper
import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.presenter.model.OrderListItem
import com.michael.courierassistant.presenter.model.OrderStatus

class OrderListItemMapper: IMapper<Order, OrderListItem> {
    override fun map(input: Order): OrderListItem {
        return OrderListItem(
            id = input.id,
            maxTime = input.maxTime,
            address = input.address,
            status = OrderStatus.Waiting
        )
    }
}