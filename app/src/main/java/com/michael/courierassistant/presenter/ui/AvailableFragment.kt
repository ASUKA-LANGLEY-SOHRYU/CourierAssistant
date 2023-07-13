package com.michael.courierassistant.presenter.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.michael.courierassistant.databinding.FragmentAvailableBinding
import com.michael.courierassistant.presenter.adapter.OrdersListAdapter
import com.michael.courierassistant.presenter.adapter.SpaceItemDecorator
import com.michael.courierassistant.presenter.model.OrderListItem
import com.michael.courierassistant.presenter.vm.AvailableOrdersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AvailableFragment : Fragment() {

    private lateinit var binding: FragmentAvailableBinding
    private lateinit var adapter: OrdersListAdapter

    private val vm by viewModel<AvailableOrdersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAvailableBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeLiveData()
    }

    private fun initRecyclerView(){
        adapter = OrdersListAdapter()
        adapter.setOnButtonClickListener(object : OrdersListAdapter.OnButtonClickListener{
            override fun onButtonClick(position: Int) {
                //TODO("Not yet implemented")
            }
        })
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(SpaceItemDecorator(22))
    }

    private fun observeLiveData(){
        vm.orders.observe(viewLifecycleOwner){
            adapter.setOrders(it)
            Log.e("ABCCBA", adapter.itemCount.toString())
        }
    }

}