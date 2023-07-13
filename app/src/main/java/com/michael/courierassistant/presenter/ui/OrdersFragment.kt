package com.michael.courierassistant.presenter.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.michael.courierassistant.R
import com.michael.courierassistant.databinding.FragmentOrdersBinding
import com.michael.courierassistant.domain.model.OrderStatus
import com.michael.courierassistant.presenter.adapter.OrdersListAdapter
import com.michael.courierassistant.presenter.adapter.SpaceItemDecorator
import com.michael.courierassistant.presenter.model.OrderListItem
import com.michael.courierassistant.presenter.vm.TakenOrdersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrdersFragment : Fragment() {

    private lateinit var binding: FragmentOrdersBinding
    private lateinit var adapter: OrdersListAdapter

    private val vm by viewModel<TakenOrdersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrdersBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeLiveData()
    }

    override fun onResume() {
        super.onResume()
        vm.fetchData()
    }

    private fun initRecyclerView(){
        adapter = OrdersListAdapter()
        adapter.setOnButtonClickListener(object : OrdersListAdapter.OnButtonClickListener{
            override fun onButtonClick(position: Int) {
                vm.onListItemButtonClick(position)
            }
        })
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(SpaceItemDecorator(22))
    }

    private fun observeLiveData(){
        vm.orders.observe(viewLifecycleOwner){
            adapter.setOrders(it)
            if (adapter.itemCount > 0){
                binding.recyclerView.visibility = View.VISIBLE
                binding.banner.visibility = View.GONE
            } else {
                binding.recyclerView.visibility = View.GONE
                binding.banner.visibility = View.VISIBLE
            }
        }
    }

}