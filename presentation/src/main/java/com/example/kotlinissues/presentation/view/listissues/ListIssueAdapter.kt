package com.example.kotlinissues.presentation.view.listissues

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.ResponseIssues

class ListIssueAdapter(
    private val callBack: (Long?) -> Unit
) : RecyclerView.Adapter<ListIssueViewHolder>() {
    private var listItens: List<ResponseIssues> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListIssueViewHolder {
        return ListIssueViewHolder.inflate(parent, callBack)
    }

    override fun onBindViewHolder(holder: ListIssueViewHolder, position: Int) {
        holder.bind(listItens[position])
    }

    override fun getItemCount() = listItens.size

    fun setItens(listItens: List<ResponseIssues>) {
        this.listItens = listItens
        notifyDataSetChanged()
    }
}