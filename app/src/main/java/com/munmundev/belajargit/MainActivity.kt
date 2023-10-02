package com.munmundev.belajargit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.munmundev.belajargit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: TestViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)

        println("Commit Pertama")

        taskSecondBranch()
        updateTaskThirdBranch()
        taskBelajarGit()


        // Learned Live Data
        viewModel = ViewModelProvider(this).get(TestViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            binding.tvNumber.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            binding.tvBoolean.text = it.toString()
        })

        learnedLiveData()
    }

    private fun taskSecondBranch(){
        println("second branch")
    }

    private fun updateTaskThirdBranch(){
        println("Update TaskThirdBranch")
    }

    private fun taskBelajarGit(){
        println("STUDY GITHUB")
    }

    private fun learnedLiveData(){
        binding.btnTambah.setOnClickListener{
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 == 0
        }
    }

}