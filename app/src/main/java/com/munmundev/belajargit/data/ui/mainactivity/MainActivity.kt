package com.munmundev.belajargit.data.ui.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.munmundev.belajargit.data.ui.dataactivity.DataActivity
import com.munmundev.belajargit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    lateinit var viewModel: TestViewModel
    lateinit var kalkulatorViewModel: KalkulatorViewModel
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


//        viewNormal()
//        viewModel()

        gabung()

        binding.btnPindah.setOnClickListener {
            startActivity(Intent(this@MainActivity, DataActivity::class.java))
        }

    }

    fun gabung(){
        kalkulatorViewModel = ViewModelProvider(this@MainActivity).get(KalkulatorViewModel::class.java)

        binding.apply {
            btnHasil.setOnClickListener {
                if(etNilai1.text.isEmpty()){
                    etNilai1.error = "Masukkan Nilai 1"
                }
                else if(etNilai2.text.isEmpty()){
                    etNilai2.error = "Masukkan Nilai 2"
                }
                else{
                    tvHasilNilai1.text = "Hasil Nilai 1: \n ${etNilai1.text.toString()}"
                    tvHasilNilai2.text = "Hasil Nilai 2: \n ${etNilai2.text.toString()}"
                    val hasil = etNilai1.text.toString().toInt()+etNilai2.text.toString().toInt()
                    tvHasilHasil.text = "Hasil: \n ${hasil.toString()}"

                    //ViewModel
                    kalkulatorViewModel.setNilai1(etNilai1.text.toString(), etNilai2.text.toString())
                }
            }
            kalkulatorViewModel.getNilai1().observe(this@MainActivity, Observer{
                tvVmNilai1.text = "Hasil Nilai 1: \n${it.toString()}"
            })
            kalkulatorViewModel.getNilai2().observe(this@MainActivity, Observer{
                tvVmNilai2.text = "Hasil Nilai 2: \n${it.toString()}"
            })
            kalkulatorViewModel.getHasil().observe(this@MainActivity, Observer{
                tvVmHasil.text = "Total Nilai \n${it.toString()}"
            })

        }
    }

    fun viewNormal(){
        binding.apply {
            btnHasil.setOnClickListener {
                if(etNilai1.text.isEmpty()){
                    etNilai1.error = "Masukkan Nilai 1"
                }
                else if(etNilai2.text.isEmpty()){
                    etNilai2.error = "Masukkan Nilai 2"
                }
                else{
                    tvHasilNilai1.text = "Hasil Nilai 1: \n ${etNilai1.text.toString()}"
                    tvHasilNilai2.text = "Hasil Nilai 2: \n ${etNilai2.text.toString()}"
                    val hasil = etNilai1.text.toString().toInt()+etNilai2.text.toString().toInt()
                    tvHasilHasil.text = "Hasil: \n ${hasil.toString()}"
                }
            }

        }
    }

    fun viewModel(){
        kalkulatorViewModel = ViewModelProvider(this@MainActivity).get(KalkulatorViewModel::class.java)

        binding.apply {
            btnHasil.setOnClickListener {
                if(etNilai1.text.isEmpty()){
                    etNilai1.error = "Masukkan Nilai 1"
                }
                else if(etNilai2.text.isEmpty()){
                    etNilai2.error = "Masukkan Nilai 2"
                }
                else{
                    kalkulatorViewModel.setNilai1(etNilai1.text.toString(), etNilai2.text.toString())
                }
            }
            kalkulatorViewModel.getNilai1().observe(this@MainActivity, Observer{
                tvVmNilai1.text = "Hasil Nilai 1: \n${it.toString()}"
            })
            kalkulatorViewModel.getNilai2().observe(this@MainActivity, Observer{
                tvVmNilai2.text = "Hasil Nilai 2: \n${it.toString()}"
            })
            kalkulatorViewModel.getHasil().observe(this@MainActivity, Observer{
                tvVmHasil.text = "Total Nilai \n${it.toString()}"
            })
        }
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

}