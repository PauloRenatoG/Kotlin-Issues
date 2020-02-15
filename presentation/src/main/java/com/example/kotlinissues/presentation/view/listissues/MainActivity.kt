package com.example.kotlinissues.presentation.view.listissues

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kotlinissues.R
import com.example.kotlinissues.databinding.ActivityMainBinding
import com.example.kotlinissues.presentation.util.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
