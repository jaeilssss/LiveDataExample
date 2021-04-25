package com.example.mvvmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var model : MainViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        model = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.model = model


        var adapter = Adapter(ArrayList())

        binding.rcv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.rcv.adapter = adapter
        binding.btn.setOnClickListener {
                model.create()
        }
        model.listItem.observe(this , Observer {
            adapter.resetting(model.listItem.value!!)
        })

    }
}