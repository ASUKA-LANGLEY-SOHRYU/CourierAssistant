package com.michael.courierassistant.presenter.vm

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.domain.usecase.GetAllOrdersUseCase
import com.michael.courierassistant.presenter.model.OrderListItem
import com.michael.courierassistant.presenter.model.mapper.OrderListItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AvailableOrdersViewModel(
    private val getAllOrdersUseCase: GetAllOrdersUseCase,
    private val mapper: OrderListItemMapper
): ViewModel() {

    private val _orders = MutableLiveData<MutableList<OrderListItem>>(mutableListOf())
    val orders: LiveData<MutableList<OrderListItem>> = _orders

    init {
        Log.e("AABBBCCCC", "gfsgherhewerhwrhwrh")
        getAllOrdersUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {
                mapper.map(it)
            }.subscribe{
                _orders.value?.add(it)
                _orders.notifyObserver()
            }

    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}