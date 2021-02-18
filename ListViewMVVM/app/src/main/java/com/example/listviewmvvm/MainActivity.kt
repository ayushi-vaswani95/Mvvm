package com.example.listviewmvvm

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listviewmvvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var ListAdapterKotline : ListAdapterKotline
    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.listview.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        binding.listview.layoutManager = layoutManager
        binding.listview.itemAnimator = DefaultItemAnimator()

        ListAdapterKotline = ListAdapterKotline()
        binding.listview.adapter = ListAdapterKotline

         val  viewModelList = ViewModelList()

        binding.clickme.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
               viewModelList.changedata()
            }
        })

        viewModelList.getListdata().observe(this,object : Observer<List<Listmodel>>
        {

            override fun onChanged(t: List<Listmodel>?) {
                Log.e(TAG, "observe onChanged()="+t?.size )
                binding.progressbar.setVisibility(View.GONE)
                ListAdapterKotline.addData(t!!)
                ListAdapterKotline.notifyDataSetChanged()
            }

        })
    }
}

      private fun Any.observe(mainActivity: MainActivity, observer: Observer<List<ViewModelList>>) {

      }
