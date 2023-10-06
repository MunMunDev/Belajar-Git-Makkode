package com.munmundev.belajargit.data.ui.mainactivity

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestViewModel: ViewModel() {
    private lateinit var timer: CountDownTimer

    private val _seconds = MutableLiveData<Int>()
    private val _check = MutableLiveData<Boolean>()

    fun seconds():LiveData<Int>{
        return _seconds
    }

    fun check():LiveData<Boolean>{
        return _check
    }

    fun startTimer(){
        Log.d("MainActivityTAG1", "startTimer: bbbb")
        timer = object: CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished/1000
                _seconds.value = timeLeft.toInt()

            }

            override fun onFinish() {
                _check.value = true
                stopTimer()
            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel()
    }
}