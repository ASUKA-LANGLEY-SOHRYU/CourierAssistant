package com.michael.courierassistant.presenter.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.michael.courierassistant.R
import com.michael.courierassistant.databinding.OrderListItemBinding
import com.michael.courierassistant.presenter.model.OrderListItem

class OrdersListAdapter: RecyclerView.Adapter<OrdersListAdapter.OrdersListViewHolder>() {

    private var orders: MutableList<OrderListItem> = mutableListOf()

    fun setOrders(value: MutableList<OrderListItem>) {
        this.orders = value
        notifyItemChanged(0)
        notifyDataSetChanged()
    }

    private lateinit var onButtonClickListener: OnButtonClickListener

    interface OnButtonClickListener {
        fun onButtonClick(position: Int)
    }

    fun setOnButtonClickListener(listener: OnButtonClickListener) {
        onButtonClickListener = listener
    }

    inner class OrdersListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = OrderListItemBinding.bind(view)


        fun bind(order: OrderListItem) {
            binding.apply {
                maxTime.text = "Доставить до ${order.maxTime}"
                orderId.text = "Заказ №${order.id}"
                address.text = order.address
                button.text = order.status.status

                button.setOnClickListener {
                    onButtonClickListener.onButtonClick(layoutPosition)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrdersListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.order_list_item, parent, false)
        return OrdersListViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrdersListViewHolder, position: Int) {
        holder.bind(orders[position])
    }

    override fun getItemCount(): Int = orders.size
}