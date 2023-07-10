package com.michael.courierassistant.domain.usecase

import com.michael.courierassistant.domain.repository.ICourierRepository
import io.reactivex.Completable

class TakeOrderUseCase(val courierRepository: ICourierRepository) {
    fun execute(orderId: Int): Completable{
        return courierRepository.takeOrder(orderId)
    }
}