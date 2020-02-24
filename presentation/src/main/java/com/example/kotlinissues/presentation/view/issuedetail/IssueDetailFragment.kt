package com.example.kotlinissues.presentation.view.issuedetail

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.domain.entity.IssueDetail
import com.example.kotlinissues.R
import com.example.kotlinissues.databinding.FragmentIssueDetailBinding
import com.example.kotlinissues.presentation.util.base.BaseFragment
import com.example.kotlinissues.presentation.util.loadImage
import com.example.kotlinissues.presentation.util.observe
import com.example.kotlinissues.presentation.util.setupToolbar
import com.google.android.material.transition.MaterialFadeThrough
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class IssueDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentIssueDetailBinding
    private val args by navArgs<IssueDetailFragmentArgs>()
    val numberIssue: Long by lazy { args.numberIssue }

    @Inject
    protected lateinit var viewModel: IssueDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val forward = MaterialFadeThrough.create(requireContext()).setDuration(500)
        enterTransition = forward

        val backward = MaterialFadeThrough.create(requireContext()).setDuration(500)
        exitTransition = backward
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentIssueDetailBinding.inflate(inflater, container, false)
        setupToolbar(binding.includedToolbar.toolbar)
        binding.includedToolbar.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)

        setClickListener()
        lifecycle.addObserver(viewModel)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            issueDetail.observe(this@IssueDetailFragment, ::onIssueDetail)
            error.observe(this@IssueDetailFragment, ::onError)
        }
    }

    private fun onIssueDetail(issueDetail: IssueDetail?) {
        with(binding) {
            progressBar.visibility = View.GONE
            buttonOpenIssue.visibility = View.VISIBLE
            this.issueDetail = issueDetail
            issueDetail?.createdAt?.let {
                textViewDate.text = getString(R.string.created_at, formatDate(it))
            }
            avatarUser.loadImage(issueDetail?.user?.avatarUrl)
        }
    }

    private fun onError(throwable: Throwable?) {
        AlertDialog
            .Builder(context)
            .setTitle(R.string.error_title)
            .setMessage(throwable?.message)
            .setPositiveButton(R.string.global_ok) { _, _ ->
                activity?.onBackPressed()
            }
            .show()
    }

    private fun setClickListener() {
        with(binding) {
            buttonOpenIssue.setOnClickListener {
                val browserIntent =
                    Intent(Intent.ACTION_VIEW, Uri.parse(issueDetail?.htmlUrl))
                startActivity(browserIntent)
            }
            includedToolbar.toolbar.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
    }

    private fun formatDate(date: Date): String {
        return SimpleDateFormat("dd/MM/YYYY", Locale("pt", "BR")).format(date)
    }
}