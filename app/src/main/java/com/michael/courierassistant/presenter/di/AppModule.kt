package com.michael.courierassistant.presenter.di

import com.michael.courierassistant.presenter.model.mapper.OrderListItemMapper
import com.michael.courierassistant.presenter.vm.AvailableOrdersViewModel
import com.michael.courierassistant.presenter.vm.TakenOrdersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AvailableOrdersViewModel(
            getAvailableOrdersUseCase = get(),
            takeOrderUseCase = get(),
            closeOrderUseCase = get(),
            mapper = get()
        )
    }
    viewModel {
        TakenOrdersViewModel(
            getTakenOrdersUseCase = get(),
            closeOrderUseCase = get(),
            mapper = get()
        )
    }
    single { OrderListItemMapper() }
}