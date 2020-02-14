package com.example.kotlinissues.presentation.view.listissues

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.ResponseIssues
import com.example.kotlinissues.databinding.ListIssueItemBinding

class ListIssueViewHolder(
    private val binding: ListIssueItemBinding,
    private val callback: (Long?) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(issue: ResponseIssues) {
        with(binding) {
            this.issue = issue
            cardViewItem.setOnClickListener {
                callback.invoke(issue.number)
            }
        }
    }

    companion object {
        fun inflate(parent: ViewGroup, callback: (Long?) -> Unit): ListIssueViewHolder {
            return ListIssueViewHolder(
                ListIssueItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ),
                callback
            )
        }
    }
}