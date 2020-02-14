package com.example.data.mappers

import com.example.data.entity.ApiUser
import com.example.data.util.Mapper
import com.example.domain.entity.User
import javax.inject.Inject

class ApiUserToUserMapper @Inject constructor() : Mapper<ApiUser, User>() {
    override fun transform(t: ApiUser) = User(
        avatarUrl = t.avatarUrl,
        id = t.id,
        login = t.login
    )
}