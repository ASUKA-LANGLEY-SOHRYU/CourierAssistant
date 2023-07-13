package com.michael.courierassistant.domain.di

import com.michael.courierassistant.domain.usecase.GetAllOrdersUseCase
import org.koin.dsl.module

val domainModule = module{
    factory {
        GetAllOrdersUseCase(
            courierRepository = get()
        )
    }
}