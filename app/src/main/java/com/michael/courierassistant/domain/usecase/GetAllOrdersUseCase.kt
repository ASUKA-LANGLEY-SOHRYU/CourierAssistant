package com.michael.courierassistant.domain.usecase

import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.domain.repository.ICourierRepository
import io.reactivex.Observable

class GetAllOrdersUseCase(private val courierRepository: ICourierRepository) {
    fun execute(): Observable<Order>{
        return courierRepository.getAllOrders()
    }
}