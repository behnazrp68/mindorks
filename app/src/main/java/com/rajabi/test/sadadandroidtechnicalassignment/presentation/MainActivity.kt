package com.rajabi.test.sadadandroidtechnicalassignment.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rajabi.test.sadadandroidtechnicalassignment.R
import com.rajabi.test.sadadandroidtechnicalassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
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


        binding.fetch.setOnClickListener {
            mainViewModel.parallelRequest()
            CoroutineScope(Main).launch {
                mainViewModel.getTenthCharacterTask.await().observe(this@MainActivity,
                    Observer {
                        binding.result10thChar.text =
                            binding.result10thChar.text.toString() + " " + it
                    })
                mainViewModel.getWordCounterTask.await().observe(this@MainActivity,
                    Observer {
                        binding.resultWordCount.text =
                            binding.resultWordCount.text.toString() + " " + it
                    })
                mainViewModel.getEveryTenthCharacterTask.await().observe(this@MainActivity,
                    Observer {
                        binding.resultEvery10thChar.text =
                            binding.resultEvery10thChar.text.toString() + " " + it
                    })

            }
        }
    }
}