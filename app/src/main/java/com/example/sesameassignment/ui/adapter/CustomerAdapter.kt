package com.example.sesameassignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sesameassignment.databinding.CustomerdetailBinding
import com.example.sesameassignment.model.Cust
import com.example.sesameassignment.model.Customer


class CustomerAdapter(private val listener: (position: Int) -> Unit): RecyclerView.Adapter<CustomerAdapter.customerViewHolder>() {
    private var customerList:List<Cust> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): customerViewHolder {
        val itemBinding = CustomerdetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return customerViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return customerList.size
//        return 5
    }

    override fun onBindViewHolder(holder: customerViewHolder, position: Int) {
        val customer = customerList[position]
//        holder.custombind.itemName.text=customer.custName
        holder.custombind.apply {
            itemName.text=customer.custName
            itemCity.text=customer.custAddress
            itemPhone.text=customer.phoneNo

        }
//        holder.custombind.ItemCategory.text = category.categoryName
//        Extensions.loadImagefromUrl(holder.custombind.teamimage.context,holder.custombind.teamimage, team.team.logo)
//        holder.custombind.cardView.setOnClickListener {
//            listener(team.team.id)
//        }

    }

    inner class customerViewHolder(val custombind:CustomerdetailBinding):RecyclerView.ViewHolder(custombind.root)

    fun setData(customer: Customer) {
//        this.categoryList=categoryList
        this.customerList=customer.custList
        notifyDataSetChanged()
    }
}