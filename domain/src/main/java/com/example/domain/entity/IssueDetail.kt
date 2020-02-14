package com.example.domain.entity

import java.util.*

data class IssueDetail(
    val user: User? = null,
    val body: String? = null,
    val createdAt: Date? = null,
    val htmlUrl: String? = null,
    val id: Long? = null,
    val number: Long? = null,
    val title: String? = null
)