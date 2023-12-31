package com.michael.courierassistant.presenter.vm

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.michael.courierassistant.domain.model.Order
import com.michael.courierassistant.domain.model.OrderStatus
import com.michael.courierassistant.domain.usecase.CloseOrderUseCase
import com.michael.courierassistant.domain.usecase.GetAllOrdersUseCase
import com.michael.courierassistant.domain.usecase.GetAvailableOrdersUseCase
import com.michael.courierassistant.domain.usecase.TakeOrderUseCase
import com.michael.courierassistant.presenter.model.OrderListItem
import com.michael.courierassistant.presenter.model.mapper.OrderListItemMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.FieldPosition

class AvailableOrdersViewModel(
    private val getAvailableOrdersUseCase: GetAvailableOrdersUseCase,
    private val takeOrderUseCase: TakeOrderUseCase,
    private val closeOrderUseCase: CloseOrderUseCase,
    private val mapper: OrderListItemMapper
): ViewModel() {

    private val _orders = MutableLiveData<MutableList<OrderListItem>>(mutableListOf())
    val orders: LiveData<MutableList<OrderListItem>> = _orders

    init {
        fetchData()
    }

    fun fetchData(){
        getAvailableOrdersUseCase.execute()
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
        when(order?.status){
            OrderStatus.Waiting -> {
                takeOrderUseCase.execute(order.id.toInt())
            }
            OrderStatus.Taken ->{
                closeOrderUseCase.execute(order.id.toInt())
            }
            else -> {}
        }
        _orders.value?.removeAt(position)
    }

    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}