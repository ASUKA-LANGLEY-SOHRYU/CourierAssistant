package com.michael.courierassistant.domain.repository

import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.domain.model.User
import com.michael.courierassistant.domain.model.UserRegistrationModel
import io.reactivex.Completable
import io.reactivex.Observable

interface ICourierRepository {

    fun registerUser(userRegistrationModel: UserRegistrationModel): Observable<User>

    fun getAllOrders(): Observable<Order>

    fun takeOrder(orderId: Int): Completable

    fun closeOrder(orderId: Int): Completable
}