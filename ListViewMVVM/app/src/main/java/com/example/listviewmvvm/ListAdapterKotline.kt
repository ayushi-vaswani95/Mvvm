package com.example.listviewmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.listviewmvvm.databinding.ItemHolidayKotlinBinding

class ListAdapterKotline() :RecyclerView.Adapter<ListAdapterKotline.ViewHolder>()
{
     var dataList : List<Listmodel>

    init {
        dataList = ArrayList()
    }

    fun addData(arrList: List<Listmodel>)
    {
        this.dataList = arrList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHolidayKotlinBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_holiday_kotlin, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(val binding: ItemHolidayKotlinBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(1, data)
            binding.executePendingBindings()
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList.get(position))
    }

}