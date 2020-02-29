package com.example.kotlinissues.presentation.view.listissues

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.ResponseIssues

class ListIssueAdapter(
    private val callBack: (Long?) -> Unit
) : PagedListAdapter<ResponseIssues, ListIssueViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListIssueViewHolder {
        return ListIssueViewHolder.inflate(parent, callBack)
    }

    override fun onBindViewHolder(holder: ListIssueViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ResponseIssues>() {
            override fun areItemsTheSame(
                oldItem: ResponseIssues,
                newItem: ResponseIssues
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResponseIssues,
                newItem: ResponseIssues
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}