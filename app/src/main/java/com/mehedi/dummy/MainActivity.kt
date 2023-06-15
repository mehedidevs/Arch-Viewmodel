package com.mehedi.dummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mehedi.dummy.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val viewModel: CounterViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //task1
        binding = ActivityMainBinding.inflate(layoutInflater)

        //task2
        setContentView(binding.root)

        Log.i("TAG", "1. Thread Name :${Thread.currentThread().name} ")

        viewModel.counterMutableLiveData.observe(this@MainActivity) {

            binding.incrementedValue.text = "$it"

        }


        //task3
        binding.increment.setOnClickListener {

            viewModel.increment()




        }


    }
}