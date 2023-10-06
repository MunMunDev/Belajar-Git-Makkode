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

        setupViewModel()
    }

    fun setupViewModel(){
        viewModel = ViewModelProvider(this@DataActivity).get(DataViewModel::class.java)

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

}