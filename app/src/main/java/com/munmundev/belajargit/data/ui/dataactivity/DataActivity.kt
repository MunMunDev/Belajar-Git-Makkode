package com.munmundev.belajargit.data.ui.dataactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.munmundev.belajargit.R
import com.munmundev.belajargit.data.database.api.ApiConfig
import com.munmundev.belajargit.data.model.ApiModel
import com.munmundev.belajargit.databinding.ActivityDataBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataActivity : AppCompatActivity() {
    private val TAG = "DataActivityTAG"
    lateinit var binding: ActivityDataBinding
    lateinit var viewModel: DataViewModel
    lateinit var array: ArrayList<ApiModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        data()

        viewModel = ViewModelProvider(this@DataActivity).get(DataViewModel::class.java)

//        viewModel.getData().observe(this@DataActivity, Observer {
//            Log.d("DataActivityTAG", "jumlah Data: ${it.size}")
//            var data = ""
//            for (value in it){
//                data+="-"
//                data+="nama -${value.nama} - "
//                data+="alamat${value.alamat} - "
//                data+="nomor -${value.nomor} - "
//                data+="\n"
//            }
//            binding.txtNumber.text = data
//        })

        viewModel.getData().observe(this@DataActivity, Observer {
            var data = ""
            for (value in it){
                data+="nama -${value.nama} - "
                data+="alamat${value.status} "
                data+="\n"
            }
            binding.txtNumber.text = data
        })

        binding.btnTambah.setOnClickListener {
            viewModel.setData()
        }
    }

    fun data(){
        array = arrayListOf()

        ApiConfig.getRetrofit().getData()
            .enqueue(object : Callback<ArrayList<ApiModel>>{
                override fun onResponse(
                    call: Call<ArrayList<ApiModel>>,
                    response: Response<ArrayList<ApiModel>>
                ) {
                    if(response.body()!!.isNotEmpty()){
                        array = response.body()!!
                        Log.d(TAG, "onResponse: size: ${array.size} \ndata: ${array[0].nama}")
                    }
                    else{
                        Log.d(TAG, "onResponse: Tidak Ada Isinya")
                    }
                }

                override fun onFailure(call: Call<ArrayList<ApiModel>>, t: Throwable) {
                    Log.d(TAG, "onFailure: gagal: ${t.message}")
                }

            })
    }
}