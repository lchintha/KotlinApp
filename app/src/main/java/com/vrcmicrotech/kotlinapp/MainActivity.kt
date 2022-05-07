package com.vrcmicrotech.kotlinapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vrcmicrotech.kotlinapp.adapter.DataAdapter
import com.vrcmicrotech.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binder: ActivityMainBinding
    private lateinit var model: MainActivityViewModel
    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        model = ViewModelProvider(this)[MainActivityViewModel::class.java.toString(), MainActivityViewModel::class.java ]

        adapter = DataAdapter()
        binder.list.layoutManager = LinearLayoutManager(this)
        binder.list.adapter = adapter

        initObservers()
    }

    private fun initObservers(){
        displaySpinner()
        model.callService()

        model.result.observe(this) { repos ->
            adapter.updateData(repos.items)
            hideSpinner()
        }

    }

    private fun displaySpinner(){
        binder.progressBar.visibility = View.VISIBLE
    }

    private fun hideSpinner(){
        binder.progressBar.visibility = View.GONE
    }

}