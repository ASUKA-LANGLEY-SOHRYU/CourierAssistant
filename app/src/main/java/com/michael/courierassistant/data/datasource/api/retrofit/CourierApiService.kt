package com.michael.courierassistant.data.datasource.api.retrofit

import com.michael.courierassistant.data.model.OrderApiModel
import io.reactivex.Observable
import retrofit2.http.GET

interface CourierApiService {

    @GET("/api/orders")
    fun getAllOrders(): Observable<OrderApiModel>
}