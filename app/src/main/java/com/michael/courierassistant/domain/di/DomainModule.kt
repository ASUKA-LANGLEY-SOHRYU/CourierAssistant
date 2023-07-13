package com.michael.courierassistant.domain.di

import com.michael.courierassistant.domain.usecase.*
import org.koin.dsl.module

val domainModule = module{
    factory {
        GetAllOrdersUseCase(
            courierRepository = get()
        )
    }
    factory {
        TakeOrderUseCase(
            courierRepository = get()
        )
    }
    factory {
        CloseOrderUseCase(
            courierRepository = get()
        )
    }
    factory {
        GetTakenOrdersUseCase(
            courierRepository = get()
        )
    }
    factory {
        GetAvailableOrdersUseCase(
            courierRepository = get()
        )
    }
}