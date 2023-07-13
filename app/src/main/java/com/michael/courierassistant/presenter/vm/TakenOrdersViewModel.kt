package com.michael.courierassistant.presenter.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michael.courierassistant.domain.model.OrderStatus
import com.michael.courierassistant.domain.usecase.CloseOrderUseCase
import com.michael.courierassistant.domain.usecase.GetTakenOrdersUseCase
import com.michael.courierassistant.presenter.model.OrderListItem
import com.michael.courierassistant.presenter.model.mapper.OrderListItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TakenOrdersViewModel(
    private val getTakenOrdersUseCase: GetTakenOrdersUseCase,
    private val closeOrderUseCase: CloseOrderUseCase,
    private val mapper: OrderListItemMapper
): ViewModel() {

    private val _orders = MutableLiveData<MutableList<OrderListItem>>(mutableListOf())
    val orders: LiveData<MutableList<OrderListItem>> = _orders

    fun fetchData(){
        getTakenOrdersUseCase.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {
                mapper.map(it)
            }.subscribe{
                if (_orders.value?.filter { order -> order.id == it.id }.isNullOrEmpty()){
                    _orders.value?.add(it)
                    _orders.notifyObserver()
                }
            }
    }

    fun onListItemButtonClick(position: Int){
        val order = _orders.value?.get(position)
        _orders.value?.get(position)?.status = when(order?.status){
            OrderStatus.Taken ->{
                closeOrderUseCase.execute(order.id.toInt())
                OrderStatus.Delivered
            }
            else -> OrderStatus.Delivered
        }
        _orders.notifyObserver()
    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }

}