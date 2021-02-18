package com.example.listviewmvvm

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Tag
import javax.security.auth.callback.Callback

class ApiCalllist
{
val TAG = javaClass.simpleName

fun fetchlist():MutableLiveData<List<Listmodel>>
{

   var mutablelsit:MutableLiveData<List<Listmodel>> = MutableLiveData()

   val apiinterface = Application.getRetrofit().create(Apiinterface::class.java)

    apiinterface.getlist().enqueue(object :retrofit2.Callback<List<Listmodel>> {
        override fun onResponse(call: Call<List<Listmodel>>, response: Response<List<Listmodel>>) {
            if (response.body() != null && response.body()?.size!! > 0) {
                mutablelsit.value = response.body()!!

            }
        }

        override fun onFailure(call: Call<List<Listmodel>>, t: Throwable) {
            TODO("Not yet implemented")
        }
    })

    return mutablelsit
    }



   // return mutablelsit
}


