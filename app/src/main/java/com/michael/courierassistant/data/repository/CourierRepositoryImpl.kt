package com.michael.courierassistant.data.repository

import com.michael.courierassistant.data.datasource.OrdersHelper
import com.michael.courierassistant.data.model.mapper.OrderApiMapper
import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.domain.model.OrderStatus
import com.michael.courierassistant.domain.model.User
import com.michael.courierassistant.domain.model.UserRegistrationModel
import com.michael.courierassistant.domain.repository.ICourierRepository
import io.reactivex.Completable
import io.reactivex.Observable

class CourierRepositoryImpl(
    private val ordersHelper: OrdersHelper,
    private val mapper: OrderApiMapper
): ICourierRepository {
    override fun registerUser(userRegistrationModel: UserRegistrationModel): Observable<User> {
        return Observable.just(User(1, "abc"))
        //TODO("Not yet implemented")
    }

    override fun getAllOrders(): Observable<Order> {
        return Observable.fromIterable(ordersHelper.getAllOrders())
            .flatMap {
                Observable.just(mapper.map(it))
            }
    }

    override fun takeOrder(orderId: Int): Completable {
        ordersHelper.changeStatus(orderId.toString(), OrderStatus.Taken)
        return Completable.complete()
    }

    override fun closeOrder(orderId: Int): Completable {
        ordersHelper.changeStatus(orderId.toString(), OrderStatus.Delivered)
        return Completable.complete()
    }
}