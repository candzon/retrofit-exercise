package com.exercise.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.exercise.retrofitapp.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.text)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                textView.text = response.body()?.userId.toString()!!
                Log.d("Response", response.body()?.id.toString())
                textView.text = response.body()?.id.toString()!!
                textView.text = response.body()?.body!!
                Log.d("Response", response.body()?.body!!)

            } else {
                Log.d("Response", response.errorBody().toString())
                textView.text = response.code().toString()
            }

        })
    }
}