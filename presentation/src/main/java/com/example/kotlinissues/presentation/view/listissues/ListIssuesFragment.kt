package com.example.kotlinissues.presentation.view.listissues

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.ResponseIssues
import com.example.kotlinissues.R
import com.example.kotlinissues.databinding.FragmentListIssuesBinding
import com.example.kotlinissues.presentation.util.base.BaseFragment
import com.example.kotlinissues.presentation.util.observe
import com.example.kotlinissues.presentation.util.setupToolbar
import com.google.android.material.transition.MaterialFadeThrough
import javax.inject.Inject

class ListIssuesFragment : BaseFragment() {

    private lateinit var binding: FragmentListIssuesBinding

    @Inject
    protected lateinit var viewModel: ListIssuesFragmentViewModel

    private var adapterListIssue: ListIssueAdapter = ListIssueAdapter { callbackItem(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val backward = MaterialFadeThrough.create(requireContext()).setDuration(500)
        enterTransition = backward

        val forward = MaterialFadeThrough.create(requireContext()).setDuration(500)
        exitTransition = forward
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentListIssuesBinding.inflate(inflater, container, false)
        setupToolbar(binding.includedToolbar.toolbar)
        lifecycle.addObserver(viewModel)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
        setupRecycler()
    }

    private fun subscribeUi() {
        with(viewModel) {
            listIssues.observe(this@ListIssuesFragment, ::onListIssues)
            error.observe(this@ListIssuesFragment, ::onError)
        }
    }

    private fun onListIssues(listItens: List<ResponseIssues>?) {
        listItens?.let {
            adapterListIssue.setItens(it)
        }
        binding.progressBar.visibility = View.GONE
    }

    private fun onError(throwable: Throwable?) {
        AlertDialog
            .Builder(context)
            .setTitle(R.string.error_title)
            .setMessage(throwable?.message)
            .setPositiveButton(R.string.global_ok) { _, _ -> }
            .show()
    }

    private fun setupRecycler() {
        with(binding.recyclerViewIssues) {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterListIssue
        }
    }

    private fun callbackItem(numberIssue: Long?) {
        numberIssue?.let { numberIssue ->
            direction = ListIssuesFragmentDirections
                .actionListIssuesFragmentToIssueDetailFragment(numberIssue)
            controller.navigate(direction)
        }
    }
}