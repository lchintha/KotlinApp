package com.vrcmicrotech.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.vrcmicrotech.kotlinapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binder: ActivityMainBinding
    private lateinit var model: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        model.result.observe(this, {
            binder.text.text = it
            binder.text.visibility = View.VISIBLE
            hideSpinner()
        })


    }

    override fun onPause() {
        super.onPause()

    }

    fun displayData(view: android.view.View) {
        model.callService()
        displaySpinner()
    }

    private fun displaySpinner(){
        binder.progressBar.visibility = View.VISIBLE
    }

    private fun hideSpinner(){
        binder.progressBar.visibility = View.GONE
    }

}