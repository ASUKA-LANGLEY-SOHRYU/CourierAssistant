package com.michael.courierassistant.data.di

import com.michael.courierassistant.data.datasource.OrdersHelper
import com.michael.courierassistant.data.model.mapper.OrderApiMapper
import com.michael.courierassistant.data.repository.CourierRepositoryImpl
import com.michael.courierassistant.domain.repository.ICourierRepository
import io.reactivex.Single
import org.koin.dsl.module

val dataModule = module {
    factory<ICourierRepository> {
        CourierRepositoryImpl(
            ordersHelper = get(),
            mapper = get()
        )
    }
    single { OrdersHelper() }
    single { OrderApiMapper() }
}
