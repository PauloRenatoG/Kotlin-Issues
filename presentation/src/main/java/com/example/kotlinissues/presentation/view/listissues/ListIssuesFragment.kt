package com.example.kotlinissues.presentation.view.listissues

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinissues.databinding.FragmentListIssuesBinding
import com.example.kotlinissues.presentation.util.base.BaseFragment

class ListIssuesFragment : BaseFragment() {

    private lateinit var binding: FragmentListIssuesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentListIssuesBinding.inflate(inflater, container, false)

        return binding.root
    }
}