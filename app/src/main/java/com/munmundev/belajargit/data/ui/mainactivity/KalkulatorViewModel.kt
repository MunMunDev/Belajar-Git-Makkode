package com.munmundev.belajargit.data.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KalkulatorViewModel: ViewModel() {
    private var _nilai1 = MutableLiveData<Int>()
    private var _nilai2 = MutableLiveData<Int>()
    private var _hasil = MutableLiveData<Int>()

    fun getNilai1(): LiveData<Int>{
        return _nilai1
    }

    fun getNilai2(): LiveData<Int>{
        return _nilai2
    }

    fun getHasil(): LiveData<Int>{
        return _hasil
    }

    fun setNilai1(nilai1: String, nilai2: String){
        this._nilai1.value = nilai1.toInt()
        this._nilai2.value = nilai2.toInt()

        this._hasil.value = nilai1.toInt()+nilai2.toInt()
    }
}