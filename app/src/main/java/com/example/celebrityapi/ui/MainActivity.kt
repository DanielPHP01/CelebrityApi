package com.example.celebrityapi.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.celebrityapi.MainViewModel
import com.example.celebrityapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private lateinit var adapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        initRV()
    }

    private fun initRV() {
        adapter = Adapter()
        binding.recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initViews() {
        with(binding) {
            btnGet.setOnClickListener {
                viewModel.getInfo(etName.text.toString()).observe(this@MainActivity, Observer { result ->
                    adapter.list = result
                    adapter.notifyDataSetChanged()
                })
            }
        }
    }
}
