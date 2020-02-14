package com.example.kotlinissues.presentation.view.listissues

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.ResponseIssues
import com.example.kotlinissues.R
import com.example.kotlinissues.databinding.ActivityMainBinding
import com.example.kotlinissues.presentation.util.base.BaseActivity
import com.example.kotlinissues.presentation.util.observe
import com.example.kotlinissues.presentation.view.issuedetail.IssueDetailFragment
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    protected lateinit var viewModel: MainActivityViewModel

    private lateinit var binding: ActivityMainBinding
    private var adapterListIssue: ListIssueAdapter = ListIssueAdapter { callbackItem(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lifecycle.addObserver(viewModel)
        subscribeUi()
        setupRecycler()
    }

    private fun subscribeUi() {
        with(viewModel) {
            listIssues.observe(this@MainActivity, ::onListIssues)
            error.observe(this@MainActivity, ::onError)
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
            .Builder(this)
            .setTitle(R.string.error_title)
            .setMessage(throwable?.message)
            .setPositiveButton(R.string.global_ok) { _, _ -> }
            .show()
    }

    private fun setupRecycler() {
        with(binding.recyclerViewIssues) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterListIssue
        }
    }

    private fun callbackItem(numberIssue: Long?) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_container, IssueDetailFragment.newInstance(numberIssue))
            .addToBackStack(null)
            .commit()
    }
}
