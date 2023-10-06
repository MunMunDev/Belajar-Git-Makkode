package com.munmundev.belajargit.data.ui.dataactivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.munmundev.belajargit.data.database.api.ApiConfig
import com.munmundev.belajargit.data.model.ApiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataViewModel: ViewModel() {
    private val TAG = "DataViewModelTAG"
    var arrayData: ArrayList<ApiModel> = arrayListOf()
    private var _arrayData = MutableLiveData<ArrayList<ApiModel>>()

    fun setData(){

        ApiConfig.getRetrofit().getData("","user","user")
            .enqueue(object : Callback<ArrayList<ApiModel>>{
                override fun onResponse(
                    call: Call<ArrayList<ApiModel>>,
                    response: Response<ArrayList<ApiModel>>
                ) {
                    if(response.body()!!.isNotEmpty()){
                        arrayData = response.body()!!
                        _arrayData.value = arrayData

                        Log.d(TAG, "onResponse: ${arrayData.size}")
                    }
                    else{
                        Log.d(TAG, "onResponse: tidak ada data")
                    }
                }

                override fun onFailure(call: Call<ArrayList<ApiModel>>, t: Throwable) {
                    Log.d(TAG, "onFailure: gagal: ${t.message}")
                }

            })


//        arrayData.add(ApiModel("1", "Nama", "Alamat", "089"))
//        _arrayData.value = arrayData
    }

    fun getData(): LiveData<ArrayList<ApiModel>>{
        return _arrayData
    }
}