package com.michael.courierassistant.presenter.di

import com.michael.courierassistant.presenter.model.mapper.OrderListItemMapper
import com.michael.courierassistant.presenter.vm.AvailableOrdersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AvailableOrdersViewModel(
            getAllOrdersUseCase = get(),
            mapper = OrderListItemMapper()
        )
    }
}