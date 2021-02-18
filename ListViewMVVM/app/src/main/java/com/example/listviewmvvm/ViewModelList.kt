package com.example.listviewmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ViewModelList:ViewModel()
{
   var aplicallist: ApiCalllist? = null
  var  mutablelivelist:MutableLiveData<List<Listmodel>>? = null


    init {
        aplicallist = ApiCalllist()
    }

     fun getListdata(): LiveData<List<Listmodel>>
     {
        if (mutablelivelist == null)
        {
              mutablelivelist = aplicallist!!.fetchlist()
        }

         return mutablelivelist!!
     }

    fun changedata(): MutableLiveData<List<Listmodel>>? {
        val holidayModel = Listmodel()
        holidayModel.date = "hfsdjfh"
        holidayModel.name = "47236fl"
        val list: MutableList<Listmodel> = ArrayList<Listmodel>()
        list.add(holidayModel)

        if (mutablelivelist != null)
        {
            mutablelivelist!!.value = list
        }
        return mutablelivelist
    }

}