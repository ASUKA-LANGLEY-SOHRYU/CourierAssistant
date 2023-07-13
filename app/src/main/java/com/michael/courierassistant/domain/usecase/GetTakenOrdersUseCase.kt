package com.michael.courierassistant.domain.usecase

import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.domain.model.OrderStatus
import com.michael.courierassistant.domain.repository.ICourierRepository
import io.reactivex.Observable

class GetTakenOrdersUseCase(private val courierRepository: ICourierRepository) {
    fun execute(): Observable<Order> {
        return courierRepository.getAllOrders().filter {
            it.status != OrderStatus.Waiting
        }
    }
}