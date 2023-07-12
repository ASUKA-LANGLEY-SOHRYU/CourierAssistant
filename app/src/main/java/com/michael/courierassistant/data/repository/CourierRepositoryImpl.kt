package com.michael.courierassistant.data.repository

import com.michael.courierassistant.data.datasource.api.retrofit.CourierApiService
import com.michael.courierassistant.data.model.mapper.OrderApiMapper
import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.domain.model.User
import com.michael.courierassistant.domain.model.UserRegistrationModel
import com.michael.courierassistant.domain.repository.ICourierRepository
import io.reactivex.Completable
import io.reactivex.Observable

class CourierRepositoryImpl(
    private val apiService: CourierApiService,
    private val mapper: OrderApiMapper
): ICourierRepository {
    override fun registerUser(userRegistrationModel: UserRegistrationModel): Observable<User> {
        return Observable.just(User(1, "abc"))
        //TODO("Not yet implemented")
    }

    override fun getAllOrders(): Observable<Order> {
        return apiService.getAllOrders().map {
            mapper.map(it)
        }
    }

    override fun takeOrder(orderId: Int): Completable {
        return Completable.complete()
        //TODO("Not yet implemented")
    }

    override fun closeOrder(orderId: Int): Completable {
        return Completable.complete()
        //TODO("Not yet implemented")
    }
}