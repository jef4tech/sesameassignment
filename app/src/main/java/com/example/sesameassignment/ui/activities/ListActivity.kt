package com.example.sesameassignment.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sesameassignment.ViewModel.CustomerViewModel
import com.example.sesameassignment.databinding.ActivityCustomersBinding
import com.example.sesameassignment.ui.adapter.CustomerAdapter

class ListActivity : AppCompatActivity(){

    private lateinit var customerViewModel: CustomerViewModel
    private lateinit var adapter: CustomerAdapter
    private lateinit var binding:ActivityCustomersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customerViewModel = ViewModelProvider(this)[CustomerViewModel::class.java]
        setupUI()
        setupViewModel()
    }

    private fun setupUI() {

        customerViewModel.getAllCustomers()
        adapter = CustomerAdapter{position -> onClick(position)}
        binding.customerRecyclerView.adapter = adapter
        binding.customerRecyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    private fun onClick(position: Int) {

    }

    private fun setupViewModel() {
        customerViewModel.customers.observe(this){
            adapter.setData(it)
        }
    }
}