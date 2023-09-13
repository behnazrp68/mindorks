package com.rajabi.test.sadadandroidtechnicalassignment.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rajabi.test.sadadandroidtechnicalassignment.R
import com.rajabi.test.sadadandroidtechnicalassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var factory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        val tenthCharacterLiveData = mainViewModel.getTenthCharacter()
        tenthCharacterLiveData.observe(this, Observer {
            binding.result10thChar.text = binding.result10thChar.text.toString() + " " + it
        })
        val everyTenthCharacterLiveData = mainViewModel.getEveryTenthCharacter()
        everyTenthCharacterLiveData.observe(this, Observer {
            binding.resultEvery10thChar.text = binding.resultEvery10thChar.text.toString() + " " + it
        })
    }
}